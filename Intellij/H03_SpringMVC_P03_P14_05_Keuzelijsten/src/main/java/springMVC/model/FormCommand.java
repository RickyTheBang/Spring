package springMVC.model;
import java.io.Serializable;
import java.util.Arrays;

public class FormCommand implements Serializable {

   private String[] choices;

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    @Override
    public String toString() {
        String result ="";

        for(String choice : choices){
            result += choice + " ";
        }
        return result;
    }
}
