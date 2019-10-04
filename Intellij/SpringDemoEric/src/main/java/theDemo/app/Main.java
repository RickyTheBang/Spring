package theDemo.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import theDemo.AppConfig;
import theDemo.eventHandling.EventCreator;
import theDemo.eventHandling.InterestedClass;
import theDemo.model.BeanType;
import theDemo.service.WarehouseService;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext (AppConfig.class);
       /* context.getEnvironment ().setActiveProfiles ("BXL");
        context.refresh ();*/
       WarehouseService warehouseService = context.getBean ("normalWarehouse", WarehouseService.class);

       warehouseService.checkStock (new BeanType ());

        EventCreator times = new EventCreator ();
        InterestedClass yves = new InterestedClass ();
        yves.setCreator (times);
        times.register (yves);


        //yves.setCreator (Times);

        times.setState (5);
        //yves.shitHasChange ();
    }
}
