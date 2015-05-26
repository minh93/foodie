package org.gr.foodie.db.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the image database table.
 * 
 */
@Entity
@Table(name="image")
@NamedQueries({
	@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i"),	
})
public class Image implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="path")
	private String path;
	
	@Id
	@Column(name="id")
	private int id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ia_id")
	private ImageAlbum imageAlbum;

	public String getPath() {
		return path;
	}

	public void setPath(String iId) {
		this.path = iId;
	}

	public ImageAlbum getImageAlbum() {
		return this.imageAlbum;
	}

	public void setImageAlbum(ImageAlbum imageAlbum) {
		this.imageAlbum = imageAlbum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
