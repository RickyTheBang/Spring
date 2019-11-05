package beers.repository;

import beers.domain.BeerOrder;

public interface BeerOrderRepository {

    int saveOrder(BeerOrder order);
    BeerOrder getBeerOrderById(int id);
}
