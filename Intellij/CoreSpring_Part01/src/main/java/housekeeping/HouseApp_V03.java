package housekeeping;

import housekeeping.configurations.HouseContextConfig_V03;
import housekeeping.services.CleaningService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V03 {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_V03.class);) {
            CleaningService jill1 = ctx.getBean ("jillService", CleaningService.class);
            CleaningService jill2 = ctx.getBean ("jillService", CleaningService.class);
            CleaningService jill3 = ctx.getBean ("jillService", CleaningService.class);
            CleaningService bob = ctx.getBean ("bobService", CleaningService.class);
            CleaningService jane = ctx.getBean ("janeService", CleaningService.class);
            CleaningService scott = ctx.getBean ("scottService", CleaningService.class);
            jill1.clean ( );
            jill1.clean ( );
            jill1.clean ( );
            jill2.clean ( );
            jill3.clean ( );
            bob.clean ( );
            jane.clean ( );
            scott.clean ();
            scott.clean ();

        }

    }
}
