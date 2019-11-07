package housekeeping.services.implementation;

import housekeeping.services.CleaningService;
import housekeeping.services.DomesticService;
import housekeeping.services.GardeningService;

public class DomesticServiceImpl implements DomesticService {

    private CleaningService cleaningService;
    private GardeningService gardeningService;

    public void setCleaningService(CleaningService cleaningService) {
        this.cleaningService = cleaningService;
    }

    public void setGardeningService(GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    @Override
    public void runHouseHold() {
        System.out.println ("DOMESTIC SERVICE LIMITED is running" );

        cleaningService.clean ();
        gardeningService.garden ();

    }
}
