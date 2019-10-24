package Pokkemon.model;
import javax.persistence.*;

@Entity
@Table(name = "Pokkemon")
public class Pokkemon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "PokkemonName")
    private String pokkemonName;


    @ManyToOne
    @JoinColumn(name = "PokkemonType")
    private PokkemonType pokkemonType;


    @Column(name = "Level")
    private int level;

    @Column(name = "IVAttack")
    private int IVAttack;

    @Column(name = "IVDefense")
    private int IVDefense;

    @Column(name = "IVHitPoints")
    private int IVHitPoints;

    @Column(name = "CombatPower")
    private int combatPower;

    @Transient
    private int dustToMaxLevel;
    @Transient
    private Trainer trainer;


    public Pokkemon() {
    }

    public Pokkemon(String pokkemonName, PokkemonType pokkemonType, int level, int IVAttack, int IVDefense, int IVHitPoints, int combatPower) {
        this.pokkemonName = pokkemonName;
        this.pokkemonType = pokkemonType;
        this.level = level;
        this.IVAttack = IVAttack;
        this.IVDefense = IVDefense;
        this.IVHitPoints = IVHitPoints;
        this.combatPower = combatPower;
    }

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

    public int getDustToMaxLevel() {
        return dustToMaxLevel;
    }

    public Pokkemon setDustToMaxLevel(int dustToMaxLevel) {
        this.dustToMaxLevel = dustToMaxLevel;
        return this;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public Pokkemon setTrainer(Trainer trainer) {
        this.trainer = trainer;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pokkemon{");

        sb.append("pokkemonName='").append(pokkemonName).append('\'');
        sb.append(", pokkemonType=").append(pokkemonType);
        sb.append(", level=").append(level);
        sb.append(", IVAttack=").append(IVAttack);
        sb.append(", IVDefense=").append(IVDefense);
        sb.append(", IVHitPoints=").append(IVHitPoints);
        sb.append(", combatPower=").append(combatPower);
        sb.append('}');
        return sb.toString();
    }
}
