package beers.app;

import beers.AppConfig;
import beers.domain.Beer;
import beers.repository.BeerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;


@SpringBootApplication
public class BeersApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
        BeerRepository br = ctx.getBean("beerRepository", BeerRepository.class);
        Beer beer = br.getBeerById(10);
        List<Beer> beerList = br.getBeerByAlcohol(2.5f);
        System.out.println(beer);
        for(Beer b:beerList){
            System.out.println(b.getName());
        }
    }
}

