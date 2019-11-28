package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPages")
public class MyController_part2 {

    //3) p328 first table
 /*   @GetMapping("/page1")
    public String handleGet() {
        return "view1";
    }

    @GetMapping("/page2")
    public String handlePost() {
        return "view2";
    }*/

    //4) p329 first table
 /*   @GetMapping
    public String handleGet() {
        return "pages";
    }*/



  /*  @GetMapping(params = "submit")
    public String handleSubmit() {
        return "view1";
    }*/

    @GetMapping(params = "action=submit")
    public String handleSubmit() {
        return "view1";
    }


    @GetMapping(params = "action=cancel")
    public String handleCancel() {
        return "view2";
    }
}
