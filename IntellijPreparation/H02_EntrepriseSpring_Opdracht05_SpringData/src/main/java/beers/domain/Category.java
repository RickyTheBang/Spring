package beers.domain;

import javax.persistence.*;
import java.io.*;
import java.util.*;


@Entity
@Table(name="Categories")
public class Category implements Serializable{
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   @Column(name="Id")
   private int id;
   
   @Column(name="Category")
   private String name;

   @OneToMany(mappedBy="category")
   private Set<Beer> beers = new HashSet<Beer>();

   public Set<Beer> getBeers() {
      return beers;
   }

   public void setBeers(Set<Beer> beers) {
      this.beers = beers;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   public String toString() {
      return name;
   }
}
