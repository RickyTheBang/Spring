package theDemo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import theDemo.AppConfig;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext (AppConfig.class);
        context.getBean ("createWharehouseService()");
    }
}
