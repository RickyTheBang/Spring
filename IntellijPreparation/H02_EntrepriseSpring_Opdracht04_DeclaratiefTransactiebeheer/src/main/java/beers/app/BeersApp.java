package beers.app;

import beers.AppConfig;
import beers.domain.Beer;
import beers.domain.BeerOrder;
import beers.domain.BeerOrderItems;
import beers.repository.BeerOrderRepository;
import beers.repository.BeerRepository;
import beers.service.BeerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class BeersApp {
    public static void main(String[] args) {

       ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        BeerRepository br = ctx.getBean("beerRepository", BeerRepository.class);
        BeerService bs = ctx.getBean("beerService", BeerService.class);
        Beer beer01  = br.getBeerById(14);
        System.out.println("before order");
        System.out.println(beer01);
        bs.orderBeer("Order 10",14,7);
        System.out.println("after order");
        Beer beer02  = br.getBeerById(14);
        System.out.println(beer02);
        BeerOrderRepository bor = ctx.getBean("beerOrderRepository", BeerOrderRepository.class);
        BeerOrder beerOrder = bor.getBeerOrderById(6);
        System.out.println(beerOrder);

    }
}

