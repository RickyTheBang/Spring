package housekeeping;

import housekeeping.configurations.HouseContextConfig_V11;
import housekeeping.services.DomesticService;
import housekeeping.services.implementation.FrenchCook;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V11 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext ( )) {
            ctx.getEnvironment ( ).setActiveProfiles ("smallHouse");
            ctx.register (HouseContextConfig_V11.class);
            ctx.refresh ( );
            ctx.start ( );
           /* DomesticService service = ctx.getBean ("domesticServiceImpl", DomesticService.class);
            service.runHouseHold ( );
            FrenchCook frenchCook = ctx.getBean ("frenchcook", FrenchCook.class);
            frenchCook.makeLunch ( );*/

        }

    }
}
