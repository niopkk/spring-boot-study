package com.bbz.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Product {


    /**
     * 交互器
     */
    private final static String EXCHANGE_NAME = "exchange_demo";

    private final static String ROUTING_KEY = "routingkey_demo";

    private final static String QUEUE_NAME = "queue_demo";

    private final static String IP_ADDRESS = "104.225.153.147";

    private final static int PORT = 5672;//默认端口号

    public static void main(String[] args) throws IOException, TimeoutException {


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(IP_ADDRESS);
        factory.setPort(PORT);

        /**
         * 创建连接
         */
        final Connection connection = factory.newConnection();
        /**
         *创建信道
         */
        final Channel channel = connection.createChannel();

        /**
         * 创建一个type为direct、持久化、非自动删除的交换器
         */
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);

        /**
         * 创建一个持久化、非排他的、非自动删除的队列
         */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        /**
         * 将交换器与队列通过路由键绑定
         */
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

        String message = "hello word";

        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, MessageProperties.TEXT_PLAIN, message.getBytes());

        channel.close();
        connection.close();

    }
}
