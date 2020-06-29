package com.bbz.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;

import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ThreadProduct implements Runnable {

    private Channel channel;
    private String message;

    public ThreadProduct(Channel channel, String message) {
        this.channel = channel;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            channel.confirmSelect();
            for (int i = 0; i < 20; i++) {

                final long deliveryTag = channel.getNextPublishSeqNo();
                channel.basicPublish("exchange.normal", "rk",
                        new AMQP.BasicProperties().builder().contentType("text/plain").build(), (message + Thread.currentThread().getId() + "......." + deliveryTag).getBytes("UTF-8"));


                //发送方确定消息是否到达
//                if (channel.waitForConfirms()) {
//                    System.out.println("发送成功1！");
//                }

            }


            channel.addConfirmListener(new ConfirmListener() {
                @Override
                public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                    System.out.println("已确认消息：" + deliveryTag + "................." + multiple);
                }

                @Override
                public void handleNack(long deliveryTag, boolean multiple) throws IOException {

                    System.out.println("未确认消息" + deliveryTag + ":" + multiple);
                }
            });
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
