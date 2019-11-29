package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatternController {
    @GetMapping("/page/*/hello")
    public ModelAndView handleSingleWildcard() {
        return new ModelAndView ("mypage", "message", "Single");
    }

    @GetMapping("/page/**/hello")
    public ModelAndView handleMultipleWildcard() {
        return new ModelAndView ("mypage", "message", "Multiple");
    }

}

