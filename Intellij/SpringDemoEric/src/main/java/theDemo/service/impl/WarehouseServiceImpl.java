package theDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import theDemo.model.BeanType;
import theDemo.model.Order;
import theDemo.model.OrderLine;
import theDemo.repository.WharehouseRepository;
import theDemo.service.WarehouseService;

@Service
@Primary
public class WarehouseServiceImpl implements WarehouseService {


    /* Field injection annotatie
    @Autowired
     */
    private WharehouseRepository wharehouseRepository;

   /* Constructor injection annotatie
   @Autowired
    */
    @Autowired
    // public WarehouseServiceImpl(@Qualifier("TheOtherRepository") WharehouseRepository repository) {
    public WarehouseServiceImpl( WharehouseRepository repository) {
        this.wharehouseRepository = repository;
    }

    @Override
    public int checkStock(BeanType type) {

        return wharehouseRepository.getBeanCountByType (type);

    }

    @Override
    public boolean reserveBeans(BeanType type, int quantity) {
        boolean reservationSuccess = wharehouseRepository.takeBeansFromStock (type, quantity);
        moveBeansToStagingArea (type, quantity);
        return false;
    }

    @Override
    public void checkoutOrder(Order order) {
        wharehouseRepository.removeOrderFromStagingArea (order.getBeanType ( ), order.getOrderNumber ( ));
        for (OrderLine line : order.getLines ( )) {
            wharehouseRepository.removeOrderFromStagingArea (line.getType ( ), line.getNumber ( ));
        }


    }

    private void moveBeansToStagingArea(BeanType type, int quantity) {
        wharehouseRepository.updateStagingArea (type, quantity);
        createTicketForPeon (type, quantity);
    }

    private void createTicketForPeon(BeanType type, int quantity) {
        // Send som shit to printer
    }
}
