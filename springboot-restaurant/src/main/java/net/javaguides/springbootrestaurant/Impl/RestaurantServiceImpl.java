package net.javaguides.springbootrestaurant.Impl;



import net.javaguides.springbootrestaurant.Model.Restaurant;

import net.javaguides.springbootrestaurant.Repository.RestaurantRepository;
import net.javaguides.springbootrestaurant.Service.RestaurantService;
import net.javaguides.springbootrestaurant.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;



    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public Restaurant saveRating(Restaurant r) {
        return restaurantRepository.save(r);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();

    }

    @Override
    public Restaurant updateRestaurant(Restaurant r, Long id) {
        Restaurant existingemployee = restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));
        existingemployee.setRestaurant_name(r.getRestaurant_name());
        existingemployee.setLocation(r.getLocation());

        restaurantRepository.save(existingemployee);
        return existingemployee;
    }




    @Override
    public void deleteRestaurant( Long id) {
        Restaurant existingemployee = restaurantRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", id));
        restaurantRepository.deleteById(id);
    }

    @Override
    public List<Object[]> getAvgOfResturantById() {
        return restaurantRepository.getAvgOfResturantById();
    }




}