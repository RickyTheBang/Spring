package broodjes.repository;

import broodjes.domain.BroodjeOrder;

public interface BroodjeOrderRepository {

    int saveOrder(BroodjeOrder order);
    BroodjeOrder getBroodjeOrderById(int id);
}
