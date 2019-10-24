package broodjes.repository.implementation;

import broodjes.domain.BroodjeOrderItem;
import broodjes.repository.BroodjeOrderItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository("beerOrderItemsRepository")
public class BroodjeOrderItemRepositoryImpl implements BroodjeOrderItemRepository {

    private EntityManager em;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public BroodjeOrderItem udateOrderItem(BroodjeOrderItem broodjeOrderItem) {

        em.merge(broodjeOrderItem);



        return broodjeOrderItem;
    }



}
