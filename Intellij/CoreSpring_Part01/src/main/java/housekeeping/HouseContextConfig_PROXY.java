package housekeeping;

import housekeeping.services.CleaningService;
import housekeeping.services.CleaningServiceImpl;
import housekeeping.tools.*;
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
