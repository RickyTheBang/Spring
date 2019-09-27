package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;

public class Broom implements CleaningTool {
    private int timesUsed;
    public void doCleanJob(){
        System.out.println ("Scrub scrub... " + ++timesUsed + "th or nd time" );
    }
    public Broom(){
        System.out.println ("Here is a new Broom" );
    }
}
