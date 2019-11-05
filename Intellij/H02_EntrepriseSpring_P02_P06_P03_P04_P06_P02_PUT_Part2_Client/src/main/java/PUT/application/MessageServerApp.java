package PUT.application;


import PUT.component.MessagesClient;
import PUT.model.Message;
import PUT.model.MessageList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


@SpringBootApplication(scanBasePackages = "PUT")

public class MessageServerApp {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.requestFactory(HttpComponentsClientHttpRequestFactory::new).build();
    }

    public static void main(String[] args) {



        ConfigurableApplicationContext ctx = SpringApplication.run(MessageServerApp.class, args);
        MessagesClient messagesClient = ctx.getBean(MessagesClient.class);
        //1) by id
        System.out.println ("message by id" );
        Message message = messagesClient.getMessageById(1);
        System.out.println(message);
        //2) message list
        System.out.println ("message list" );
        MessageList messageList = messagesClient.getMessages();
        List<Message> messages =messageList.getMessageList();
        for(Message m:messages){
            System.out.println(m);
        }

        //3) message by author
        System.out.println ("message by author" );
        MessageList messageListByAuthor = messagesClient.getMessagesByAuthor ("Homer");
        List<Message> messagesByAuthor =messageListByAuthor.getMessageList();
        for(Message m:messagesByAuthor){
            System.out.println(m);
        }

        //4) Create Message
        System.out.println ("Create Message" );
      Message message4 = new Message (4,"Bill","Here I am");
      URI uri = messagesClient.createMessage (message4);
        System.out.println (uri.toString () );

    }
}
