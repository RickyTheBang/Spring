package housekeeping;

public class CleaningToolMock implements CleaningTool {
   private boolean cleanCalled = false;
   
   public void doCleanJob() {
      cleanCalled = true;
   }
   
   public boolean isCalled() {
      return cleanCalled;
   }

}
