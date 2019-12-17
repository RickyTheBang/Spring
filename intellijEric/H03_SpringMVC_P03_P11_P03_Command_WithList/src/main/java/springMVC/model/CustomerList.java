package springMVC.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {

    {
       this.customers.add (new Customer ("Joe","Dalton"));
        this.customers.add (new Customer ("Jack","London"));
    }

    private List<Customer> customers = new ArrayList<> ();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
