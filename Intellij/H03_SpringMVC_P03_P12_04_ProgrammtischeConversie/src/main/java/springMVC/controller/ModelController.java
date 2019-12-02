package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springMVC.model.ConversionCommand;

import static java.lang.Double.parseDouble;

@Controller
@RequestMapping("/welcome")
public class ModelController {
    @GetMapping
    public String forward() {
        return "convert";
    }

    @PostMapping
    public String handleForm(@ModelAttribute("number") ConversionCommand command,
                             BindingResult br) {


        try {
        /*double numberDouble = command.getNumber ( );
        String numberString = String.valueOf (numberDouble);*/
            double numberParse = parseDouble (String.valueOf (command.getNumber ( )));
            System.out.println (command.getNumber ( ) );
            System.out.println (String.valueOf ("${{command.number}}"));
            System.out.println (numberParse);
            System.out.println (br.hasErrors ( ));
            return "success";
        } catch (NumberFormatException ex) {
            br.addError (new ObjectError ("number", "error.number"));


            System.out.println (br.hasErrors ( ));


            return "fail";
        }


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
