package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateController {
    @GetMapping("/sayhello/{name}")
    public ModelAndView handleSingleWildcard(@PathVariable String name) {
        return new ModelAndView ("mypage", "message", "Hello " + name);
    }



}

