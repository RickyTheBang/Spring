package springMVC.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Something went wrong.", code = HttpStatus.NOT_FOUND)
public class MyException extends Exception {

    public MyException(String message){
        super(message);
    }

}
