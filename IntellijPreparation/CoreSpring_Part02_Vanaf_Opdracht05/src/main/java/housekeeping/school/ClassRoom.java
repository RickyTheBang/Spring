package housekeeping.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("classRoom")
public class ClassRoom {


    @Autowired
    private Pupil pupil;

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public void printYourName(){
        System.out.println( pupil.getName());

    }
}
