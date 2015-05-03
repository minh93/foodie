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

	@Id
	@Column(name="i_id")
	private String iId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ia_id")
	private ImageAlbum imageAlbum;

	public String getiId() {
		return iId;
	}

	public void setiId(String iId) {
		this.iId = iId;
	}

	public ImageAlbum getImageAlbum() {
		return this.imageAlbum;
	}

	public void setImageAlbum(ImageAlbum imageAlbum) {
		this.imageAlbum = imageAlbum;
	}
}
