package theDemo.eventHandlingWithSpring;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;

public class InterestedClass {

   // @EventListener(classes = {DataBaseEvent.class,ConnectionProblemEvent.class})
   @EventListener
   @Order(1)
    public void callMeWhenStuffHappens(Object event){


    }

}
