package housekeeping.services.implementation;

import housekeeping.services.GardeningService;
import housekeeping.tools.GardeningTool;

public class GardenServiceImplementation implements GardeningService {
    private GardeningTool tool;

    public void setGardeningTool(GardeningTool tool) {
        this.tool = tool;
    }


    @Override
    public void garden() {
        System.out.println ("Working in the garden" );
        tool.doGardenJob ();

    }
}
