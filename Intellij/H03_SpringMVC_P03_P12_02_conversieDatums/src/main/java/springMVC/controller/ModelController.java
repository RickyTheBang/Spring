package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springMVC.model.ConversionCommand;

@Controller
public class ModelController {
     @Autowired
     ConversionCommand command;
    @GetMapping("/mydata")
        public String handle(ConversionCommand cc){

        return "dataform";
        }

    @PostMapping

    public String processForm(@ModelAttribute("myData") ConversionCommand command){

        return "dataoutput";
    }
}
