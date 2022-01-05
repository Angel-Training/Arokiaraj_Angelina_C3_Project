package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.Restaurant;
import main.java.Item;
import main.java.itemNotFoundException;
import org.junit.jupiter.api.Assertions.*;

public class RestaurantOrderTest {
	Restaurant restaurant;
	Item item;
    @BeforeEach 
    public void init() {
    	LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant =new Restaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }
    
    @Test
    public void adding_item_to_menu_should_increase_order_amount(){
    	int Total_Cost=null;
    	String new_item_name=null;
    	int new_item_price = null;
    	restaurant.addToMenu(new_item_name,new_item_price);
    	int New_Total_Cost=restaurant.UpdateOrder();
    	assertEquals(Total_Cost+new_item_price,New_Total_Cost);
    	
    }
    
    @Test
    public void removing_item_to_menu_should_decrease_order_amount(){
    	int Total_Cost=null;
    	String new_item_name=null;
    	int new_item_price = null;
    	restaurant.removeFromMenu(new_item_name,new_item_price);
    	int New_Total_Cost=restaurant.UpdateOrder();
    	assertEquals(Total_Cost+new_item_price,New_Total_Cost);
    	
    }
    
}
