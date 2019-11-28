package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {

    @GetMapping("/params")
        public String getPage(){
            return "params";
        }

@GetMapping("mypage")
    public ModelAndView handle(@RequestParam("first_name")
                                       String firstName){
        return new ModelAndView ("mypage","message","Hello" +firstName);
    }
}
