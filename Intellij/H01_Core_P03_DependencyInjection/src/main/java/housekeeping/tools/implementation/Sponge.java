package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;

public class Sponge implements CleaningTool {
    public void doCleanJob(){
        System.out.println ("Splach Plouf" );

    }

    public Sponge(){
        System.out.println ("Here is a new Sponge" );
    }
}
