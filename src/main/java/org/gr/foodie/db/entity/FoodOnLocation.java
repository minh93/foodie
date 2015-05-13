package org.gr.foodie.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the food_on_location database table.
 * 
 */
@Entity
@Table(name="food_on_location")
@NamedQuery(name="FoodOnLocation.findAll", query="SELECT f FROM FoodOnLocation f")
public class FoodOnLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fl_id")
	private int flId;

	@Lob
	private String price;

	//bi-directional many-to-one association to Food
	@ManyToOne
	@JoinColumn(name="f_id")
	private Food food;

	//bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="l_id")
	private Location location;

	public FoodOnLocation() {
	}

	public int getFlId() {
		return this.flId;
	}

	public void setFlId(int flId) {
		this.flId = flId;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
