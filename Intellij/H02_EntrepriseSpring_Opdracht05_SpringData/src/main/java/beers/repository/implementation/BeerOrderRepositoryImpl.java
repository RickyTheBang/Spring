package beers.repository.implementation;

import beers.domain.BeerOrderItem;
import beers.repository.BeerOrderRepository;
import beers.domain.BeerOrder;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository("beerOrderRepository")
public class BeerOrderRepositoryImpl implements BeerOrderRepository {
    private EntityManager em;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public int saveOrder(BeerOrder order) {





        List<BeerOrderItem> beerOrderItems;
        beerOrderItems =order.getItems();
        for(BeerOrderItem boi : beerOrderItems){
            em.persist(boi);
        }
        em.merge(order);




        return order.getId();
    }

    @Transactional
    public BeerOrder getBeerOrderById(int id) {
        BeerOrder beerOrder = em.find(BeerOrder.class, id);


        return beerOrder;
    }
}
