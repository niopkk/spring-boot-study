package com.bbz.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer {

    public static final String QUEQU_NAME = "rabbitMQ.test";

    public static void main(String[] args) throws IOException, TimeoutException {

        System.out.println("3");
        ConnectionFactory factory = new ConnectionFactory();

        Connection connection = factory.newConnection();


        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEQU_NAME, false, false, false, null);

        System.out.println("Customer Waiting Received messages");

        Consumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };

        channel.basicConsume(QUEQU_NAME, true, defaultConsumer);
    }
}