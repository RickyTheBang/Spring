package JMS.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


@Component
public class HelloSender {


    //private ConnectionFactory connectionFactory;
    @Autowired
    private JmsTemplate jmsTemplate;

/*@PostConstruct
public void init(){
    this.jmsTemplate = new JmsTemplate(connectionFactory);
}*/

    public void sendHello(String text) {

        jmsTemplate.send("HelloQueue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                String defaultDestination  =jmsTemplate.getDefaultDestinationName();

                System.out.println(defaultDestination);
                return session.createTextMessage(text);
            }
        });



    }

}
