package Pokkemon.repository;

import Pokkemon.model.Pokkemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public interface PokkemonRepository extends JpaRepository<Pokkemon, Integer> {


    default Pokkemon getPokkemonbyId(int id) {

        return findById(id).orElse(null);


    }


    default void savePokkemon(Pokkemon pokemon) {
        save(pokemon);
    }


    @Transactional
    @Query(value = "select p from Pokkemon  p")
    public   List<Pokkemon> getAllPokkemons();

    @Transactional
    @Modifying
    @Query(name ="pokkemon_delete")
    public void deleteAllPokkemon();


}
