package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springMVC.service.Hello;

@Controller
public class HelloController {
    private Hello helloService;

    @Autowired
    public void setHelloService(Hello helloService){
        this.helloService = helloService;
    }

    @RequestMapping("hello")
    public ModelAndView handleHello(){
        String text = helloService.sayHello ();
        return new ModelAndView("helloView","message",text);

      //  return new ModelAndView ("helloView","message", text);

    }
}
