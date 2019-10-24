package h02_Opdracht02.app;

import java.util.List;

import h02_Opdracht02.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import h02_Opdracht02.dao.BeerDao;
import h02_Opdracht02.model.Beer;

@SpringBootApplication
public class BeerApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =SpringApplication.run(AppConfig.class,args);
		BeerDao dao = ctx.getBean("beerDao",BeerDao.class);
		System.out.println(dao.getBeerById(4));
		dao.setStock(1, 200);
		

		
		

		List<String> beers = dao.getBeerByAlcohool(5);
		
		
		
		  for(String b :beers) { System.out.println(b); }
		 
	}
	

}

