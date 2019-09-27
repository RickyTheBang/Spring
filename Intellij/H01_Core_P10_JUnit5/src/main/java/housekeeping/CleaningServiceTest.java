package housekeeping;

import housekeeping.services.implementation.CleaningServiceImpl;
import housekeeping.tools.implementation.CleaningToolMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class CleaningServiceTest {

    private CleaningServiceImpl testCleaner;
    private CleaningToolMock mock;

    @BeforeEach
    public void before(){
        mock = new CleaningToolMock ();
        testCleaner =new CleaningServiceImpl ();
        testCleaner.setCleaningTool (mock);
        testCleaner.setLogger (Logger.getLogger (CleaningServiceImpl.class.getName () ));
        testCleaner.init ();
    }

    @AfterEach
    public void after(){
        testCleaner.destroy ();
    }
    @Test
    public void testDoJob(){
        testCleaner.clean ();
        Assertions.assertTrue (mock.isCalled () );
    }

}
