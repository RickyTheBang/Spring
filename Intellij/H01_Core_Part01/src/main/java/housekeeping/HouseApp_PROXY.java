package housekeeping;

import housekeeping.configurations.HouseContextConfig_PROXY;
import housekeeping.services.CleaningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_PROXY {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_PROXY.class);) {

            CleaningService scott = ctx.getBean ("scottService", CleaningService.class);
            scott.clean ();
            scott.clean ();

        }

    }
}
