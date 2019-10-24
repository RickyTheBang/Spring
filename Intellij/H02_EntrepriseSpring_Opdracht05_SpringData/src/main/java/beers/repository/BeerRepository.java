package beers.repository;

import beers.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/*@RepositoryDefinition(domainClass = Beer.class,idClass = Integer.class)*/
public interface BeerRepository extends JpaRepository<Beer,Integer> {

     default Beer getBeerById(int id){
        return findById(id).orElse(null);
    }

     default  void updateBeer(Beer b){
        save(b);
    }

    @Query(name ="findBeersByAlcohol")
     List<Beer> getBeerByAlcohol(float alcohol);

}