package com.bbz.producer.task;

import com.bbz.core.config.Constants;
import com.bbz.core.service.BrokerMessageLogService;
import com.bbz.core.service.OrderProducerService;
import com.bbz.pojo.dto.OrderDTO;
import com.bbz.util.Dates;
import com.bbz.util.Jsons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TrySendTask {


    @Autowired
    private BrokerMessageLogService brokerMessageLogService;

    @Autowired
    private OrderProducerService orderProducerService;


    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void rabbitmqReSend() {
        System.out.println("任务开始执行-------------");
        /**
         *
         * 查询出下一次执行时间小于当前时间的日志记录并且状态为投递中，
         * 遍历结果集，判断重试次数是或大于3次，如果大于，将日志设置为投递失败，
         * 如果小于 则尝试重新投递，并改变数据库中日志的尝试次数
         *
         */
        brokerMessageLogService.findByStatusAndNextRetry(Constants.ORDER_SENDING, Dates.unixNow())
                .forEach(bml -> {
                    if (bml.getTryCount() >= 3) {
                        bml.setStatus(Constants.ORDER_SEND_FAILURE);
                        bml.setUpdateTime(Dates.unixNow());
                        brokerMessageLogService.saveBrokerMessageLog(bml);
                    } else {
                        bml.setTryCount(bml.getTryCount() + 1);
                        bml.setUpdateTime(Dates.unixNow());
                        brokerMessageLogService.saveBrokerMessageLog(bml);
                        try {
                            orderProducerService.send(Jsons.fromJson(bml.getMessage(),OrderDTO.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

    }
}
