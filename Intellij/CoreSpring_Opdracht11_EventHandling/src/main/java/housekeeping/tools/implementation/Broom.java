package housekeeping.tools.implementation;

import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Component("broom")
@Qualifier("theBroom")
@Order(3)
public class Broom implements CleaningTool {
    private int timesUsed;


    public void doCleanJob() {

        System.out.println ("\nScrub scrub... " + ++timesUsed + "th or nd time");
    }

}
