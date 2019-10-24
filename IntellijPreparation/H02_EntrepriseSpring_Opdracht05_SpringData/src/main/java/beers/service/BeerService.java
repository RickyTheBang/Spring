package beers.service;

public interface BeerService {

    int orderBeer(String name, int beerId, int number);
        int orderBeers(String name, int[][] order);
}
