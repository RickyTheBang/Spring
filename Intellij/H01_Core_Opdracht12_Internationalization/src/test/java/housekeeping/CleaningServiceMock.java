package housekeeping;

public class CleaningServiceMock implements CleaningService {
   private boolean isCalled;

   @Override
   public void clean() {
      isCalled = true;
   }

   public boolean isCalled() {
      return isCalled;
   }

}
