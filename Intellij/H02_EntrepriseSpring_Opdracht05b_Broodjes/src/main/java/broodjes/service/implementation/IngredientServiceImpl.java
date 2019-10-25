package broodjes.service.implementation;

import broodjes.domain.Broodje;
import broodjes.domain.Ingredient;
import broodjes.repository.BroodjeRepository;
import broodjes.repository.IngredientRepository;
import broodjes.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service("ingredientService")
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    BroodjeRepository broodjeRepository;

    @PostConstruct
    public void init(){
        createBaseIngredients();
    }

    @Override
    public Broodje prepareBroodje(String name, Set<Ingredient> ingredients) {
        Broodje broodje = new Broodje (name,ingredients);
        broodjeRepository.updateBroodje (broodje);

        return broodje;

    }

    @Override
    public void createBaseIngredients() {

        // 1) The existing records are deleted
        ingredientRepository.deleteAllIngredient ();
        //2) Creation  of ingredients
        Ingredient ingredientBroodje = new Ingredient ("Broodje",5);
        ingredientRepository.updateIngredient (ingredientBroodje);
        Ingredient ingredientCheese = new Ingredient ("Cheese",10);
        ingredientRepository.updateIngredient (ingredientCheese);
        Ingredient ingredientHam = new Ingredient ("Ham",15);
        ingredientRepository.updateIngredient (ingredientHam);
        Ingredient ingredientMusterd = new Ingredient ("Musterd",1.5f);
        ingredientRepository.updateIngredient (ingredientMusterd);
    }
}
