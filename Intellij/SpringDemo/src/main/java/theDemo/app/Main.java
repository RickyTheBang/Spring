package theDemo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import theDemo.AppConfig;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext (AppConfig.class);
        context.getEnvironment ().setActiveProfiles (new String[]{"BXL"});
        context.refresh ();
        context.getBean ("createWharehouseService()");
    }
}
