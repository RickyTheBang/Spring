package beers.repository;

import beers.domain.BeerOrderItems;

public interface BeerOrderItemsRepository {

    BeerOrderItems udateItemsOrder(BeerOrderItems orderItems);
}
