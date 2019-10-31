package soapProject.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soapProject.service.Hello;

import javax.jws.WebService;

@Service
@WebService(serviceName = "HelloService")
public class HelloServiceEndpoint {
    @Autowired
    private Hello helloService;

    public String sayHello(String name){
        return helloService.sayHello(name);
    }
}
