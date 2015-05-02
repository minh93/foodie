package org.gr.foodie.db.entity;

import java.io.Serializable;

import javax.persistence.*;

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
	private int iId;
	
	@Column(name="ia_id")
	private int iaId;
	
	@ManyToOne
	@JoinColumn(name="ia_id")
	private ImageAlbum imageAlbum;

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public int getIaId() {
		return iaId;
	}

	public void setIaId(int iaId) {
		this.iaId = iaId;
	}

	public ImageAlbum getImageAlbum() {
		return this.imageAlbum;
	}

	public void setImageAlbum(ImageAlbum imageAlbum) {
		this.imageAlbum = imageAlbum;
	}
}
