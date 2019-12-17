package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springMVC.model.Customer;
@Controller
public class ListController {



        @GetMapping("/myList")
        public String forward(){
            return "customerListForm";

        }

       /* @PostMapping
        //   public String processForm(Customer cust){
        public String processForm(@ModelAttribute("data") Customer cust){
            System.out.println (cust.getFirstName () );
            System.out.println (cust.getLastName () );

            return "customerdetail";
        }*/
    }


