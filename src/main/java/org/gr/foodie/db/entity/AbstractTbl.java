package org.gr.foodie.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the food database table.
 * 
 */
@Entity
@Table(name="abstract")
@NamedQueries({
	@NamedQuery(name="AbstractTbl.findAll", query="SELECT a FROM AbstractTbl a")	
})
@NamedNativeQuery(name="AbstractTbl.find", query="SELECT * FROM abstract WHERE CONTAINS(\"s_description\", ?)", resultClass=AbstractTbl.class)
public class AbstractTbl {
	@Id
	@Column(name="a_id")
	private int aId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;
	
	@Column(name="s_description")
	private String description;
	
	@Column(name="thumbnail")
	private String linkToThumbnail;
	
	@Column(name="create_by")
	private int userID;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLinkToThumbnail() {
		return linkToThumbnail;
	}

	public void setLinkToThumbnail(String linkToThumbnail) {
		this.linkToThumbnail = linkToThumbnail;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
}
