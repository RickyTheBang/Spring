package RESTfulWebServicesOpdracht08.application;


import RESTfulWebServicesOpdracht08.AppConfig;
import RESTfulWebServicesOpdracht08.model.Message;
import RESTfulWebServicesOpdracht08.repository.MessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;


@SpringBootApplication(scanBasePackages = "RESTfulWebServicesOpdracht08")

public class MessageServerApp {


    public static void main(String[] args) {



        ConfigurableApplicationContext ctx = SpringApplication.run(MessageServerApp.class, args);
        MessageRepository mr = ctx.getBean("messageRepository", MessageRepository.class);

        mr.createMessage(new Message(2, "joe", "goodbye"));
        List<Message> messageList = mr.getAllMessages();
        for (Message m : messageList) {
            System.out.println(m);
        }
    }
}
