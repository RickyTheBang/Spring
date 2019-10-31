package JMS.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class HelloSenderSimple {

    @Autowired
    private JmsTemplate jmsTemplate;



    public void sendHello(String text) {
       // jmsTemplate.setPubSubDomain(true);
        System.out.println("inside method");
       jmsTemplate.setDefaultDestinationName("HelloQueue");
        String defaultDestination  =jmsTemplate.getDefaultDestinationName();

        System.out.println(defaultDestination);
        jmsTemplate.convertAndSend("HelloQueue",text);



    }

}
