package firstapi.api.services.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import firstapi.api.model.Adress;
import firstapi.api.model.AdressRepository;
import firstapi.api.model.Customer;
import firstapi.api.model.CustomerRepository;
import firstapi.api.services.AdressService;
import firstapi.api.services.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    private AdressService adressService;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.get();  
    }

    @Override
    public void insertCustomer(Customer customer) {
        saveCustomerWithCep(customer);
    }
    
    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
    
    @Override
    public void putCustomer(Long id, Customer customer) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if (customer1.isPresent()){
            saveCustomerWithCep(customer);
        }
    }
    
    
    private void saveCustomerWithCep(Customer customer) {
        String cep = customer.getAdress().getCep();
        Adress adress = adressRepository.findById(cep).orElseGet(() -> {
            Adress newAdress = adressService.cepQuery(cep);
            adressRepository.save(newAdress);
            return newAdress;
        });
        
        customer.setAdress(adress);
        customerRepository.save(customer);
    }

}
