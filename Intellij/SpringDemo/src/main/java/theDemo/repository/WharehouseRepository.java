package theDemo.repository;

import theDemo.model.BeanType;

public class WharehouseRepository {

  public  int getBeanCountByType(BeanType type){
        return 0;
    }

    public void updateStagingArea(BeanType type, int quantity) {
    }

    public boolean takeBeansFromStock(BeanType type, int quantity) {
      return false;
    }

    public void removeOrderFromStagingArea(BeanType type, int number) {
    }
}

