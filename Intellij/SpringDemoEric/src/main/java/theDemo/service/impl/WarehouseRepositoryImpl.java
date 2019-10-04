package theDemo.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;
import theDemo.model.BeanType;
import theDemo.repository.WharehouseRepository;
import theDemo.service.WarehouseService;

@Repository
//@Primary
@Order(2)
public class WarehouseRepositoryImpl implements WharehouseRepository {


    @Bean
    public WarehouseService beanCreationMethod(){
        return new WarehouseServiceImpl (new WarehouseRepositoryImpl ());
    }
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
