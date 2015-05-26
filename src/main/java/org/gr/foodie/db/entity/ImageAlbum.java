package org.gr.foodie.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the image_album database table.
 * 
 */
@Entity
@Table(name = "image_album")
@NamedQueries({ 
	@NamedQuery(name = "ImageAlbum.findAll", query = "SELECT i FROM ImageAlbum i"),
	@NamedQuery(name = "ImageAlbum.findByAId", query = "SELECT i FROM ImageAlbum i WHERE i.aId = :aId")
})
public class ImageAlbum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "a_id")
	private int aId;

	// bi-directional many-to-one association to Image
	@OneToMany(mappedBy = "imageAlbum")
	private List<Image> images;

	public ImageAlbum() {
	}

	public int getIaId() {
		return this.aId;
	}

	public void setIaId(int iaId) {
		this.aId = iaId;
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