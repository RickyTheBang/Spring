package beers.repository;

import beers.domain.Beer;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository {
   private EntityManagerFactory emf;
   
   
   @PersistenceUnit
   public void setEntityManagerFactory(EntityManagerFactory emf) {
      this.emf = emf;
   }
   
   public Beer getBeerById(int id) {
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();
      tx.begin();
      Beer beer = em.find(Beer.class,id);
      tx.commit();
      em.close();
      return beer;
   }

   @Override
   public List<Beer> getBeerByAlcohol(float alcohol) {


      EntityManager em = emf.createEntityManager();

        List<Beer> beerList= null;


            String sqlScript = "select b from Beer as b where  b.alcohol=?1";
            TypedQuery<Beer> query=
            em.createQuery(sqlScript, Beer.class);
            query.setParameter(1,alcohol);
      beerList =query.getResultList();





        return beerList;



   }

   @Override
   public void updateBeer(Beer b) {

   }

  /* public List<Beer> getBeerByAlcohol(float alcohol) {
      EntityManager em = emf.createEntityManager();
      TypedQuery<Beer> query = em
         .createQuery("select b from Beer b where b.alcohol = ?1",Beer.class);      
      query.setParameter(1,alcohol);
      EntityTransaction tx = em.getTransaction();
      tx.begin();
      List<Beer> beers = query.getResultList();
      tx.commit();
      em.close();
      return beers;
   }

   @Override
   public void updateBeer(Beer b) {
      EntityManager em = emf.createEntityManager();
      EntityTransaction tx = em.getTransaction();
      tx.begin();
      em.merge(b);
      tx.commit();
      em.close();
   }*/
}
