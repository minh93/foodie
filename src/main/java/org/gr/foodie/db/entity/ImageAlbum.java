package org.gr.foodie.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image_album database table.
 * 
 */
@Entity
@Table(name="image_album")
@NamedQuery(name="ImageAlbum.findAll", query="SELECT i FROM ImageAlbum i")
public class ImageAlbum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ia_id")
	private int iaId;

	private String name;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="imageAlbum")
	private List<Image> images;

	public ImageAlbum() {
	}

	public int getIaId() {
		return this.iaId;
	}

	public void setIaId(int iaId) {
		this.iaId = iaId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setImageAlbum(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setImageAlbum(null);

		return image;
	}

}