package broodjes.app;

import broodjes.domain.Broodje;
import broodjes.domain.Ingredient;
import broodjes.repository.BroodjeRepository;
import broodjes.repository.IngredientRepository;
import broodjes.service.BroodjeService;
import broodjes.service.IngredientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;


@SpringBootApplication(scanBasePackages = {"broodjes"})
public class BroodjesApp {


    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run (BroodjesApp.class, args);

        IngredientRepository ingredientRepository = ctx.getBean ("ingredientRepository", IngredientRepository.class);
        BroodjeRepository broodjeRepository = ctx.getBean ("broodjeRepository", BroodjeRepository.class);
        IngredientService ingredientService = ctx.getBean ("ingredientService", IngredientService.class);
        BroodjeService broodjeService = ctx.getBean ("broodjeService", BroodjeService.class);


        //1) Creation of ingredients lists
        broodjeRepository.deleteAllBroodje ( );


        //2.1) First broodje
        Set<Ingredient> ingredients_01 = new HashSet<> ( );
        ingredients_01.add (ingredientRepository.getIngredientByName ("Broodje"));
        ingredients_01.add (ingredientRepository.getIngredientByName ("Ham"));
        ingredients_01.add (ingredientRepository.getIngredientByName ("Musterd"));
        Broodje broodje01 = ingredientService.prepareBroodje ("broodje01", ingredients_01);


        //2.1) Second broodje
        Set<Ingredient> ingredients_02 = new HashSet<> ( );
        ingredients_02.add (ingredientRepository.getIngredientByName ("Broodje"));
        ingredients_02.add (ingredientRepository.getIngredientByName ("Ham"));
        ingredients_02.add (ingredientRepository.getIngredientByName ("Musterd"));
        Broodje broodje02 = ingredientService.prepareBroodje ("broodje01", ingredients_02);

        broodjeService.orderBroodje ("order01", broodje02.getId ( ), 2);


        int[][] arrayOrder02 = new int[][]{{broodje01.getId ( ), 2}, {broodje01.getId ( ), 2}};

        broodjeService.orderBroodjes ("order02", arrayOrder02);


    }
}

