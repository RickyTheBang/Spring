package housekeeping.services.implementation;

import housekeeping.services.CleaningService;
import housekeeping.services.DomesticService;
import housekeeping.services.GardeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component("domesticServiceImpl")
@Qualifier("theDomesticServiceImpl")
@Profile("smallHouse")
public class DomesticServiceImpl implements DomesticService {

    private CleaningService cleaningService;
    private GardeningService gardeningService;


    @Autowired
    public void setCleaningService(@Qualifier("theCleaningServiceImpl") CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }

    @Autowired
    public void setGardeningService(@Qualifier("theGardenServiceImplementation") GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    @Override
    @EventListener(ContextStartedEvent.class)
    @Order(1)
    public void runHouseHold() {
        System.out.println ("\nDOMESTIC SERVICE LIMITED is running");

        cleaningService.clean ( );
        gardeningService.garden ( );

    }
}
