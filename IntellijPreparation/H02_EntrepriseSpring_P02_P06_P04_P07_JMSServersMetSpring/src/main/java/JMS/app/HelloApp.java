package JMS.app;

import JMS.AppConfig;
import JMS.component.HelloReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.JMSException;

@SpringBootApplication(scanBasePackages = "JMS")
@EnableJms
public class HelloApp {
    public static void main(String[] args) throws JMSException {
      //  SpringApplication.run(HelloApp.class,args);
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class,args);
        HelloReceiver receiver = ctx.getBean("helloReceiver",HelloReceiver.class);
        receiver.receiveHello();


    }
}

