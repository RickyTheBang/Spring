package JMS.app;


import JMS.component.HelloSender;
import JMS.component.HelloSenderDESTROY;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "JMS")
public class HelloJmsClient {
    public static void main(String[] args) throws  Exception{
        ConfigurableApplicationContext ctx = SpringApplication.run(HelloJmsClient.class,args);
        HelloSender sender = ctx.getBean("helloSender", HelloSender.class);
        sender.sendHello("Here is Manchester");
        System.out.println("message sent");

    }
}
