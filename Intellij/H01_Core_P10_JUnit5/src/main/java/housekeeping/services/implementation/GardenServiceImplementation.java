package housekeeping.services.implementation;

import housekeeping.services.GardeningService;
import housekeeping.tools.GardeningTool;
import org.springframework.beans.factory.annotation.Autowired;

public class GardenServiceImplementation implements GardeningService {
    private GardeningTool gardeningTool;

    @Autowired
    public void setGardeningTool(GardeningTool gardeningTool) {
        this.gardeningTool = gardeningTool;
    }


    @Override
    public void garden() {
        System.out.println ("Working in the garden" );
        gardeningTool.doGardenJob ();

    }
}
