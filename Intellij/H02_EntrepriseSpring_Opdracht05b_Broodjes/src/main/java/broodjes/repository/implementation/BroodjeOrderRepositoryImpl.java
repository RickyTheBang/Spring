package broodjes.repository;

import broodjes.domain.BroodjeOrder;
import broodjes.domain.BroodjeOrderItem;
import broodjes.repository.BroodjeOrderRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository("beerOrderRepository")
public class BroodjeOrderRepositoryImpl implements BroodjeOrderRepository {
    private EntityManager em;


    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }



    @Transactional
    public int saveOrder(BroodjeOrder order) {





        List<BroodjeOrderItem> broodjeOrderItem;
        broodjeOrderItem =order.getItems();
        for(BroodjeOrderItem boi : broodjeOrderItem){
            em.persist(boi);
        }
        em.merge(order);




        return order.getId();
    }

    @Transactional
    public BroodjeOrder getBroodjeOrderById(int id) {
        BroodjeOrder broodjeOrder = em.find(BroodjeOrder.class, id);


        return broodjeOrder;
    }
}
