package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("sponge")
@Qualifier("theSponge")
@Order(1)
public class Sponge implements CleaningTool {
    public void doCleanJob(){
        System.out.println ("Splach Plouf" );

    }


}
