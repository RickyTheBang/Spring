package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springMVC.model.Customer;

@Controller
public class CommandController {

    @GetMapping("/customer")
        public String forward(){
       return "customerform";

        }

@PostMapping
 //   public String processForm(Customer cust){
public String processForm(@ModelAttribute("data") Customer cust){
    System.out.println (cust.getFirstName () );
    System.out.println (cust.getLastName () );

         return "customerdetail";
}
}
