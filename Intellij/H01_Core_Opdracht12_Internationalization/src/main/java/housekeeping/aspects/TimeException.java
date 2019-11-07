package housekeeping.aspects;

public class TimeException extends RuntimeException {

   public TimeException() {
   }

   public TimeException(String message) {
      super(message);

   }

   public TimeException(Throwable cause) {
      super(cause);

   }

   public TimeException(String message, Throwable cause) {
      super(message, cause);
   }
}
