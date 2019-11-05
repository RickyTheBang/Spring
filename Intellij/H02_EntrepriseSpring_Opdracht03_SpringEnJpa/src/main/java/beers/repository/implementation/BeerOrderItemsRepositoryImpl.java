package beers.repository.implementation;

import beers.repository.BeerOrderItemsRepository;
import beers.domain.BeerOrderItems;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
@Repository("beerOrderItemsRepository")
public class BeerOrderItemsRepositoryImpl implements BeerOrderItemsRepository {


    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public BeerOrderItems udateItemsOrder(BeerOrderItems beerOrderItems) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(beerOrderItems);
        tx.commit();
        em.close();


        return beerOrderItems;
    }


}
