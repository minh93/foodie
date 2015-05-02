package org.gr.foodie.db.entity;

import java.io.Serializable;
import javax.persistence.*;
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

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="ia_id")
	private int iaId;

	@Column(name="loc")
	private byte[] loc;

	@Column(name="name")
	private String name;

	@Column(name="tel")
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getIaId() {
		return this.iaId;
	}

	public void setIaId(int iaId) {
		this.iaId = iaId;
	}

	public byte[] getLoc() {
		return this.loc;
	}

	public void setLoc(byte[] loc) {
		this.loc = loc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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