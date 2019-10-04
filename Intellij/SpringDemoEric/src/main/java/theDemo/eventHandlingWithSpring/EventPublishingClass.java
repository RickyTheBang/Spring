package theDemo.eventHandlingWithSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventPublishingClass {

    @Autowired
    private ApplicationEventPublisher publisher;

    private Integer state;
    public EventPublishingClass setState(Integer state){
        this.state = state;
        publisher.publishEvent (new DataBaseEvent ("Get your hands of her you bitch!!!"));
        return this;
    }
}
