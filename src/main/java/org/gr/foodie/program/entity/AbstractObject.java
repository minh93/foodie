package org.gr.foodie.program.entity;

import java.util.ArrayList;
import java.util.List;

public class AbstractObject {
	private int aId;
	private String name;
	private String description;
	private String type;
	private ArrayList<String> images;
	
	public AbstractObject(){
		
	} 
	
	public AbstractObject(int aId, String name, String description,
			String type, ArrayList<String> images) {
		this.aId = aId;
		this.name = name;
		this.description = description;
		this.type = type;
		this.images = images;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}	
}
