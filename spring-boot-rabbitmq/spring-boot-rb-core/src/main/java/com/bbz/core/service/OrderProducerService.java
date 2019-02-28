package com.bbz.core.service;


import com.bbz.pojo.dto.OrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface OrderProducerService extends RabbitTemplate.ConfirmCallback {


    /**
     * 消息发送
     *
     * @param order
     */
    void send(OrderDTO order) throws Exception;
}
