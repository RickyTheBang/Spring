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
 /*   @ModelAttribute("choiceList")
    public String[] getCheckboxes() {
        return new String[]{
                "First choice",
                "Second choice",
                "Third choice"
        };
    }*/

    @GetMapping
    public String forward(@ModelAttribute("myform") FormCommand form) {
        return "inputForm";

    }


    @PostMapping
    public String handleForm(@Valid @ModelAttribute("myForm") FormCommand command,
                             BindingResult br) {

        if (br.hasErrors ( )) {
            System.out.println ("inputForm");
        }


        return "nextPage";
    }


}


