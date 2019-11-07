package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;

public class DisposableDuster implements CleaningTool {
    private boolean used = false;
    public void doCleanJob(){

        if(used){
            System.out.println ("I'm already used. Please throw me away" );
        }else {
            System.out.println ("Wipe the dust away" );
            used = true;
        }



    }
    public DisposableDuster(){
        System.out.println ("Here is a new Disposable Duster" );
    }
}
