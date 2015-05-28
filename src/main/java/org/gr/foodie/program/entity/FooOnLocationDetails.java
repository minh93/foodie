package org.gr.foodie.program.entity;

public class FooOnLocationDetails extends FooOnLocation{

	private String foodName;
	private String description;
	private String thumbnail;
	private int createBy;
	
	
	public FooOnLocationDetails(){
		super();
	}
	
	public FooOnLocationDetails(int fol, int location_id, double price,
			String address) {
		super(fol, location_id, price, address);
		
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public int getCreateBy() {
		return createBy;
	}


	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}	
	
	
}
