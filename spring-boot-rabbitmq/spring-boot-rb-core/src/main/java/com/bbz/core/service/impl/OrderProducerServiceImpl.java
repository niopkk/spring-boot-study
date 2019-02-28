package com.bbz.core.service.impl;

import com.bbz.core.config.Constants;
import com.bbz.core.entity.BrokerMessageLog;
import com.bbz.core.service.BrokerMessageLogService;
import com.bbz.core.service.OrderProducerService;
import com.bbz.pojo.dto.OrderDTO;
import com.bbz.util.Dates;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OrderProducerServiceImpl implements OrderProducerService {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private BrokerMessageLogService brokerMessageLogService;

    @PostConstruct
    private void init() {
        this.rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        String messageId = correlationData.getId();
        if (ack) {
            BrokerMessageLog bml = brokerMessageLogService.findByMessageId(messageId);
            bml.setStatus(Constants.ORDER_SEND_SUCCESS);
            bml.setUpdateTime(Dates.unixNow());
            brokerMessageLogService.saveBrokerMessageLog(bml);
            System.out.println("消息发送成功!:" + correlationData);
        } else {
            System.out.println("消息发送失败!:" + cause);
        }
    }

    @Override
    public void send(OrderDTO order) {
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());
        /**
         * 如果发送的数据是类必须用Serializable进行修饰,否则不能进行序列化
         */
        rabbitTemplate.convertAndSend("order-exchange",
                "order.www",
                order,
                correlationData);
    }
}
