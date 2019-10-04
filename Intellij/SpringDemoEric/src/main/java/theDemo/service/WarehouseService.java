package theDemo.service;

import theDemo.model.BeanType;
import theDemo.model.Order;

public interface WarehouseService {

    int checkStock(BeanType type);

    boolean reserveBeans(BeanType type, int quantity);
    void checkoutOrder(Order order);

}
