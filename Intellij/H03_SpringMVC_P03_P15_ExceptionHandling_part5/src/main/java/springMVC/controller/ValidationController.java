package springMVC.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springMVC.model.FormCommand;
import springMVC.model.MyException;

import javax.validation.Valid;

@Controller
@RequestMapping("/inputForm")
public class ValidationController {
    @GetMapping
    public String forward(
            @ModelAttribute("myform") FormCommand form) throws MyException {

            int i=2;
            if (i == 2) {

                throw new MyException("My very strange exception");
            }
            return "inputForm";


    }


    @PostMapping
    public String handleForm(@Valid @ModelAttribute("myform") FormCommand form,
                             BindingResult br) {

        if (br.hasErrors ( )) {
            for (String code : br.getFieldError ( ).getCodes ( )) {
                System.out.println (code);
            }
            System.out.println ("Error");
            return "inputForm";
        }
        return "nextPage";
    }
}


