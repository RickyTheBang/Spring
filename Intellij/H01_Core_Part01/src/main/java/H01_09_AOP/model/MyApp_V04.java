package H01_09_AOP.model;

import housekeeping.configurations.HouseContextConfig_V04;
import housekeeping.services.CleaningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp_V04 {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_V04.class)){
            CleaningService jill = ctx.getBean("jillService",CleaningService.class);
            jill.clean();
            System.out.println("inside v04");

        }
    }
}
