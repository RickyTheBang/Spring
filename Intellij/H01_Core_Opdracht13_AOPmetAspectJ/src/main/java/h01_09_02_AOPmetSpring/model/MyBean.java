package h01_09_02_AOPmetSpring.model;

import org.springframework.stereotype.Component;

@Component("myBean")
public class MyBean implements MyInterface {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }

    @Override
    public String sayGoodbye(String name) {
        return "Goodbye " + name;
    }
}
