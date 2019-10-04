package theDemo.repository;

import theDemo.model.BeanType;

public interface WharehouseRepository {

  public  int getBeanCountByType(BeanType type);

    public void updateStagingArea(BeanType type, int quantity) ;

    public boolean takeBeansFromStock(BeanType type, int quantity) ;

    public void removeOrderFromStagingArea(BeanType type, int number) ;
}

