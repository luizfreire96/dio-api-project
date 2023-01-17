package firstapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import firstapi.api.model.Customer;
import firstapi.api.services.CustomerService;

/**
 * asdasdasdasd
 */

@RestController
@RequestMapping("customers")
public class CustomersController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Customer>> findaAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    
    @PostMapping
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer){
        customerService.insertCustomer(customer);
        return ResponseEntity.ok(customer);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Customer> putCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.putCustomer(id, customer);
        return ResponseEntity.ok(customer);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.findById(id));
    }
}
