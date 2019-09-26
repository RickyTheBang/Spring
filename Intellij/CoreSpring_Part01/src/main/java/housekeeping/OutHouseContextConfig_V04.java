package housekeeping;

import housekeeping.services.CleaningService;
import housekeeping.services.CleaningServiceImpl;
import housekeeping.services.GardenServiceImplementation;
import housekeeping.services.GardeningService;
import housekeeping.tools.*;
import org.springframework.context.annotation.*;

@Configuration
public class OutHouseContextConfig_V04 {
    @Bean
    public GardeningTool lawnMower(){
        return new LawnMower ();
    }

    @Bean
    public     GardeningService gardeningService(GardeningTool gardeningTool){
        GardenServiceImplementation gs = new GardenServiceImplementation ();
        gs.setGardeningTool (lawnMower ());

        return gs;
    }



}
