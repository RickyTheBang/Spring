package com.repository_Beer;

import com.domain_Beer.BeerOrder;

public interface BeerOrderRepository {

    int saveOrder(BeerOrder order);
    BeerOrder getBeerOrderById(int id);
}
