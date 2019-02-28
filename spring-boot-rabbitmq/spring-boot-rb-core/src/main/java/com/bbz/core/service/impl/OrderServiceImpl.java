package com.bbz.core.service.impl;

import com.bbz.core.config.Constants;
import com.bbz.core.entity.BrokerMessageLog;
import com.bbz.core.entity.Order;
import com.bbz.core.repository.OrderRepository;
import com.bbz.core.service.BrokerMessageLogService;
import com.bbz.core.service.OrderProducerService;
import com.bbz.core.service.OrderService;
import com.bbz.pojo.dto.OrderDTO;

import com.bbz.util.Dates;
import com.bbz.util.Jsons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private static final int minutes = 1;

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private OrderProducerService orderProducerService;

    @Autowired
    private BrokerMessageLogService brokerMessageLogService;


    @Override
    @Transactional
    public void createOrder(Order order) {

        orderRepository.save(order);//保存订单

        BrokerMessageLog bml = new BrokerMessageLog();

        bml.setMessage(Jsons.toJson(order)); //消息体
        bml.setCreateTime(Dates.unixNow()); //创建时间
        bml.setMessageId(order.getMessageId());//消息id
        bml.setStatus(Constants.ORDER_SENDING);//消息状态

        bml.setNextRetry(Dates.unixNow() + minutes * 60000);//下次重试时间
        bml.setTryCount(0);//初始重试次数0
        brokerMessageLogService.saveBrokerMessageLog(bml);

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setMessageId(order.getMessageId());
        dto.setName(order.getName());
        try {
            orderProducerService.send(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
