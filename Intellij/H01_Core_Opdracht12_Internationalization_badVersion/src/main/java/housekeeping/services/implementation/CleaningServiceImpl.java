package housekeeping.services.implementation;


import housekeeping.generalObjects.LunchEvent;
import housekeeping.services.CleaningService;
import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("cleaningServiceImpl")
@Qualifier("theCleaningServiceImpl")

public class CleaningServiceImpl implements CleaningService {
    private CleaningTool cleaningTool;
    private float rate;

    public CleaningTool getCleaningTool() {
        return cleaningTool;
    }

    @Autowired
    public void setCleaningTool(@Qualifier("theBroom") CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
    }


    @Value ("9")
    public void setRate(float rate){
        this.rate = rate;
    }

    @EventListener
    public void onLunchEvent(LunchEvent e){
        System.out.println (e.getMessage () );
        System.out.println ("Stop with the cleaning service.\nTaking a break for lunch" );
    }

    @Override
    public void clean() {
        System.out.println ("Cleaning the house");
        System.out.println ("The rate of this job is: " + rate  );
        cleaningTool.doCleanJob ( );

    }
}
