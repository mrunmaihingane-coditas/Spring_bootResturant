package net.javaguides.springbootrestaurant;

import net.javaguides.springbootrestaurant.Model.Restaurant;
import net.javaguides.springbootrestaurant.Repository.RatingRespository;
import net.javaguides.springbootrestaurant.Repository.RestaurantRepository;
import net.javaguides.springbootrestaurant.Service.RatingService;
import org.hibernate.event.internal.DefaultPersistOnFlushEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringbootRestaurantApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestaurantApplication.class, args);


//
	}

}
