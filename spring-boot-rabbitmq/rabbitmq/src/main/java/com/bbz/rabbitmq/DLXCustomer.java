package com.bbz.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class DLXCustomer {

    public static void main(String[] args) throws IOException, TimeoutException {

        System.out.println("3");
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.10.230");
        Connection connection = factory.newConnection();


        Channel channel = connection.createChannel();


//        channel.queueDeclare("street-news-queue", false, false, false, null);


        Consumer defaultConsumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
//                if (message.equals("demo..........hello,word:2")) {
//                    channel.basicReject(envelope.getDeliveryTag(), true);
//                }
                System.out.println("Customer Received " + message);


            }
        };

        channel.basicConsume("queue.dlx", true, defaultConsumer);




    }
}

