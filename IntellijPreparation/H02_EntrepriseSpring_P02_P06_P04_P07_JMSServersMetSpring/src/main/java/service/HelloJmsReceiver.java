package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;


@Service("helloJmsReceiver")
public class HelloJmsReceiver {

    @Autowired
    public void configure(DefaultJmsListenerContainerFactory fact){
        fact.setPubSubDomain(true);
    }

    @JmsListener(destination = "HelloQueue")
    public void onMessage(Message msg){
        try{
            if(msg instanceof TextMessage){
                String text = ((TextMessage) msg).getText();
                System.out.println("The guy said : " +text);

            }
        }catch (JMSException e){
            e.printStackTrace();
        }
    }
}
