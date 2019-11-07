package com.service_Beer;

public interface BeerService {

    int orderBeer(String name, int beerId, int number);
        int orderBeers(String name, int[][] order);
}
