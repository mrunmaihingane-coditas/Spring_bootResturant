package net.javaguides.springbootrestaurant.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rating_id;

    private double cleanlinessRating;
    private double ambianceRating;
    private double hygieneRating;
    private double foodRating;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public Rating(Long rating_id, double cleanlinessRating, double ambianceRating, double hygieneRating, double foodRating, Customer customer, Restaurant restaurant) {
        this.rating_id = rating_id;
        this.cleanlinessRating = cleanlinessRating;
        this.ambianceRating = ambianceRating;
        this.hygieneRating = hygieneRating;
        this.foodRating = foodRating;
        this.customer = customer;
        this.restaurant = restaurant;
    }
}