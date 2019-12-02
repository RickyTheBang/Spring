package springMVC.model;
import java.io.Serializable;
import java.util.Arrays;

public class FormCommand implements Serializable {

   private String radioValue;

    public String getRadioValue() {
        return radioValue;
    }

    public void setRadioValue(String radioValue) {
        this.radioValue = radioValue;
    }
}
