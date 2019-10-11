package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Component("vacuumCleaner")
@Qualifier("theVacuumCleaner")
@Order(2)
public class VacuumCleaner implements CleaningTool {
    int hour  = LocalTime.now ().getHour ();


    public void doCleanJob()  throws Exception{

        if(hour <8 && hour >=18){
            throw new Exception ("No noise now!");
        }else {
            System.out.println ("Zuuuuuuuuuu" );
        }


    }

}
