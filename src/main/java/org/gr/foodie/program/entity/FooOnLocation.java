package org.gr.foodie.program.entity;

public class FooOnLocation {
	private int fl_id;
	private int location_id;
	private double price;	
	private String address;
	
	public FooOnLocation(){
		
	}
	
	public FooOnLocation(int fol, int location_id, double price, String address) {		
		this.fl_id = fol;
		this.location_id = location_id;
		this.price = price;
		this.address = address;
	}
		
	
	public int getFl_id() {
		return fl_id;
	}

	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}

	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	
}
