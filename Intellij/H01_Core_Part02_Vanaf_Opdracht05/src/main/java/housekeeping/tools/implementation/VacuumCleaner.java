package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component("vacuumCleaner")
@Qualifier("theVacuumCleaner")
@Order(2)
public class VacuumCleaner implements CleaningTool {
    public void doCleanJob(){
        System.out.println ("Zuuuuuuuuuu" );
    }

}
