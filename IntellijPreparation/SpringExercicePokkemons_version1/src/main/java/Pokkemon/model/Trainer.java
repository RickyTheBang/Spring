package Pokkemon.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Trainer{

    @Id
    @GeneratedValue
    private int idTrainer;
    private String Name;
    private  int level;

    public int getIdTrainer() {
        return idTrainer;
    }

    public Trainer setIdTrainer(int idTrainer) {
        this.idTrainer = idTrainer;
        return this;
    }

    public String getName() {
        return Name;
    }

    public Trainer setName(String name) {
        Name = name;
        return this;
    }

    public int getLevel() {
        return level;
    }

    public Trainer setLevel(int level) {
        this.level = level;
        return this;
    }
}
