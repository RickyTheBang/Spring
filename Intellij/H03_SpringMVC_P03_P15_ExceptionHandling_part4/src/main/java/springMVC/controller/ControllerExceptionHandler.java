package springMVC.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex){
        System.out.println(ex.getMessage());
        return "exception";
    }
}
