package com.bbz.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.*;

public class Customer {

    private final static String QUEUE_NAME = "queue_demo";

    private final static String IP_ADDRESS = "74.120.175.100";

    private final static int PORT = 5672;//默认端口号

    private final static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Address[] address = new Address[]{new Address(IP_ADDRESS, PORT)};

        ConnectionFactory factory = new ConnectionFactory();

        final Connection connection = factory.newConnection(address);

        executorService.execute(() -> {
            final Channel channel;
            try {
                channel = connection.createChannel();
                channel.basicQos(64);
                final Consumer consumer = new DefaultConsumer(channel) {
                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                        System.out.println("recv message: " + new String(body));
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                };
                final String s = channel.basicConsume(QUEUE_NAME,false, consumer);
                //等待回调函数执行完毕之后，关闭资源
                TimeUnit.SECONDS.sleep(5);
                channel.close();
                connection.close();
            } catch (IOException | InterruptedException | TimeoutException e) {
                e.printStackTrace();
            }
        });


    }
}
