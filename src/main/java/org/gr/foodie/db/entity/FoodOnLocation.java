package org.gr.foodie.db.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the food_on_location database table.
 * 
 */
@Entity
@Table(name="food_on_location")
@NamedQueries({
	@NamedQuery(name="FoodOnLocation.findAll", query="SELECT f FROM FoodOnLocation f"),
	@NamedQuery(name="FoodOnLocation.findById", query="SELECT f FROM FoodOnLocation f WHERE f.flId = :id")
})
public class FoodOnLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="fl_id")
	private int flId;

	@Column(name="price")
	private double price;

	//bi-directional many-to-one association to Food
	@JsonIgnore
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
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
