package theDemo.eventHandling;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EventCreator {

    private Integer state;
    private List<StateChangeEventListener> eventListeners = new ArrayList<> ();
    public void registerEventListener(StateChangeEventListener listener){
        eventListeners.add (listener);
    }



    public EventCreator setState(Integer state) {
        this.state = state;

        eventListeners.stream ( )
                .forEach (listener->listener.handleEvent (new Event ()));

        return this;
    }
}
