package org.gr.foodie.program.entity;

import java.util.ArrayList;

public class LocationDetails extends AbstractObject{
	
	private ArrayList<FooOnLocationDetails> fol;
	private String address;
	private float longtitude;
	private float latitude;
	private String city;
	private String tel;
	private String thumbnail;
	private String opentime;
	private String closetime;
	
	public LocationDetails() {
		super();
	}
	
	public LocationDetails(int aId, String name, String description,
			String type, ArrayList<String> images, ArrayList<FooOnLocationDetails> fol,
			String address, float longtitude, float latitude, String city,
			String tel, String opentime, String closetime) {
		super(aId, description, description, type, images);
		this.fol = fol;
		this.address = address;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.city = city;
		this.tel = tel;
		this.opentime = opentime;
		this.closetime = closetime;
	}

	public ArrayList<FooOnLocationDetails> getFol() {
		return fol;
	}

	public void setFol(ArrayList<FooOnLocationDetails> arrayList) {
		this.fol = arrayList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}		
		
}
