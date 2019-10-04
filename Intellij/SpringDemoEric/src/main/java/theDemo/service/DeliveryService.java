package theDemo.service;

import theDemo.model.Order;

import java.time.LocalDate;

public interface DeliveryService {

    void startDelivery(Order order);
    void planDelivery(Order order, LocalDate date);
}
