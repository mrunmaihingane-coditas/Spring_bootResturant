package net.javaguides.springbootrestaurant.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.javaguides.springbootrestaurant.Model.Rating;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurant_id;

    private String restaurant_name;

    private String location;

    private double cleanlinessRating;
    private double ambianceRating;
    private double hygieneRating;
    private double foodRating;

    @OneToMany(mappedBy = "restaurant")
    private List<Rating> ratings = new ArrayList<>();

    // Helper Methods
    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public Restaurant(Long restaurant_id, String restaurant_name, String location, double cleanlinessRating, double ambianceRating, double hygieneRating, double foodRating, List<Rating> ratings) {
        this.restaurant_id = restaurant_id;
        this.restaurant_name = restaurant_name;
        this.location = location;
        this.cleanlinessRating = cleanlinessRating;
        this.ambianceRating = ambianceRating;
        this.hygieneRating = hygieneRating;
        this.foodRating = foodRating;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurant_id=" + restaurant_id +
                ", restaurant_name='" + restaurant_name + '\'' +
                ", location='" + location + '\'' +
                ", cleanlinessRating=" + cleanlinessRating +
                ", ambianceRating=" + ambianceRating +
                ", hygieneRating=" + hygieneRating +
                ", foodRating=" + foodRating +
                ", ratings=" + ratings +
                '}';
    }
}