package housekeeping.services.implementation;

import housekeeping.services.CleaningService;
import housekeeping.services.DomesticService;
import housekeeping.services.GardeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component("domesticServiceImpl")
@Qualifier("theDomesticServiceImpl")
public class DomesticServiceImpl implements DomesticService {
    private Logger logger;
    private CleaningService cleaningService;
    private GardeningService gardeningService;

    @Autowired
    public void setLogger(Logger logger){
        this.logger = logger;
    }

    @Autowired
    public void setCleaningService(@Qualifier("theCleaningServiceImpl") CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }
    @Autowired
    public void setGardeningService(@Qualifier("theGardenServiceImplementation") GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    @Override
    public void runHouseHold() {
        logger.info ("LOGGER - Running household");
        System.out.println ("\nDOMESTIC SERVICE LIMITED is running" );

        cleaningService.clean ();
        gardeningService.garden ();

    }
}
