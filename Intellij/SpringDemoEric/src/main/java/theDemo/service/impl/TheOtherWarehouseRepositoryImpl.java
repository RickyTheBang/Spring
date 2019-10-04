package theDemo.service.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import theDemo.model.BeanType;
import theDemo.repository.WharehouseRepository;

@Repository
//@Qualifier("TheOtherRepository")
@Order(1)
public class TheOtherWarehouseRepositoryImpl implements WharehouseRepository {
    @Override
    public int getBeanCountByType(BeanType type) {
        return 0;
    }

    @Override
    public void updateStagingArea(BeanType type, int quantity) {

    }

    @Override
    public boolean takeBeansFromStock(BeanType type, int quantity) {
        return false;
    }

    @Override
    public void removeOrderFromStagingArea(BeanType type, int number) {

    }
}
