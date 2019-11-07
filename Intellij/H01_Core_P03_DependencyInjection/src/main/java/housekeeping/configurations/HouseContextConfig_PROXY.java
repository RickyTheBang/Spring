package housekeeping.configurations;

import housekeeping.services.CleaningService;
import housekeeping.services.implementation.CleaningServiceImpl;
import housekeeping.tools.*;
import housekeeping.tools.implementation.DisposableDusterPROXY;
import org.springframework.context.annotation.*;

@Configuration
public class HouseContextConfig_PROXY {

    @Scope(value = "prototype")
    public CleaningTool disposalDuster() {
        return new DisposableDusterPROXY ( );
    }


    @Bean(name = "scottService")

    public CleaningService scott() {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (disposalDuster ( ));
        return cs;
    }


}
