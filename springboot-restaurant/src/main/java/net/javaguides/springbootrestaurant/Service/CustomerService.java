package net.javaguides.springbootrestaurant.Service;

import net.javaguides.springbootrestaurant.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Customer enterratingcustomer(Customer customer);
    List<Customer>getAllCustomer();
}
