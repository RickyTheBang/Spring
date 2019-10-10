package beers.service;


import beers.domain.Beer;

import javax.persistence.*;

@Entity
@Table(name="BeerOrderItems")
public class BeerOrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @ManyToOne
    @JoinColumn(name="BeerId")
    private Beer beer;

    @Column(name = "Number")
    private int number;

    public int getId() {
        return id;
    }



    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
