package com.bbz.activemq.quequ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {

    public static void main(String[] args) throws JMSException {


        String url = "tcp://localhost:61616";
        String QUEUE_NAME = "queue01";
        //第一步创建连接
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(url);
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("msg--" + i);

            producer.send(textMessage);
        }

        producer.close();
        session.close();
        connection.close();


        System.out.println("成功");

    }
}
