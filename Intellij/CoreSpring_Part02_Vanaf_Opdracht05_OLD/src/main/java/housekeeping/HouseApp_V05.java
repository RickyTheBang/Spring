package housekeeping;

import housekeeping.configurations.HouseContextConfig_V05;

import housekeeping.tools.*;
import housekeeping.tools.implementation.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HouseApp_V05 {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext (HouseContextConfig_V05.class) ){
            CleaningTool broom = ctx.getBean ("MyBroom",CleaningTool.class);
            broom.doCleanJob ();

        }

    }
}
