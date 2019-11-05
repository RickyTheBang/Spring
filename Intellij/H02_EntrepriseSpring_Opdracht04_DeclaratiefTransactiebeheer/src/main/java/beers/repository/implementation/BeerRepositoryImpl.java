package beers.repository.implementation;

import beers.domain.Beer;
import beers.repository.BeerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository {
    private EntityManager em;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public Beer getBeerById(int id) {

        Beer beer = em.find(Beer.class, id);
        return  beer;

    }

    @Transactional
    public List<Beer> getBeerByAlcohol(float alcohol) {


        List<Beer> beerList = null;
        String sqlScript = "SELECT b FROM   Beer  as b WHERE  b.alcohol=?1";
        TypedQuery<Beer> query =
                em.createQuery(sqlScript, Beer.class);
        query.setParameter(1, alcohol);
        beerList = query.getResultList();
        return beerList;


    }

    @Transactional
    public void updateBeer(Beer b) {
        em.merge(b);

    }


}
