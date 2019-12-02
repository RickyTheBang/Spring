package springMVC.model;




import java.io.Serializable;




public class FormCommand implements Serializable {

   private boolean selection;

    public boolean isSelection() {
        return selection;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }
}
