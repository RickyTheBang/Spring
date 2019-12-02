package springMVC.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.io.Serializable;


@Component
public class FormCommand implements Serializable {
    private String message;

    @Size(min = 1)
    public String getMessage() {
        return message;
    }

    public FormCommand setMessage(String message) {
        this.message = message;
        return this;
    }
}

