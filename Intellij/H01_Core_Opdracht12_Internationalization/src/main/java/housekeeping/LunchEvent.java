package housekeeping;

import org.springframework.context.*;

public class LunchEvent extends ApplicationEvent {
   public LunchEvent(Object source) {
      super(source);      
   }
}
