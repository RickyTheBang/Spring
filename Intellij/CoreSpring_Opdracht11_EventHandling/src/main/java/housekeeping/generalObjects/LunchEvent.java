package housekeeping.generalObjects;

public class LunchEvent {

   private String message;

    public LunchEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public LunchEvent setMessage(String message) {
        this.message = message;
        return this;
    }
}
