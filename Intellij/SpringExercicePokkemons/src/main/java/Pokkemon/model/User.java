package Pokkemon.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user")
//@Scope("propototype")
public class User implements Person{
    private String name;
    private int characterLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }
}
