package main.java;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	
	private static String name;
	private static String location;
	public static LocalTime openingTime;
	public static LocalTime closingTime;
	public static int total_amt;
	private static List<Item> menu = new ArrayList<Item>();

	public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		this.name = name;
		this.location = location;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public boolean isRestaurantOpen() {
		LocalTime now= LocalTime.now();
		
		int open_hour=Integer.parseInt(openingTime.truncatedTo(ChronoUnit.HOURS).toString().substring(0,2));
    	int close_hour=Integer.parseInt(closingTime.truncatedTo(ChronoUnit.HOURS).toString().substring(0,2));
    	int curr_hr=Integer.parseInt(now.truncatedTo(ChronoUnit.HOURS).toString().substring(0,2));
    	if(curr_hr>=open_hour&&curr_hr<=close_hour) {
			return true;
			
		}else 
			return false;
		
	}

	public LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	public static List<Item> getMenu() {
		return menu;
		
	}

	private Item findItemByName(String itemName) {
		for (Item item : menu) {
			if (item.getName().equals(itemName))
				return item;
		}
		return null;
	}

	public void addToMenu(String name, int price) {
		Item newItem = new Item(name, price);
		menu.add(newItem);
	}

	public void removeFromMenu(String itemName) throws itemNotFoundException {

		Item itemToBeRemoved = findItemByName(itemName);
		if (itemToBeRemoved == null)
			throw new itemNotFoundException(itemName);

		menu.remove(itemToBeRemoved);
	}
	
	public int UpdateOrder() {
		total_amt=0;
		for (Item item : menu) {
			total_amt=total_amt+item.getprice();
		}
		
		return total_amt;
		
	}
	
     public static Restaurant displayDetails() {
		System.out.println("Restaurant:" + name + "\n" + "Location:" + location + "\n" + "Opening time:" + openingTime
				+ "\n" + "Closing time:" + closingTime + "\n" + "Menu:" + "\n" + getMenu());
		return null;
		
	}

	public static String getName() {
		return name;
	}
    public String getLocation() {
        return location;
    }
    public LocalTime getopeningTime() {
        return openingTime;
    }
    public LocalTime getclosingTime() {
        return closingTime;
    }
}
