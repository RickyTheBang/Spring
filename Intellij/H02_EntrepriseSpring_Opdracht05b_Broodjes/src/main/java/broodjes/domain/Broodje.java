package broodjes.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "broodjes" )
public class Broodje implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;


    @ManyToMany
    private Set<Ingredient> ingredients = new HashSet<> ();


    @Column(name = "Price")
    private float price;

    public Broodje() {
    }

    public Broodje(String name, Set<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Broodje setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Broodje setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    @Override
    public String toString() {
        return "Broodje{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
