package org.gr.foodie.program.entity;

import java.util.ArrayList;

public class Eatery {
	private int flId;
	private int aId;
	private String name;
	private String location;
	private String description;
	private double price;
	private String thumbnail;
	
	public Eatery(){
		
	}
	
	public int getFlId() {
		return flId;
	}
	public void setFlId(int flId) {
		this.flId = flId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
