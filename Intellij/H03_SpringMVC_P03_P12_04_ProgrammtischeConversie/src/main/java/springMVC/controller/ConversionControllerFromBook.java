package springMVC.controller;

import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import springMVC.model.ConversionCommand;

@Controller
@RequestMapping("/convert")
public class ConversionControllerFromBook {
    @RequestMapping(method = RequestMethod.GET)
    public String forward(@ModelAttribute("form") ConversionCommand form) {
        return "convert";
    }

 /*   @RequestMapping(method = RequestMethod.POST)
    public String handleForm(@ModelAttribute("form") ConversionCommand form,
                             BindingResult br) {
        if (br.hasErrors()) {
            System.out.println("error");
        }
        return "convert";
    }*/

   @RequestMapping(method = RequestMethod.POST)
   public String handleForm(@RequestParam("number") String value,
                            BindingResult br) {
      try {
         double number = Double.parseDouble(value);
      }
      catch(NumberFormatException ex) {
         br.addError(new ObjectError("number","error.number"));
      }

      return "convert";
   }
}
