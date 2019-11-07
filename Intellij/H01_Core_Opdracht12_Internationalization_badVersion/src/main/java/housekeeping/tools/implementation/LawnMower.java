package housekeeping.tools.implementation;

import housekeeping.tools.GardeningTool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lawnMower")
@Qualifier("theLawnMower")
public class LawnMower  implements GardeningTool {

    @Override
    public void doGardenJob() {
        System.out.println ("mow mow mow mooooooooooouw" );
    }
}
