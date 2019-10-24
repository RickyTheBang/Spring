package beers.repository.implementation;

import beers.domain.BeerOrderItems;
import beers.repository.BeerOrderRepository;
import beers.domain.BeerOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository("beerOrderRepository")
public class BeerOrderRepositoryImpl implements BeerOrderRepository {
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public int saveOrder(BeerOrder order) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        List<BeerOrderItems> beerOrderItems;
        beerOrderItems =order.getItems();
        for(BeerOrderItems boi : beerOrderItems){
            em.persist(boi);
        }
        em.merge(order);

        tx.commit();
        em.close();


        return order.getId();
    }

    @Override
    public BeerOrder getBeerOrderById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        BeerOrder beerOrder = em.find(BeerOrder.class, id);

        tx.commit();
        em.close();
        return beerOrder;
    }
}
