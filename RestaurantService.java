package main.java;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import main.java.restaurantNotFoundException;

public class RestaurantService{
	private static List<Restaurant> restaurants = new ArrayList<>();

	public Restaurant findRestaurantByName(String restaurantName) {
		for (Restaurant restaurant : restaurants) {
			System.out.println(Restaurant.displayDetails());
			if (restaurant.getName().equals(restaurantName))
			//if (restaurant.getName().equalsIgnoreCase(restaurantName))
			//	return restaurant;
				return Restaurant.displayDetails();
		}
		return null;
		
		
	}

	public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
		restaurants.add(newRestaurant);
		return newRestaurant;
	}

	public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
		Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
		
		if (null==restaurantToBeRemoved)
           throw new restaurantNotFoundException(restaurantName+" does not exists");
		
		restaurants.remove(restaurantToBeRemoved);
		return restaurantToBeRemoved;
		
		
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
}
