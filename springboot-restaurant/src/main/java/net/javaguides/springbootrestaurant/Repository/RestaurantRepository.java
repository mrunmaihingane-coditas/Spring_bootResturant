package net.javaguides.springbootrestaurant.Repository;

import net.javaguides.springbootrestaurant.Model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Modifying
    @Query("UPDATE Restaurant r SET r.ambianceRating = :ambianceRating, r.cleanlinessRating = :cleanlinessRating, r.foodRating = :foodRating, r.hygieneRating = :hygieneRating WHERE r.id = :id")
    void updateRestaurantRatings(@Param("id") Restaurant id, @Param("ambianceRating") Double ambianceRating, @Param("cleanlinessRating") Double cleanlinessRating, @Param("foodRating") Double foodRating, @Param("hygieneRating") Double hygieneRating);

//    @Query("SELECT restaurant_id, (ambianceRating + cleanlinessRating + foodRating + hygieneRating)/4 AS avg_rating FROM restaurant")
//    Map<Integer, Double>getAvgOfRestaurantById();
@Query("SELECT restaurant_id, (ambianceRating + cleanlinessRating + foodRating + hygieneRating)/4 AS avg_rating FROM Restaurant")
List<Object[]> getAvgOfResturantById();


}


