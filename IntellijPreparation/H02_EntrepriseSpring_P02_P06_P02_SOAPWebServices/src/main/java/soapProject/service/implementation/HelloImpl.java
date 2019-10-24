package soapProject.service.implementation;

import org.springframework.stereotype.Service;
import soapProject.service.Hello;

@Service("hello")
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
