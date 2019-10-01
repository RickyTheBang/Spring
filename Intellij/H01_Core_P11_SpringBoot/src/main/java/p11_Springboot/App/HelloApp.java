package p11_Springboot.App;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import p11_Springboot.AppConfig;
import p11_Springboot.model.*;

public class HelloApp {





    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Hello hello = ctx.getBean ("helloImpl",HelloImpl.class);


        System.out.println (hello.sayHello () );
    }


}
