package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springMVC.model.Customer;

@Controller
public class IndexController {

    @GetMapping({"/","/index"})
        public String forward(){
       return "index";

        }


}
