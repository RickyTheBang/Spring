package beers.service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BeerOrders")
public class BeerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "BeerOrderId")
    private List<BeerOrderItems> items = new ArrayList<>();

    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BeerOrderItems> getItems() {
        return items;
    }

    public void setItems(List<BeerOrderItems> items) {
        this.items = items;
    }
}
