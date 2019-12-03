package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springMVC.model.FormCommand;

import javax.validation.Valid;

@Controller
@RequestMapping("/inputForm")
public class FormController {
    @GetMapping
    public String forward(@ModelAttribute("myform") FormCommand form) {

        return "inputForm";
    }

    @PostMapping
    public String handleForm(@Valid @ModelAttribute("myform") FormCommand command,
                             BindingResult br) {

        if (br.hasErrors ()) {
           for (String code : br.getFieldError ().getCodes()){
               System.out.println (code );
           }

            System.out.println ("error" );
           return "inputForm";
        }


        return "nextPage";
    }


}

