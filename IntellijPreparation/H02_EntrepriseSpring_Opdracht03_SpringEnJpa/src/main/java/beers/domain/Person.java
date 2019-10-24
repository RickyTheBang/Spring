package beers.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component("person")
public class Person {
    private String name = "joe";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
