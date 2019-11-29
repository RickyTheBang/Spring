package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

    @GetMapping("/iteration")
        public String handle(ModelMap model){
        String[] values = {"Hello World", "Hello Mars"};
        model.addAttribute ("greetings",values);

        return "iteration";
        }


}
