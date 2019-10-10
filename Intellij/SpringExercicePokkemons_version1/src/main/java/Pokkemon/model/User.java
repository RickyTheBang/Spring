package Pokkemon.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("user")
@Scope("prototype")
public class User implements Person{

    private String name;
    private int characterLevel;


  /*  public User(String name, int characterLevel) {
        this.name = name;
        this.characterLevel = characterLevel;
    }*/

    public User() {

    }

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
