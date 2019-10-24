package beers.service.implementation;

import beers.domain.Beer;
import beers.domain.BeerOrder;
import beers.domain.BeerOrderItem;
import beers.repository.BeerOrderRepository;
import beers.repository.BeerRepository;
import beers.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("beerService")
public class BeerServiceImpl implements BeerService {

    private BeerOrderRepository orderRepository;
    private BeerRepository repository;

    @Autowired
    public void setBeerOrderRepository(BeerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setBeerRepository(BeerRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public int orderBeer(String name, int beerId, int number) {
        Beer beerId1 = repository.getBeerById(beerId);
        beerId1.setStock(beerId1.getStock()-number);
        BeerOrderItem orderItems1 = new BeerOrderItem ();
        orderItems1.setBeer(beerId1);
        orderItems1.setNumber(number);
        List<BeerOrderItem> beersOrderItems01 = new ArrayList<>();
        beersOrderItems01.add(orderItems1);
        BeerOrder order01 = new BeerOrder();
        order01.setName(name);
        order01.setItems(beersOrderItems01);

        orderRepository.saveOrder(order01);

        return 0;
    }

    @Transactional
    public int orderBeers(String name, int[][] order) {
        return 0;
    }
}
