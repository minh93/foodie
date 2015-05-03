package org.gr.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.gr.foodie.db.entity.Image;
import org.gr.foodie.db.entity.ImageAlbum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

	@RequestMapping("/image/id")
	public List<Image> getFoodById(
			@RequestParam(value = "id", defaultValue = "0") int id,
			@RequestParam(value = "type", defaultValue = "tearser") String type) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Query q = em.createNamedQuery("ImageAlbum.findById", ImageAlbum.class);
		q.setParameter("id", id);
		
		if(q.getSingleResult() != null){
			ImageAlbum album = (ImageAlbum) q.getSingleResult();	
			return album.getImages();
		}
		
		return new ArrayList<Image>();
	}
		
}
