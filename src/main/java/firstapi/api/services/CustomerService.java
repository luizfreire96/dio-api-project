package firstapi.api.services;

import firstapi.api.model.Customer;

public interface CustomerService {

    Iterable<Customer> findAll();

    Customer findById(Long id);

    void insertCustomer(Customer customer);

    void deleteCustomer(Long id);

    void putCustomer(Long id, Customer customer);
    
    
}
