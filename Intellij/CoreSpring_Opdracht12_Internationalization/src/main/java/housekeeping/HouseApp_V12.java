package housekeeping;

import housekeeping.configurations.HouseContextConfig_V12;
import housekeeping.services.CleaningService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V12 {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext ( )) {
            ctx.getEnvironment ( ).setActiveProfiles ("smallHouse");
            ctx.register (HouseContextConfig_V12.class);
            ctx.refresh ( );
            CleaningService service =ctx.getBean ("cleaningServiceImpl",CleaningService.class);
               service.clean ();

            //System.out.println ("${name}" );


        }

    }
}
