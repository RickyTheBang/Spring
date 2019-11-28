package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public ModelAndView handleHello(Model model){
        String text1 = helloService.sayHello ();
        String text2 = "London";
        model.addAttribute ( "message1", text1);
        model.addAttribute ( "message2", text2);


        return new ModelAndView ("helloView","myModel",model);
        //return new ModelAndView ("helloView","message", text1);

    }
}
