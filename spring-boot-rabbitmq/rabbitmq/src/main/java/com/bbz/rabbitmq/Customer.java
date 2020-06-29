package com.bbz.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    public static final String QUEQU_NAME = "rabbitMQ.test";
    public static final String QUEQU_NAME_1 = "rabbitMQ.test.1";

    public static void main(String[] args) throws IOException, TimeoutException {

        System.out.println("3");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.230");
        Connection connection = factory.newConnection();


        Channel channel = connection.createChannel();



        channel.queueDeclare(QUEQU_NAME, false, false, false, null);
        channel.queueDeclare(QUEQU_NAME_1, false, false, false, null);

        System.out.println("Customer Waiting Received messages");


        Consumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
//                if (message.equals("demo..........hello,word:2")) {
//                    channel.basicReject(envelope.getDeliveryTag(), true);
//                }
                System.out.println(message.equals("demo..........hello,word:2"));
                System.out.println("Customer Received '" + message + "'");
                System.out.println("envelope " + envelope.getDeliveryTag());
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

        channel.basicConsume(QUEQU_NAME, false, defaultConsumer);
        channel.basicConsume(QUEQU_NAME_1, false, defaultConsumer);
    }
}
