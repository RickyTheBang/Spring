package springMVC.model;
import java.io.Serializable;

public class FormCommand implements Serializable {

private SizeType type;

    public SizeType getType() {
        return type;
    }

    public void setType(SizeType type) {
        this.type = type;
    }
}
