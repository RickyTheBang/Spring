package housekeeping.services.implementation;

import housekeeping.generalObjects.LunchEvent;
import housekeeping.services.GardeningService;
import housekeeping.tools.GardeningTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("gardenServiceImplementation")
@Qualifier("theGardenServiceImplementation")
public class GardenServiceImplementation implements GardeningService {
    private GardeningTool tool;

    @Autowired
    public void setGardeningTool(@Qualifier("theLawnMower") GardeningTool tool) {
        this.tool = tool;
    }

    @EventListener
    public void onLunchEvent(LunchEvent e){
        System.out.println (e.getMessage () );
        System.out.println ("Stop with the Garden service.\nTaking a break for lunch" );
    }

    @Override
    public void garden() {
        System.out.println ("Working in the garden" );
        tool.doGardenJob ();

    }
}
