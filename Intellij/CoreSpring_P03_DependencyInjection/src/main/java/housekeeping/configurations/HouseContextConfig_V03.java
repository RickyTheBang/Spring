package housekeeping.configurations;

import housekeeping.services.CleaningService;
import housekeeping.services.implementation.CleaningServiceImpl;
import housekeeping.tools.*;
import housekeeping.tools.implementation.Broom;
import housekeeping.tools.implementation.DisposableDuster;
import housekeeping.tools.implementation.Sponge;
import housekeeping.tools.implementation.VacuumCleaner;
import org.springframework.context.annotation.*;

@Configuration
public class HouseContextConfig_V03 {
    @Bean
    @Scope("prototype")
    public CleaningTool broom() {
        return new Broom ( );
    }

    @Bean
    @Scope("prototype")
    public CleaningTool vacuum() {
        return new VacuumCleaner ( );
    }

    @Bean
    @Scope("prototype")
    public CleaningTool sponge() {
        return new Sponge ( );
    }
    @Bean
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
    public CleaningTool disposalDuster() {
        return new DisposableDuster ( );
    }

    @Bean(name = "jillService")
   // @Lazy
    @Scope("prototype")
    public CleaningService jill() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (broom ( ));
        return cs;
    }


    @Bean(name = "bobService")
    @Lazy
    public CleaningService bob() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (vacuum ( ));
        return cs;
    }

    @Bean(name = "janeService")
    @Lazy
    public CleaningService jane() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (sponge ( ));
        return cs;
    }

    @Bean(name = "scottService")
    @Lazy
    public CleaningService scott() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (disposalDuster ( ));
        return cs;
    }


}
