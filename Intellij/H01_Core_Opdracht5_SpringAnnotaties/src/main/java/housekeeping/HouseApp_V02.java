package housekeeping;

import housekeeping.services.CleaningServiceImpl;
import housekeeping.tools.Broom;
import housekeeping.tools.CleaningTool;
import housekeeping.tools.Sponge;
import housekeeping.tools.VacuumCleaner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V02 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext (HouseContextConfig.class);
        CleaningTool cleaningTool = applicationContext.getBean ("broom",CleaningTool.class);
        cleaningTool.doCleanJob ();



    }
}
