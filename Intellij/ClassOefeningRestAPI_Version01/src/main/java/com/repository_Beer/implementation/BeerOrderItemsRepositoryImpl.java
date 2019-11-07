package com.repository_Beer.implementation;

import com.domain_Beer.BeerOrderItem;
import com.repository_Beer.BeerOrderItemsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository("beerOrderItemsRepository")
public class BeerOrderItemsRepositoryImpl implements BeerOrderItemsRepository {

    private EntityManager em;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public BeerOrderItem udateItemsOrder(BeerOrderItem beerOrderItems) {

        em.merge(beerOrderItems);



        return beerOrderItems;
    }


}
