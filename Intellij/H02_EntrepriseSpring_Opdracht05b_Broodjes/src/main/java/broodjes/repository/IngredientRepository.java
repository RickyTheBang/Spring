package broodjes.repository;

import broodjes.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {

    default Ingredient getIngredientById(int id) {
        return findById (id).orElse (null);
    }

    default void updateIngredient(Ingredient i) {
        save (i);
    }


    @Transactional
    @Query(value = "select i from Ingredient i where i.name=?1")
    public Ingredient getIngredientByName(String name);



    @Transactional
    @Query(value = "select i from Ingredient i")
    public List<Ingredient> getAllIngredient();




    @Transactional
    @Modifying
    @Query(name ="Ingredient_delete")
    public void deleteAllIngredient();


}