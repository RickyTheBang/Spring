package housekeeping.configurations;

import housekeeping.services.CleaningService;
import housekeeping.services.implementation.CleaningServiceImpl;
import housekeeping.tools.implementation.Broom;
import housekeeping.tools.CleaningTool;
import housekeeping.tools.implementation.Sponge;
import housekeeping.tools.implementation.VacuumCleaner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HouseContextConfig_V02 {
    @Bean
    public CleaningTool broom() {
        return new Broom ( );
    }

    @Bean
    public CleaningTool vacuum() {
        return new VacuumCleaner ( );
    }

    @Bean
    public CleaningTool sponge() {
        return new Sponge ( );
    }

    @Bean
    public CleaningService jill() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (broom ( ));
        return cs;
    }

    @Bean
    public CleaningService bob() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (vacuum ( ));
        return cs;
    }

    @Bean
    public CleaningService jane() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (sponge ( ));
        return cs;
    }


}
