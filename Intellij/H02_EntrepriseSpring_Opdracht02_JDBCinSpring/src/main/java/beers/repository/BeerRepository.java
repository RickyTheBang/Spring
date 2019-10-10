package beers.repository;

import beers.domain.Beer;

import java.util.List;

public interface BeerRepository {
    Beer getBeerById(int id);
   public List<Beer> getBeerByAlcohol(float alcohol);
   public void updateBeer(Beer b);
}