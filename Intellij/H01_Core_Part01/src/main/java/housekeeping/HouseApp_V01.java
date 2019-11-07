package housekeeping;

import housekeeping.services.implementation.CleaningServiceImpl;
import housekeeping.tools.implementation.Broom;
import housekeeping.tools.CleaningTool;
import housekeeping.tools.implementation.Sponge;
import housekeeping.tools.implementation.VacuumCleaner;

public class HouseApp_V01 {
    public static void main(String[] args) {
         CleaningTool broom = new Broom ();
         CleaningTool vacuum = new VacuumCleaner ();
        CleaningTool sponge = new Sponge ();
        CleaningServiceImpl jill = new CleaningServiceImpl ();
        jill.setCleaningTool (broom);
        CleaningServiceImpl bob = new CleaningServiceImpl ();
        bob.setCleaningTool (vacuum);
        CleaningServiceImpl jane = new CleaningServiceImpl ();
        jane.setCleaningTool (sponge);

        jill.clean ();
        bob.clean ();
        jane.clean ();



    }
}
