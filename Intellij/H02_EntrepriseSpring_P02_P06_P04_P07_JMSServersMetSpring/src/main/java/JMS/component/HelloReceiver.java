package JMS.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component("helloReceiver")
public class HelloReceiver {

    @Autowired
    private JmsTemplate jmsTemplate;



    public void receiveHello() throws JMSException {
       // jmsTemplate.setPubSubDomain(true);
        jmsTemplate.setDefaultDestinationName("queue.HelloQueue");
       /* jmsTemplate.setDefaultDestination("queue.HelloQueue");
        jmsTemplate.getDefaultDestination("queue.HelloQueue");*/
        Message message = jmsTemplate.receive("HelloQueue");
        if(message!=null && message instanceof TextMessage){
            System.out.println(((TextMessage)message).getText());
            System.out.println("what message?");
        }else {
            System.out.println("no message!");
        }




    }

}
