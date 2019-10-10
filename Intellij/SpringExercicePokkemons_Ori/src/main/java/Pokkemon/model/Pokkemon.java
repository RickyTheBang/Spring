package Pokkemon.model;

import javax.persistence.*;

@Entity
@Table(name="Pokemon")
public class Pokkemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="PokkemonName")
    private String pokkemonName;


    @ManyToOne
    @JoinColumn(name="PokkemonType")
    private PokkemonType pokkemonType;


    @Column(name="Level")
    private int level;

    @Column(name="IVAttack")
    private int IVAttack;

    @Column(name="IVDefense")
    private int IVDefense;

    @Column(name="IVHitPoints")
    private int IVHitPoints;

    @Column(name="CombatPower")
    private int combatPower;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPokkemonName() {
        return pokkemonName;
    }

    public void setPokkemonName(String pokkemonName) {
        this.pokkemonName = pokkemonName;
    }

    public PokkemonType getPokkemonType() {
        return pokkemonType;
    }

    public void setPokkemonType(PokkemonType pokkemonType) {
        this.pokkemonType = pokkemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIVAttack() {
        return IVAttack;
    }

    public void setIVAttack(int IVAttack) {
        this.IVAttack = IVAttack;
    }

    public int getIVDefense() {
        return IVDefense;
    }

    public void setIVDefense(int IVDefense) {
        this.IVDefense = IVDefense;
    }

    public int getIVHitPoints() {
        return IVHitPoints;
    }

    public void setIVHitPoints(int IVHitPoints) {
        this.IVHitPoints = IVHitPoints;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }
}
