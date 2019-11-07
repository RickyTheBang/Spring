package housekeeping;

public class GardeningToolMock implements GardeningTool {
   private boolean cleanCalled = false;
   
   public void doGardenJob() {
      cleanCalled = true;
   }
   
   public boolean isCalled() {
      return cleanCalled;
   }

}
