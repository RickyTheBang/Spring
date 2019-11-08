package com.app;


import com.domain.Message;
import com.repository.MessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;


@SpringBootApplication(scanBasePackages = "com")
public class MessageApp {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(MessageApp.class, args);

        MessageRepository mr = ctx.getBean("messageRepository", MessageRepository.class);

        mr.save (new Message ("Hello"));
        List<Message> messages = mr.getALLMessages ();

        for(Message m : messages){
            System.out.println(m);
        }
    }}

