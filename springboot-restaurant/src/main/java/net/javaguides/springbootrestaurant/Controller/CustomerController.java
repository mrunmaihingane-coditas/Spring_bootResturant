package net.javaguides.springbootrestaurant.Controller;

import net.javaguides.springbootrestaurant.Model.Customer;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.Service.CustomerService;
import net.javaguides.springbootrestaurant.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping()
    public List<Customer> getAllEmployees(){
       return customerService.getAllCustomer();
    }


    //build create employee REST API
    @PostMapping("/savecust")
    public ResponseEntity<Customer> saveCust(@RequestBody Customer c){
        return new ResponseEntity<Customer>(customerService.enterratingcustomer(c), HttpStatus.CREATED);
    }


}
