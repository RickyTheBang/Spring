package p11_Springboot.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloImpl implements Hello  {
    private String name;

 /*   @Value ("${name}")*/
    public void setName(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "Hello " + name;
    }
}
