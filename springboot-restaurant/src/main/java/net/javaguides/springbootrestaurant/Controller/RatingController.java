package net.javaguides.springbootrestaurant.Controller;

import net.javaguides.springbootrestaurant.Model.Rating;
import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.Service.RatingService;
import net.javaguides.springbootrestaurant.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
    private RatingService ratingService;

    public RatingController(RatingService ratingService) throws ResourceNotFoundException {
        this.ratingService = ratingService;
    }
    //build create employee REST API
    @PostMapping("/saveRating")
    public ResponseEntity<Rating> saveEmployee(@RequestBody Rating restaurant) throws ResourceNotFoundException{
        return new ResponseEntity<Rating>(ratingService.rating(restaurant), HttpStatus.CREATED);
    }
//    @GetMapping("/average/{id}")
//    public Map<String, Double> getAverageRatings(@PathVariable("id") Restaurant restaurant_id) {
//        return ratingService.getAverageRatingsByRestaurantId(restaurant_id);
//    }
    @GetMapping("/average/{id}")
    public ResponseEntity<Map<String, Double>> getAverageRatings(@PathVariable("id") Restaurant restaurant_id) throws ResourceNotFoundException{
        Map<String, Double> averageRatings = ratingService.getAverageRatingsByRestaurantId(restaurant_id);
        return ResponseEntity.ok(averageRatings);
    }
    @PutMapping("/update/{restaurant_id}")
    public ResponseEntity<String> updateRestaurantRatings(@PathVariable Restaurant restaurant_id) throws ResourceNotFoundException{
        ratingService.updateRestaurantRatings(restaurant_id);
        return ResponseEntity.ok("Restaurant ratings updated successfully.");
    }


}
