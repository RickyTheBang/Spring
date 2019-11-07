package housekeeping;

import org.junit.*;

public class CleaningServiceTest {
   
   private CleaningServiceImpl testCleaner;
   private CleaningToolMock mock;
   
   @Before
   public void before() {
      mock = new CleaningToolMock();
      testCleaner = new CleaningServiceImpl();
      testCleaner.setCleaningTool(mock);
      testCleaner.init();
   }
   
   @After
   public void after() {
   	testCleaner.destroy();
   }
   
   @Test
   public void testDoJob() {
      testCleaner.clean();
      Assert.assertTrue(mock.isCalled());
   }

}
