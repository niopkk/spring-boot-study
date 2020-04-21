package com.bbz.activemq.quequ;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer {

    public static void main(String[] args) throws JMSException, InterruptedException, IOException {

        System.out.println(2);

        String url = "tcp://localhost:61616";
        String QUEUE_NAME = "queue01";
        //第一步创建连接
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(url);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);

        MessageConsumer messageConsumer = session.createConsumer(queue);


//        while (true) {
//            TextMessage receive = (TextMessage) consumer.receive(4000);
//
//            if (receive != null) {
//                System.out.println(receive.getText());
//            } else {
//                break;
//            }
//
//        }
//        consumer.close();
//        session.close();
//        connection.close();
//
//
//        System.out.println("成功");

        messageConsumer.setMessageListener(new MessageListener() {
            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                if (message != null && message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                }
            }
        });
        Thread.sleep(1000);
//        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
