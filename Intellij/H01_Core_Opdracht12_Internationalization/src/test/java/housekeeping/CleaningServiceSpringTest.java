package housekeeping;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=CleaningServiceTestConfig.class)
@DirtiesContext
public class CleaningServiceSpringTest {
   
   @Autowired
   private CleaningService testCleaner;
   
   @Autowired
   private CleaningToolMock mock;
      
   @Test
   public void testDoJob() {
      testCleaner.clean();
      Assert.assertTrue(mock.isCalled());
   }
}
