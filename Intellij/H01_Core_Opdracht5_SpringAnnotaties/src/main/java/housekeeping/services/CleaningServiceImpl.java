package housekeeping.services;


import housekeeping.tools.CleaningTool;

public class CleaningServiceImpl implements CleaningService{
    private CleaningTool cleaningTool;

    public CleaningServiceImpl(){

    }

    public CleaningServiceImpl(CleaningTool cleaningTool){
        this.cleaningTool =  cleaningTool;
    }
    public void setCleaningTool(CleaningTool cleaningTool){
        this.cleaningTool = cleaningTool;
    }

    public CleaningTool getCleaningTool() {
        return cleaningTool;
    }

    @Override
    public void clean() {
        System.out.println ("Cleaning the house" );
        cleaningTool.doCleanJob ();

    }
}
