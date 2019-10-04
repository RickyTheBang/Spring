package theDemo;

import org.springframework.context.annotation.*;
import theDemo.repository.WharehouseRepository;
import theDemo.service.WarehouseService;
import theDemo.service.impl.WarehouseRepositoryImpl;
import theDemo.service.impl.WarehouseServiceImpl;

@Configuration
@ComponentScan
@Import (AppConfig2.class)
public class AppConfig {
    @Bean(name = "normalWarehouse")
@Primary
    public WarehouseService createWharehouseService() {
        return new WarehouseServiceImpl (createWarehouseRepository ( ));
    }
    @Profile ("BXL")
    @Bean(name = "bxlWarehouse")
    public WarehouseService createBxlWharehouseService() {
        return new WarehouseServiceImpl (createWarehouseRepository ( ));
    }

    @Bean
    @Primary
   // @Profile ("PARKING")
    public WharehouseRepository createWarehouseRepository() {
        return new WarehouseRepositoryImpl ( );
    }


    @Bean
    public WharehouseRepository createAnotherWarehouseRepository() {
        return new WarehouseRepositoryImpl ( );
    }

}