package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component("disposableDuster")
@Qualifier("theDisposableDuster")
@Order(4)
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

}
