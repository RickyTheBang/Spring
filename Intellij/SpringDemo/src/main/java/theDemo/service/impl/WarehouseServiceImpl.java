package theDemo.service.impl;

import org.springframework.stereotype.Service;
import theDemo.model.BeanType;
import theDemo.model.Order;
import theDemo.model.OrderLine;
import theDemo.repository.WharehouseRepository;
import theDemo.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    private WharehouseRepository wharehouseRepository;

    public WarehouseServiceImpl(WharehouseRepository repository){
        this.wharehouseRepository = repository;
    }
    @Override
    public int checkStock(BeanType type) {

       return wharehouseRepository.getBeanCountByType (type);

    }

    @Override
    public boolean reserveBeans(BeanType type, int quantity) {
      boolean reservationSuccess =  wharehouseRepository.takeBeansFromStock(type, quantity);
      moveBeansToStagingArea(type,quantity);
        return false;
    }

    @Override
    public void checkoutOrder(Order order) {
        wharehouseRepository.removeOrderFromStagingArea( order.getBeanType (), order.getOrderNumber () );
       for(OrderLine line : order.getLines()){
           wharehouseRepository.removeOrderFromStagingArea(line.getType() , line.getNumber());
       }


    }

    private void moveBeansToStagingArea(BeanType type, int quantity){
        wharehouseRepository.updateStagingArea(type,quantity);
        createTicketForPeon(type,quantity);
    }

    private void createTicketForPeon(BeanType type, int quantity) {
        // Send som shit to printer
    }
}
