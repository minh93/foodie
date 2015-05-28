package org.gr.foodie.program.entity;

import java.util.ArrayList;
import java.util.List;

public class FoodDetails  extends AbstractObject{
	
	private ArrayList<FooOnLocation> fol;
	
	public FoodDetails(){
		super();
	}
	
	public FoodDetails(int aId, String name, String description,
			String type, ArrayList<String> images) {
		super(aId, description, description, type, images);
	}	
	
	public ArrayList<FooOnLocation> getFol() {
		return fol;
	}

	public void setFol(ArrayList<FooOnLocation> fol) {
		this.fol = fol;
	}	
}
