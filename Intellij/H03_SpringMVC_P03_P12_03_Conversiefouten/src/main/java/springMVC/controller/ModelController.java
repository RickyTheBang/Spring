package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springMVC.model.ConversionCommand;

@Controller
@RequestMapping("/welcome")
public class ModelController {
    /* @Autowired
     ConversionCommand command;*/

    @GetMapping
        public String forward(){

        return "convert";
        }

    @PostMapping

  //  public String processForm(ConversionCommand command, BindingResult br){
 public String processForm(@ModelAttribute("myData") ConversionCommand command, BindingResult br){

        if(br.hasErrors()){
            return "fail";
        }
        else {
            return "success";
        }


    }
}
