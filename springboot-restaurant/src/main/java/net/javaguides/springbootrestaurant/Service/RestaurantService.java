package net.javaguides.springbootrestaurant.Service;

import net.javaguides.springbootrestaurant.Model.Customer;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.exception.ResourceNotFoundException;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    Restaurant saveRating(Restaurant r);
    List<Restaurant> getAllRestaurant();
    Restaurant updateRestaurant(Restaurant r,Long id);
    void deleteRestaurant(Long id);

    List<Object[]> getAvgOfResturantById();


}
