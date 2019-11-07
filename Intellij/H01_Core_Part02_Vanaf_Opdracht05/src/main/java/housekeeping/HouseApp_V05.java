package housekeeping;

import housekeeping.configurations.HouseContextConfig_V05;
import housekeeping.factory.HedgeTrimmerFactory;
import housekeeping.services.DomesticService;
import housekeeping.services.implementation.CleaningRobot;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V05 {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_V05.class) ){

            //1) Domestic
            System.out.println ("1) DOMESTIC" );
            DomesticService domesticService = ctx.getBean("domesticServiceImpl",DomesticService.class);
            domesticService.runHouseHold ();

            //2) Robot
            System.out.println ("2) ROBOT" );
            CleaningRobot robot = ctx.getBean("cleaningRobot",CleaningRobot.class);
            robot.clean ();
            //3) HEDGE TRIMMER
            System.out.println ("3) EDGE TRIMMER" );
            HedgeTrimmerFactory hedgeTrimmerFactory = ctx.getBean("hedgeTrimmerFactory",HedgeTrimmerFactory.class);
            hedgeTrimmerFactory.hedgeTrimmer ().doGardenJob ();

        }

    }
}
