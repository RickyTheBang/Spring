package housekeeping;

import housekeeping.services.DomesticService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V04 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_V04.class);) {
            DomesticService king = ctx.getBean ("king", DomesticService.class);
            king.runHouseHold ();

        }

    }
}
