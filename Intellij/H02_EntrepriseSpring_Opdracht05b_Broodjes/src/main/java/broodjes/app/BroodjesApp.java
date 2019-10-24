package broodjes.app;

import broodjes.AppConfig;
import broodjes.domain.Ingredient;
import broodjes.repository.BroodjeRepository;
import broodjes.repository.IngredientRepository;
import broodjes.service.IngredientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication
public class BroodjesApp {


    public static void main(String[] args) {

       ConfigurableApplicationContext ctx = SpringApplication.run(AppConfig.class, args);

        IngredientRepository ingredientRepository =ctx.getBean("ingredientRepository", IngredientRepository.class);
        BroodjeRepository broodjeRepository =ctx.getBean("broodjeRepository", BroodjeRepository.class);
        IngredientService broodjeService =ctx.getBean("broodjeService", IngredientService.class);

        //1) Creation  of ingredients
        Ingredient ingredientBroodje = new Ingredient ("Broodje",5);
        ingredientRepository.updateIngredient (ingredientBroodje);
        Ingredient ingredientCheese = new Ingredient ("Cheese",10);
        ingredientRepository.updateIngredient (ingredientCheese);
        Ingredient ingredientHam = new Ingredient ("Ham",15);
        ingredientRepository.updateIngredient (ingredientHam);

        //2) Creation of ingredients lists
        Set<Ingredient> ingredients_01 = new HashSet<> ();
        ingredients_01.add (ingredientBroodje);
        ingredients_01.add (ingredientCheese);
        ingredients_01.add (ingredientHam);

       broodjeService.prepareBroodje ("broodje01",ingredients_01);




        /*BeerService bs = ctx.getBean("beerService", BeerService.class);
        Beer beer01  = br.getBeerById(14);
        System.out.println("before order");
        System.out.println(beer01);
        bs.orderBeer("Order 10",14,7);
        System.out.println("after order");
        Beer beer02  = br.getBeerById(14);
        System.out.println(beer02);
        BeerOrderRepository bor = ctx.getBean("beerOrderRepository", BeerOrderRepository.class);
        BeerOrder beerOrder = bor.getBeerOrderById(6);
        System.out.println(beerOrder);*/

    }
}

