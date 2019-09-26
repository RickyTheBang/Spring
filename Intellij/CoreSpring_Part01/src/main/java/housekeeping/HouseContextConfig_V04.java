package housekeeping;

import housekeeping.services.*;
import housekeeping.tools.*;
import org.springframework.context.annotation.*;

@Configuration
public class HouseContextConfig_V04 {

    @Bean
    public GardeningTool lawnMower(){
        return new LawnMower ();
    }

    @Bean
    public GardeningService gardeningService(GardeningTool gardeningTool){
        GardenServiceImplementation gs = new GardenServiceImplementation ();
        gs.setGardeningTool (lawnMower ());
        return gs;
    }
    @Bean
    @Primary
    public CleaningTool broom() {
        return new Broom ( );
    }



    @Bean(name = "jillService")
    public CleaningService jill(CleaningTool tool) {
        CleaningServiceImpl cs = new CleaningServiceImpl ( );
        cs.setCleaningTool (tool);
        return cs;
    }

    @Bean
    public DomesticService king(){
        DomesticServiceImpl ds = new DomesticServiceImpl ();
        ds.setCleaningService (jill ());
        ds.setGardeningService (gardeningService());

        ds.runHouseHold ();
        return ds;
    }





}
