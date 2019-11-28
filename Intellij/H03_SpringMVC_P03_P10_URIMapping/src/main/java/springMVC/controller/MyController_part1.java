package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/page")
public class MyController_part1 {
//1) p327 first table
    /*@RequestMapping(method = RequestMethod.GET)
    public String handleGet() {
        return "view1";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String handlePost() {
        return "view2";
    }*/


    //2) p327 third table
    @GetMapping
    public String handleGet() {
        return "view1";
    }


    @PostMapping
    public String handlePost() {
        return "view2";
    }
}
