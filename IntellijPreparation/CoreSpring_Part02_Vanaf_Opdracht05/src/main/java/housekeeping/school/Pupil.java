package housekeeping.school;

import org.springframework.stereotype.Component;

@Component("pupil")
public class Pupil {
    private String name = "jack";
    private int level =12;

    public Pupil(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}




