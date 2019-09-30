package housekeeping;

import housekeeping.configurations.OutHouseContextConfig_V04;
import housekeeping.services.GardeningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OutHouse_V04App {

    public static void main(String[] args) {
        try(ConfigurableApplicationContext applicationContext
                =new AnnotationConfigApplicationContext (OutHouseContextConfig_V04.class)){
            applicationContext.getBean ("gardeningService", GardeningService.class).garden ();
        }
    }
}
