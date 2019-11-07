package housekeeping.configurations;

import housekeeping.services.implementation.GardenServiceImplementation;
import housekeeping.services.GardeningService;
import housekeeping.tools.*;
import housekeeping.tools.implementation.LawnMower;
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
