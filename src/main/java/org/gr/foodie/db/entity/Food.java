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
@NamedQuery(name="Food.findAll", query="SELECT f FROM Food f")
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="f_id")
	private int fId;

	@Column(name="a_id")
	private int aId;

	@Column(name="ingredient")
	private String ingredient;

	@Column(name="ingredient")
	private String type;

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

	public String getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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