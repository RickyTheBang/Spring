package com.repository_Beer.implementation;

import com.domain_Beer.BeerOrder;
import com.domain_Beer.BeerOrderItem;
import com.repository_Beer.BeerOrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
