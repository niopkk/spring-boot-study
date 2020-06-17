package com.bbz.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class DLXProduct {

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.230");

        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //创建一个交换器
        channel.exchangeDeclare("exchange.dlx", "direct");
        channel.exchangeDeclare("exchange.normal", "fanout");


        //创建一个队列
        Map<String, Object> argss = new HashMap<>();
        argss.put("x-message-ttl", 10000);
        argss.put("x-dead-letter-exchange", "exchange.dlx");//死信交换器
        argss.put("x-dead-letter-routing-key", "routingkey");//死信路由键


        channel.queueDeclare("queue.normal", true, false, false, argss);

        channel.queueDeclare("queue.dlx", true, false, false, null);


        channel.queueBind("queue.normal", "exchange.normal", "");

        channel.queueBind("queue.dlx", "exchange.dlx", "routingkey");//死信路由键

        for (int i = 0; i < 230; i++) {
//            String sd = String.valueOf(1000 * (new Random().nextInt(15) + 1));
            channel.basicPublish("exchange.normal", "rk",
                    new AMQP.BasicProperties().builder().contentType("text/plain").build(), ("dlx").getBytes("UTF-8"));

        }


//        channel.close();
//
//        connection.close();

    }
}
