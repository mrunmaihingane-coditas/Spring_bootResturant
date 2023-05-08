package net.javaguides.springbootrestaurant.Repository;

import net.javaguides.springbootrestaurant.Model.Rating;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface RatingRespository  extends JpaRepository<Rating, Long> {

    @Query("SELECT AVG(r.ambianceRating) AS avgAmbianceRating, AVG(r.cleanlinessRating) AS avgCleanlinessRating, AVG(r.foodRating) AS avgFoodRating, AVG(r.hygieneRating) AS avgHygieneRating FROM Rating r WHERE r.restaurant = :r")
    Map<String, Double> getAverageRatingsByRestaurantId(@Param("r") Restaurant restaurant);


}
