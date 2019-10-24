package broodjes.domain;


import javax.persistence.*;

@Entity
@Table(name="BroodjeOrderItems")
public class BroodjeOrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name="BroodjeId")
    private Broodje broodje;

    @Column(name = "Number")
    private int number;

    public BroodjeOrderItem() {
    }

    public BroodjeOrderItem(Broodje broodje, int number) {
        this.broodje = broodje;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public Broodje getBroodje() {
        return broodje;
    }

    public BroodjeOrderItem setBroodje(Broodje broodje) {
        this.broodje = broodje;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public BroodjeOrderItem setNumber(int number) {
        this.number = number;
        return this;
    }

    @Override
    public String toString() {
        return "BroodjeOrderItem{" +
                "broodje=" + broodje +
                ", number=" + number +
                '}';
    }
}
