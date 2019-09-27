package housekeeping.services.implementation;


import housekeeping.services.CleaningService;
import housekeeping.tools.CleaningTool;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

public class CleaningServiceImpl implements CleaningService {
    private Logger logger;

    private CleaningTool cleaningTool;

    public CleaningServiceImpl(){
        System.out.println ("The Cleaning Service Implentation has started." );

    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

public void init(){
    System.out.println ("Cleaning Service preparing for work" );
}

    public void destroy(){
        System.out.println ("Cleaning Service cleaning up." );
    }

    public CleaningServiceImpl(CleaningTool cleaningTool){
        this.cleaningTool =  cleaningTool;
    }
    public void setCleaningTool(CleaningTool cleaningTool){
        this.cleaningTool = cleaningTool;
    }

    public CleaningTool getCleaningTool() {
        return cleaningTool;
    }

    @Override
    public void clean() {
        logger.info("Running household");
        System.out.println ("DOMESTIC SERVICE LIMITED is running" );
        System.out.println ("Cleaning the house" );
        cleaningTool.doCleanJob ();

    }
}
