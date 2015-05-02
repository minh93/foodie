package org.gr.foodie.db.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the food database table.
 * 
 */
@Entity
@Table(name="food")
@NamedQueries({
	@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f"),
	@NamedQuery(name="Food.findById", query="SELECT f FROM Food f WHERE f.fId = :fId"),
	@NamedQuery(name="Food.findByName", query="SELECT f FROM Food f WHERE trim(f.name) like :name")
})
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="f_id")
	private int fId;

	@Column(name="a_id")
	private int aId;

	@Column(name="description")
	private String description;

	@Column(name="ia_id")
	private int iaId;

	@Column(name="name")
	private String name;
	

	//bi-directional many-to-one association to FoodOnLocation
	@OneToMany(mappedBy="food")
	private List<FoodOnLocation> foodOnLocations;

	public Food() {
	}

	public int getFId() {
		return this.fId;
	}

	public void setFId(int fId) {
		this.fId = fId;
	}

	public int getAId() {
		return this.aId;
	}

	public void setAId(int aId) {
		this.aId = aId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIaId() {
		return this.iaId;
	}

	public void setIaId(int iaId) {
		this.iaId = iaId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FoodOnLocation> getFoodOnLocations() {
		return this.foodOnLocations;
	}

	public void setFoodOnLocations(List<FoodOnLocation> foodOnLocations) {
		this.foodOnLocations = foodOnLocations;
	}

	public FoodOnLocation addFoodOnLocation(FoodOnLocation foodOnLocation) {
		getFoodOnLocations().add(foodOnLocation);
		foodOnLocation.setFood(this);

		return foodOnLocation;
	}

	public FoodOnLocation removeFoodOnLocation(FoodOnLocation foodOnLocation) {
		getFoodOnLocations().remove(foodOnLocation);
		foodOnLocation.setFood(null);

		return foodOnLocation;
	}	

}