package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import springMVC.model.ConversionCommand;

@Controller
@RequestMapping("/welcome")
public class ModelControllerMe {
    @GetMapping
    public String forward() {
        return "convert";
    }

    @PostMapping
    public String handleForm(@ModelAttribute("number") ConversionCommand command,
                             BindingResult br) {
        try {
            double number = Double.parseDouble("number");
            // return "success";
        }
        catch(NumberFormatException ex) {
            br.addError(new ObjectError("number","error.number"));
            //return "fail";
        }

        return "convert";
    }


 /*  public String handleForm(@RequestParam("number") String value,
                            BindingResult br) {
      try {
         double number = Double.parseDouble(value);
         // return "success";
      }
      catch(NumberFormatException ex) {
         br.addError(new ObjectError("number","error.number"));
          //return "fail";
      }

        return "convert";
   }*/


 /*   public String handleForm(@RequestParam("number") String value, BindingResult br) {
        try {
            double number = Double.parseDouble(value);
            System.out.println("here 1");
        } catch (NumberFormatException ex) {
            br.addError(new ObjectError("number","error.number"));

        }
        if(br.hasErrors()){
            return "fail";
        }
        else {
            return "success";
        }

    }*/
}
