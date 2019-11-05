package soapProjectClient.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import soapProjectClient.AppConfig;
import soapproject.web.HelloServiceEndpoint;


@SpringBootApplication(scanBasePackages = "soapProjectClient")
public class HelloWSClientApp {


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class,args);

        HelloServiceEndpoint helloService = ctx.getBean("hello",HelloServiceEndpoint.class);
        String response = helloService.sayHello("Mike");
        System.out.println(response);

    }

}
