package springMVC.model;

import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;


@Component("conversionCommand")
public class ConversionCommand implements Serializable {
    private LocalDate date;
    private double number;


    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public LocalDate getDate() {
        return date;
    }

    @NumberFormat(style = NumberFormat.Style.NUMBER)
    public double getNumber() {
        return number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
