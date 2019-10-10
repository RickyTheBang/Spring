package Pokkemon.model;

import javax.persistence.*;

@Entity
@Table(name="PokemonType")
public class PokkemonType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(name="TypeName")
    private String typeName;

    @Column(name="Beschrijving")
    private String beschrijving;

    @Column(name="BaseAttack")
    private int baseAttack;

    @Column(name="BaseDefense")
    private int baseDefense;

    @Column(name="BaseHitPoints")
    private int baseHitPoints;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public int getBaseHitPoints() {
        return baseHitPoints;
    }

    public void setBaseHitPoints(int baseHitPoints) {
        this.baseHitPoints = baseHitPoints;
    }
}
