package com.bbz.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {

    public static void main(String[] args) throws JMSException {

        String url = "tcp://localhost:61616";
        String TOPIC_NAME = "top01";

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);

        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        MessageProducer messageProducer = session.createProducer(topic);


        for (int i = 0; i < 3; i++) {

            TextMessage textMessage = session.createTextMessage("top。。。。。。。" + i);
            messageProducer.send(textMessage);
        }
        messageProducer.close();
        session.close();
        connection.close();


    }
}
