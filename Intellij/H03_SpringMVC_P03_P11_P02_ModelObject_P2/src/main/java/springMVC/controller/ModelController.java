package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {
@ModelAttribute("title")
public String getTitle(){
    return "Hello Title";
}
    @GetMapping("/model")
        public String handle(ModelMap model){
        model.addAttribute ("myModelValue","Hello World");

        return "view";
        }


}
