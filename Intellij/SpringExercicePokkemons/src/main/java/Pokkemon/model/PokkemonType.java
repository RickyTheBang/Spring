package Pokkemon.model;

import javax.persistence.*;

@Entity
@Table(name="PokemonType")
public class PokkemonType {
    @Id
    @GeneratedValue
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

    public PokkemonType setId(int id) {
        this.id = id;
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public PokkemonType setTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public PokkemonType setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
        return this;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public PokkemonType setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
        return this;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public PokkemonType setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
        return this;
    }

    public int getBaseHitPoints() {
        return baseHitPoints;
    }

    public PokkemonType setBaseHitPoints(int baseHitPoints) {
        this.baseHitPoints = baseHitPoints;
        return this;
    }
}
