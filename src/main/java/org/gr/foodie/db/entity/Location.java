package org.gr.foodie.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="l_id")
	private int lId;

	@Column(name="a_id")
	private int aId;

	private Object address;

	private Object city;

	@Column(name="close_time")
	private Timestamp closeTime;

	private byte[] loc;

	@Column(name="open_time")
	private Timestamp openTime;

	private String tel;

	//bi-directional many-to-one association to FoodOnLocation
	@OneToMany(mappedBy="location")
	private List<FoodOnLocation> foodOnLocations;

	public Location() {
	}

	public int getLId() {
		return this.lId;
	}

	public void setLId(int lId) {
		this.lId = lId;
	}

	public int getAId() {
		return this.aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public Object getAddress() {
		return this.address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}

	public Object getCity() {
		return this.city;
	}

	public void setCity(Object city) {
		this.city = city;
	}

	public Timestamp getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Timestamp closeTime) {
		this.closeTime = closeTime;
	}

	public byte[] getLoc() {
		return this.loc;
	}

	public void setLoc(byte[] loc) {
		this.loc = loc;
	}

	public Timestamp getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Timestamp openTime) {
		this.openTime = openTime;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<FoodOnLocation> getFoodOnLocations() {
		return this.foodOnLocations;
	}

	public void setFoodOnLocations(List<FoodOnLocation> foodOnLocations) {
		this.foodOnLocations = foodOnLocations;
	}

	public FoodOnLocation addFoodOnLocation(FoodOnLocation foodOnLocation) {
		getFoodOnLocations().add(foodOnLocation);
		foodOnLocation.setLocation(this);

		return foodOnLocation;
	}

	public FoodOnLocation removeFoodOnLocation(FoodOnLocation foodOnLocation) {
		getFoodOnLocations().remove(foodOnLocation);
		foodOnLocation.setLocation(null);

		return foodOnLocation;
	}

}