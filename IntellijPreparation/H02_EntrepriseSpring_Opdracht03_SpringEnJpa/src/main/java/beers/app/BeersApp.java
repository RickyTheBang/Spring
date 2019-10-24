package beers.app;

import beers.AppConfig;
import beers.domain.Beer;
import beers.repository.BeerOrderItemsRepository;
import beers.repository.BeerOrderRepository;
import beers.repository.BeerRepository;
import beers.domain.BeerOrder;
import beers.domain.BeerOrderItems;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class BeersApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
        //A) BeerRepository
        BeerRepository br = ctx.getBean("beerRepository", BeerRepository.class);
        Beer beerId1 = br.getBeerById(14);
        Beer beerId2 = br.getBeerById(15);


        //B BeerOrderRepository
        //1) BeerOrderItems
        //1a) Single Items
        BeerOrderItems orderItems1 = new BeerOrderItems();
        BeerOrderItems orderItems2 = new BeerOrderItems();
        orderItems1.setBeer(beerId1);
        orderItems2.setBeer(beerId2);
        orderItems1.setNumber(4);
        orderItems2.setNumber(5);

        //1b) List Items
        List<BeerOrderItems> beersOrderItems01 = new ArrayList<>();
        beersOrderItems01.add(orderItems1);
        beersOrderItems01.add(orderItems2);


        //2) BeerOrderRepository


        BeerOrder order01 = new BeerOrder();
        order01.setName("Order 8");
        order01.setItems(beersOrderItems01);

        BeerOrderRepository bor = ctx.getBean("beerOrderRepository", BeerOrderRepository.class);
        bor.saveOrder(order01);


        BeerOrder beerOrder = bor.getBeerOrderById(2);
        System.out.println(beerOrder);


    }
}

