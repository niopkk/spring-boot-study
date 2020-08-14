package com.bbz.demo1;

import com.bbz.util.Jsons;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Product {


    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        //获取一个连接对象
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();

        //创建一个交换器
        channel.exchangeDeclare("exchange_test", "direct", true, false, null);

        //创建一个队列
        channel.queueDeclare("queue_demo", false, false, false, null);

        //交换器和队列进行绑定
        channel.queueBind("queue_demo", "exchange_test", "routingkey_demo");

        String message = "hello";

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("id", "1000001");
        messageMap.put("name", "222222");
        messageMap.put("age", "222");

        //发送消息
        channel.basicPublish("exchange_test", "routingkey_demo",
                MessageProperties.PERSISTENT_TEXT_PLAIN, Jsons.toJson(messageMap).getBytes());

        channel.close();
        connection.close();
    }
}
