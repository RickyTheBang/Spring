package theDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import theDemo.repository.WharehouseRepository;
import theDemo.service.WarehouseService;
import theDemo.service.impl.WarehouseRepositoryImpl;
import theDemo.service.impl.WarehouseServiceImpl;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean(name = "normalWarehouse")
    public WarehouseService createWharehouseService(){
        return new WarehouseServiceImpl (createWarehouseRepository());
    }
    @Bean(name = "bxlWarehouse")
    public WarehouseService createBxlWharehouseService(){
        return new WarehouseServiceImpl (createWarehouseRepository());
    }

    public WharehouseRepository createWarehouseRepository() {
        return  new WarehouseRepositoryImpl ();
    }
}
