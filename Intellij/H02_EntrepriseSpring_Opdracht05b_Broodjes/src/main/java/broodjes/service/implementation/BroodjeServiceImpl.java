package broodjes.service.implementation;

import broodjes.domain.Broodje;
import broodjes.domain.BroodjeOrder;
import broodjes.domain.BroodjeOrderItem;
import broodjes.repository.BroodjeOrderRepository;
import broodjes.repository.BroodjeRepository;
import broodjes.service.BroodjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service("broodjeService")
public class BroodjeServiceImpl implements BroodjeService {
    private BroodjeOrderRepository orderRepository;
    private BroodjeRepository repository;

    @Autowired
    public void setBeerOrderRepository(BroodjeOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setBeerRepository(BroodjeRepository repository) {
        this.repository = repository;
    }





    @Override
    @Transactional
    public int orderBroodje(String name, int broodjeId, int number) {

        List<BroodjeOrderItem> broodjeOrderItems01 = new ArrayList<> ();


        Broodje broodjeId1 = repository.getBroodjeById(broodjeId);

        BroodjeOrderItem orderItems1 = new BroodjeOrderItem ();
        orderItems1.setBroodje (broodjeId1);
        orderItems1.setNumber(number);
        broodjeOrderItems01.add(orderItems1);
        BroodjeOrder order01 = new BroodjeOrder();
        order01.setName(name);
        order01.setItems(broodjeOrderItems01);

        orderRepository.saveOrder(order01);

        return 0;
    }

    @Override
    public int orderBroodjes(String name, int[][] order) {

        List<BroodjeOrderItem> broodjeOrderItems01 = new ArrayList<> ();

        for(int[] orderId : order){
            Broodje broodjeId1 = repository.getBroodjeById(orderId[0]);
            BroodjeOrderItem orderItems1 = new BroodjeOrderItem ();
            orderItems1.setBroodje (broodjeId1);
            orderItems1.setNumber(orderId[1]);
            broodjeOrderItems01.add(orderItems1);
            }
        BroodjeOrder order01 = new BroodjeOrder();
        order01.setName(name);
        order01.setItems(broodjeOrderItems01);

        orderRepository.saveOrder(order01);

        return 0;
    }
}
