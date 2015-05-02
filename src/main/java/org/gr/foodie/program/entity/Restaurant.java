package org.gr.foodie.program.entity;

import java.util.ArrayList;

public class Restaurant {
	private int id;
	private String name;
	private double latitude;
	private double longitude;
	private String description;
	private ArrayList<String> images;
	private ArrayList<Dish> Dish;
	
	public Restaurant(int id, String name, double latitude, double longtitude, String description,
			ArrayList<String> images,
			ArrayList<Dish> Dish){
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude =longtitude;
		this.description = description;
		this.images = images;
		this.Dish = Dish;
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
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
	public ArrayList<Dish> getDish() {
		return Dish;
	}
	public void setDish(ArrayList<Dish> Dish) {
		this.Dish = Dish;
	}
	
	
}
