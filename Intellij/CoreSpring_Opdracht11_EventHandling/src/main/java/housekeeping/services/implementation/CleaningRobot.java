package housekeeping.services.implementation;


import housekeeping.services.CleaningService;
import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("cleaningRobot")
@Qualifier("theCleaningRobot")
public class CleaningRobot implements CleaningService {
   private List<CleaningTool> tools;

   @Autowired
   public void setCleaningTools (List<CleaningTool> tools){
       this.tools = tools;
   }

    @Override
    public void clean() {

        System.out.println ("Cleaning the house." );
        tools.forEach (CleaningTool::doCleanJob);

    }
}
