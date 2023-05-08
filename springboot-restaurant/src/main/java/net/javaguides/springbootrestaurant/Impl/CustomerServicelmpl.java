package net.javaguides.springbootrestaurant.Impl;

import net.javaguides.springbootrestaurant.Model.Customer;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.Repository.CustomerRespository;
import net.javaguides.springbootrestaurant.Repository.RestaurantRepository;
import net.javaguides.springbootrestaurant.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServicelmpl implements CustomerService {


    private CustomerRespository customerRespository;

    public CustomerServicelmpl(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public Customer enterratingcustomer(Customer customer) {
        return customerRespository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRespository.findAll();
    }
}
