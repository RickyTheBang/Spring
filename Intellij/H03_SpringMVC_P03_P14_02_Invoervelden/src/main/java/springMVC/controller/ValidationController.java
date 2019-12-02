package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import springMVC.model.ValidationCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/welcome")
public class ValidationController {
    @GetMapping
    public String forward() {
        return "convert";
    }

    @PostMapping
    public String handleForm(@Valid @ModelAttribute("myNumber") ValidationCommand command,
                             BindingResult br) {

if(br.hasErrors ()){
    System.out.println ("Error");
}



            return "validation";
        }


    }


