package com.bbz.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生产者
 */
public class Producer {

    public static final String QUEQU_NAME = "rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //创建一个队列
        channel.queueDeclare(QUEQU_NAME, false, false, false, null);

        String message = "hello,word";
        for (int i = 0; i < 3; i++) {
            channel.basicPublish("", QUEQU_NAME, null, (message + ":" + i).getBytes("UTF-8"));
        }


//        System.out.println("Producer Send +'" + message + "'");

        channel.close();

        connection.close();




    }






}
