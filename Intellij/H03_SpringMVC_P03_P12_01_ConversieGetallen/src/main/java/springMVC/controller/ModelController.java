package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springMVC.model.ConversionCommand;

@Controller
public class ModelController {
     /*@Autowired
     ConversionCommand command;
    @GetMapping("/getallen")
        public String handle(ConversionCommand cc){

        return "getallenform";
        }*/


     @GetMapping("/getallen")
         public String forward(){
             return "getallenform";
         }

    @PostMapping

    public String processForm(@ModelAttribute("myData") ConversionCommand command){

        return "getallenoutput";
    }
}
