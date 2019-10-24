package Pokkemon.model;


import org.springframework.stereotype.Component;

@Component("user")
public class User {
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
