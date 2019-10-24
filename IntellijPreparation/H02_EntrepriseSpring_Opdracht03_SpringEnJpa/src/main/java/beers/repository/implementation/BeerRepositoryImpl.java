package beers.repository.implementation;

import beers.domain.Beer;
import beers.repository.BeerRepository;
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
        Beer beer = em.find(Beer.class, id);
        tx.commit();
        em.close();
        return beer;
    }

    @Override
    public List<Beer> getBeerByAlcohol(float alcohol) {

        EntityManager em = emf.createEntityManager();
        List<Beer> beerList = null;
        String sqlScript = "SELECT b FROM  Beer as b WHERE  b.alcohol=?1";
        TypedQuery<Beer> query =
                em.createQuery(sqlScript, Beer.class);
        query.setParameter(1, alcohol);
        beerList = query.getResultList();
        return beerList;


    }

    @Override
    public void updateBeer(Beer b) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(b);
        tx.commit();
        em.close();
    }


}
