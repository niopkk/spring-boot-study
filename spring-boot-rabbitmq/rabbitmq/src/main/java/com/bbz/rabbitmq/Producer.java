package com.bbz.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
public class Producer {

    public static final String QUEQU_NAME = "rabbitMQ.test";
    public static final String QUEQU_NAME_1 = "rabbitMQ.test.1";

    public static final String EXCHANGE = "exchange_demo";

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.230");

        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //创建一个交换器
        channel.exchangeDeclare(EXCHANGE, "direct");


        //创建一个队列
        Map<String, Object> argss = new HashMap<>();
        argss.put("x-message-ttl", 6000);
        channel.queueDeclare(QUEQU_NAME, false, false, false, argss);
//        channel.queueDeclare(QUEQU_NAME_1, false, false, false, null);


        //将队列和交换器绑定
        channel.queueBind(QUEQU_NAME, EXCHANGE, "routingkey.*");//bindKey
//        channel.queueBind(QUEQU_NAME_1, EXCHANGE, "routingkey");

        String message = "hello,word";


        channel.basicPublish(EXCHANGE, "routingkey", new AMQP.BasicProperties.Builder().expiration("3000").build(), ("demo.........." + message).getBytes("UTF-8"));

        channel.close();

        connection.close();


    }


}
