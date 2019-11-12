package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springMVC.service.Hello;

@Controller
@RequestMapping("/age")
public class MyController {
    private Hello helloService;

//(method = RequestMethod.POST)
   @RequestMapping
       public String getPage(){

        return "selectAge";

    }
    //"action=submit",
    //(params = {"submit","child"})
    @GetMapping  (params ={"age=child"})
    public String getChild(){

        return "child";

    }

}
