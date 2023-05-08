package net.javaguides.springbootrestaurant.Service;

import net.javaguides.springbootrestaurant.Model.Rating;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface RatingService {
    Rating rating(Rating customer);
    Map<String, Double> getAverageRatingsByRestaurantId(Restaurant restaurant_id);
    void updateRestaurantRatings(Restaurant restaurant_id);
}
