package theDemo.eventHandlingWithSpring;

public class DataBaseEvent extends GeneralEvent {
    private String message;

    public DataBaseEvent( String message) {
        this.message = message;


    }
}
