package net.javaguides.springbootrestaurant.Impl;

import net.javaguides.springbootrestaurant.Model.Rating;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.Repository.RatingRespository;
import net.javaguides.springbootrestaurant.Repository.RestaurantRepository;
import net.javaguides.springbootrestaurant.Service.RatingService;
import net.javaguides.springbootrestaurant.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RatingServiceImpl implements RatingService {

//    private final RatingRespository ratingRespository;
//    private final RestaurantRepository restaurantRepository;

    private  RatingRespository ratingRespository;
    private  RestaurantRepository restaurantRepository;

    public RatingServiceImpl(RatingRespository ratingRespository, RestaurantRepository restaurantRepository) {
        this.ratingRespository = ratingRespository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Rating rating(Rating customer) {
        return  ratingRespository.save(customer);
    }



    @Override
    public Map<String, Double> getAverageRatingsByRestaurantId(Restaurant restaurant_id) {
        return this.ratingRespository.getAverageRatingsByRestaurantId(restaurant_id);
    }

    @Override
    public void updateRestaurantRatings(Restaurant restaurant_id) {
        Long rid = restaurant_id.getRestaurant_id();
        Map<String, Double> avgRatings = ratingRespository.getAverageRatingsByRestaurantId(restaurant_id);
        Double avgAmbianceRating = avgRatings.get("avgAmbianceRating");
        System.out.println(avgAmbianceRating);
        Double avgCleanlinessRating = avgRatings.get("avgCleanlinessRating");
        System.out.println(avgCleanlinessRating);
        Double avgFoodRating = avgRatings.get("avgFoodRating");
        System.out.println(avgFoodRating);
        Double avgHygieneRating = avgRatings.get("avgHygieneRating");
        System.out.println(avgHygieneRating);

        Restaurant existingemployee = restaurantRepository.findById(rid).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", rid));
        existingemployee.setAmbianceRating(avgAmbianceRating);
        existingemployee.setCleanlinessRating(avgCleanlinessRating);
        existingemployee.setFoodRating(avgFoodRating);
        existingemployee.setHygieneRating(avgHygieneRating);

        restaurantRepository.save(existingemployee);

    }

    }

