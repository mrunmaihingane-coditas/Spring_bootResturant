package net.javaguides.springbootrestaurant.Controller;

import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.Service.RestaurantService;
import net.javaguides.springbootrestaurant.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/restaurant")

public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }

    //build get All restaurant REST API
    @GetMapping()
    public List<Restaurant> getAllEmployees(){
        return restaurantService.getAllRestaurant();
    }


    //build create employee REST API
    @PostMapping("/saveRestaurant")
    public ResponseEntity<Restaurant> saveEmployee(@RequestBody Restaurant restaurant){
        return new ResponseEntity<Restaurant>(restaurantService.saveRating(restaurant), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Restaurant> updaterest(@PathVariable("id") Long employeeId, @RequestBody Restaurant employee) throws ResourceNotFoundException {
        return new ResponseEntity<Restaurant>(restaurantService.updateRestaurant(employee,employeeId),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        restaurantService.deleteRestaurant(employeeId);

        return new ResponseEntity<String>("Restaurant  deleted successfully",HttpStatus.OK);
    }
//    @GetMapping("/totalavg")
//    public ResponseEntity<Map<Integer, Double>> getAverageRatings() {
//        Map<Integer, Double> averageRating1 = restaurantService.getAvgOfRestaurantById();
//        return ResponseEntity.ok(averageRating1);
//    }
    @GetMapping("/totalavg")
    public  List<Object[]>  getAverageRatings() {
        return restaurantService.getAvgOfResturantById();
    }



}