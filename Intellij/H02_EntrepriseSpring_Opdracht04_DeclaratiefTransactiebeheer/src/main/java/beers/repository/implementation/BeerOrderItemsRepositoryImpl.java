package beers.repository.implementation;

import beers.repository.BeerOrderItemsRepository;
import beers.domain.BeerOrderItems;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository("beerOrderItemsRepository")
public class BeerOrderItemsRepositoryImpl implements BeerOrderItemsRepository {

    private EntityManager em;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public BeerOrderItems udateItemsOrder(BeerOrderItems beerOrderItems) {

        em.merge(beerOrderItems);



        return beerOrderItems;
    }


}
