package com;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");

        return connectionFactory;
    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        String queueName = "haha";
        MyMessageSender ms = context.getBean(MyMessageSender.class);
        ms.sendMessage(queueName, "test message");

        MyMessageReceiver mr = context.getBean(MyMessageReceiver.class);
        mr.receiveMessage(queueName);
    }
}