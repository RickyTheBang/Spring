package housekeeping;

import housekeeping.services.DomesticService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_H01_Opdracht05 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_H01_Opdracht05.class);) {
            DomesticService king = ctx.getBean ("domesticService", DomesticService.class);
            king.runHouseHold ();

        }

    }
}
