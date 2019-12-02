package springMVC.model;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;


@Component
public class ValidationCommand implements Serializable {
    @Min(2)
    @Max(5)
    private double number;
    public double getNumber() {
        return number;
    }
    public void setNumber(double number) {
        this.number = number;
    }
}
