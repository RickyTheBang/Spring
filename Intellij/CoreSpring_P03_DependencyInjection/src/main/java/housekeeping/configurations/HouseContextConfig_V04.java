package housekeeping.configurations;

import housekeeping.services.*;
import housekeeping.services.implementation.CleaningServiceImpl;
import housekeeping.services.implementation.DomesticServiceImpl;
import housekeeping.services.implementation.GardenServiceImplementation;
import housekeeping.tools.*;
import housekeeping.tools.implementation.*;
import org.springframework.context.annotation.*;

@Configuration
public class HouseContextConfig_V04 {



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
    @Scope(value = "prototype",proxyMode = ScopedProxyMode.INTERFACES)
    public CleaningTool disposalDuster() {
        return new DisposableDuster ( );
    }

    @Bean(name = "jillService")
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

    @Bean
    public GardeningTool lawnMower(){
        return new LawnMower ();
    }

    @Bean
    public GardeningService gardeningService(){
        GardenServiceImplementation gs = new GardenServiceImplementation ();
        gs.setGardeningTool (lawnMower ());
        return gs;
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
