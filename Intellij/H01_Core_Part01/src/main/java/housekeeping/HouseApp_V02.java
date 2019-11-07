package housekeeping;

import housekeeping.configurations.HouseContextConfig_V02;
import housekeeping.services.CleaningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V02 {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_V02.class);) {
            CleaningService jill = ctx.getBean ("jill", CleaningService.class);
            CleaningService bob = ctx.getBean ("bob", CleaningService.class);
            CleaningService jane = ctx.getBean ("jane", CleaningService.class);
            jill.clean ( );
            bob.clean ( );
            jane.clean ( );

        }

    }
}
