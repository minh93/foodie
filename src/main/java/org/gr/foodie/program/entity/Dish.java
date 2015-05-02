package org.gr.foodie.program.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.gr.foodie.db.entity.Food;
import org.gr.foodie.db.entity.FoodOnLocation;
import org.gr.foodie.db.entity.Location;

public class Dish {
	private int id;
	private String name;
	private String description;
	private ArrayList<String> images;
	private ArrayList<Restaurant> Restaurant;
	private double avgPrice;
	
	public Dish(int id, String name, String description, ArrayList<String> images,
			ArrayList<Restaurant> Restaurant) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.images = images;
		this.Restaurant = Restaurant;
	}
	
	public Dish(Food f, List<Location> ls, List<String> imgs){
		this.id = f.getFId();
		this.name = f.getName();
		this.description = f.getDescription();
		this.images = new ArrayList<String>(imgs);
		this.Restaurant = new ArrayList<Restaurant>();	
		
		//Caculate for avg price
		double price = 0;
		int temp = 0;
		for (FoodOnLocation item : f.getFoodOnLocations()) {
			temp++;
			price += Double.parseDouble(item.getPrice());
		}
		this.avgPrice = price/temp;
		
		for (Location item : ls) {
			this.Restaurant.add(new Restaurant(item.getLId(), 
					item.getName(), 
					0, 
					0, 
					f.getDescription(), 
					new ArrayList<String>(), 
					new ArrayList<Dish>()));
			//TODO: Location data, image list
		}
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public Dish() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public ArrayList<Restaurant> getRestaurant() {
		return Restaurant;
	}

	public void setRestaurant(ArrayList<Restaurant> Restaurant) {
		this.Restaurant = Restaurant;
	}
	
	
}
