package theDemo.service;

import theDemo.model.Customer;
import theDemo.model.Invoice;
import theDemo.model.Order;

public interface UserService {

    Customer getCustomer(int id);

    Customer getCustomer(Customer customer);

    /*Query by example (Jpa technic),
  these methode uses the 2 following methods.
     */
    Customer getCustomerByLogin(String login);

    Customer getCustomerByName(String name);

    interface BillingService {

        Invoice createInvoice(Order order);
    }
}
