package broodjes.service;

import broodjes.domain.Broodje;
import broodjes.domain.Ingredient;


import java.util.Set;

public interface IngredientService {

    Broodje prepareBroodje(String name, Set<Ingredient> ingredients);
    
    void createBaseIngredients();


}
