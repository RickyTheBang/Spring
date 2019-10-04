package housekeeping.services.implementation;

import housekeeping.generalObjects.LunchEvent;
import housekeeping.services.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("frenchcook")
public class FrenchCook  implements Cook {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    @EventListener(ContextStartedEvent.class)
    @Order(2)
    public void makeLunch() {
        publisher.publishEvent (new LunchEvent ("Supper's ready!"));

    }


}
