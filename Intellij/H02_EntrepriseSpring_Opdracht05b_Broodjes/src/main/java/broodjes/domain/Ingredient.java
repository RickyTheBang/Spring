package broodjes.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ingredients" )
public class Ingredient implements Serializable {
    {this.stock =1000;}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;


    @Column(name = "Price")
    private float price;

    @Column(name = "Stock")
    private int stock;

    public Ingredient() {
    }

    public Ingredient(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Ingredient setName(String name) {
        this.name = name;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Ingredient setPrice(float price) {
        this.price = price;
        return this;
    }

    public int getStock() {
        return stock;
    }

    public Ingredient setStock(int stock) {
        this.stock = stock;
        return this;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
