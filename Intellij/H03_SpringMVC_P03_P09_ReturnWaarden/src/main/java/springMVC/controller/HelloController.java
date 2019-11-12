package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springMVC.service.Hello;

@Controller
public class HelloController {
    private Hello helloService;



    @RequestMapping("/completeHello")
    @ResponseBody
    public String handle(){

        return "<html><head></head><body>Here is London</body></html>";

    }

   @RequestMapping("/staticHello")
       public String handleStatic(){

        return "staticHelloView";

    }
}
