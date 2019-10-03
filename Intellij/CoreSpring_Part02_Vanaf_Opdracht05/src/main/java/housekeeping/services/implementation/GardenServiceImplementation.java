package housekeeping.services.implementation;

import housekeeping.services.GardeningService;
import housekeeping.tools.GardeningTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gardenServiceImplementation")
@Qualifier("theGardenServiceImplementation")
public class GardenServiceImplementation implements GardeningService {
    private GardeningTool tool;

    @Autowired
    public void setGardeningTool(@Qualifier("theLawnMower") GardeningTool tool) {
        this.tool = tool;
    }


    @Override
    public void garden() {
        System.out.println ("Working in the garden" );
        tool.doGardenJob ();

    }
}
