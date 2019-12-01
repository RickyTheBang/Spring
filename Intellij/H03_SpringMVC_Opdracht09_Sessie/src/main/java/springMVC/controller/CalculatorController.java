package springMVC.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("result")
@RequestMapping("/calculator")
public class CalculatorController {

   @RequestMapping(method = RequestMethod.GET)
   public String setupForm(ModelMap model) {
      if (model.get("result") == null) {
         model.addAttribute("result", 0F);
      }
      return "calculator";
   }

   @RequestMapping(method = RequestMethod.POST)
   public String calc(ModelMap model, @RequestParam("number") float value,
         @RequestParam("operation") String operation) {
      Float res = (Float) model.get("result");
      float result = 0;
      if(res != null) {
         result = res;
      }
      switch (operation) { // Java 7!!!
      case "+":
         result += value;
         break;
      case "-":
         result -= value;
         break;
      case "*":
         result *= value;
         break;
      case "/":
         result /= value;
         break;
      case "C":
         result = 0;
         break;
      }
      model.addAttribute("result", result);
      return "redirect:calculator";
   }
}
