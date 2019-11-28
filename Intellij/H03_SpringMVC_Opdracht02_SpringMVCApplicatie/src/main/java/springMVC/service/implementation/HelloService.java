package springMVC.service.implementation;

import org.springframework.stereotype.Service;
import springMVC.service.Hello;
@Service
public class HelloService implements Hello {
    @Override
    public String sayHello() {
        return "Hello joe";
    }


}
