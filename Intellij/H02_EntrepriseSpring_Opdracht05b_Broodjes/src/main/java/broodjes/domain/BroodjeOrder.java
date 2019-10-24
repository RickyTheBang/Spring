package broodjes.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BroodjeOrders")
public class BroodjeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "BroodjeOrderId")
    private List<BroodjeOrderItem> items = new ArrayList<>();

    public BroodjeOrder() {
    }

    public BroodjeOrder(String name, List<BroodjeOrderItem> items) {
        this.name = name;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BroodjeOrder setName(String name) {
        this.name = name;
        return this;
    }

    public List<BroodjeOrderItem> getItems() {
        return items;
    }

    public BroodjeOrder setItems(List<BroodjeOrderItem> items) {
        this.items = items;
        return this;
    }
}
