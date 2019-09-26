package housekeeping.services;

import housekeeping.tools.GardeningTool;

public class GardenServiceImplementation implements GardeningService {
    private GardeningTool gardeningTool;

    public void setGardeningTool(GardeningTool gardeningTool) {
        this.gardeningTool = gardeningTool;
    }


    @Override
    public void garden() {
        System.out.println ("Working in the garden" );
        gardeningTool.doGardenJob ();

    }
}
