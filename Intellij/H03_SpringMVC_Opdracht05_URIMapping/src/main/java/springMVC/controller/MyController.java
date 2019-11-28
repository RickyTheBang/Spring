package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        return "childeren";

    }

    @GetMapping  (params ={"age=teenager"})
    public String getTeenager(){

        return "teenagers";

    }

    @GetMapping  (params ={"age=adult"})
    public String getAdult(){

        return "adults";

    }

}
