package org.gr.foodie.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.gr.foodie.db.entity.AbstractTbl;
import org.gr.foodie.db.entity.Food;
import org.gr.foodie.db.entity.FoodOnLocation;
import org.gr.foodie.db.entity.Image;
import org.gr.foodie.db.entity.ImageAlbum;
import org.gr.foodie.program.entity.Eatery;
import org.gr.foodie.program.entity.FooOnLocation;
import org.gr.foodie.program.entity.FoodDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

	@RequestMapping("/food/id")
	public ArrayList<Eatery> getFoodOnLocation(
			@RequestParam(value = "id", defaultValue = "0") int id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		// TODO
		// Get food by aId
		ArrayList<Eatery> results = new ArrayList<Eatery>();
		// Find food by aId
		Query q = em.createNamedQuery("Food.findByaId", Food.class);
		q.setParameter("aId", id);
		// Find abstractTbl entry to provide name, description
		Query q2 = em.createNamedQuery("AbstractTbl.findById",
				AbstractTbl.class);
		q2.setParameter("aId", id);

		AbstractTbl abTbl = (AbstractTbl) q2.getSingleResult();

		// If return object
		if (q.getSingleResult() != null) {
			Food food = (Food) q.getSingleResult();
			List<FoodOnLocation> fols = food.getFoodOnLocations();
			for (FoodOnLocation item : fols) {
				Eatery e = new Eatery();
				e.setaId(id);
				e.setFlId(item.getFlId());
				e.setName(abTbl.getName());
				e.setDescription(abTbl.getDescription());
				e.setPrice(item.getPrice());
				e.setThumbnail(abTbl.getLinkToThumbnail());
				e.setLocation(item.getLocation().getAddress());
				results.add(e);
			}
			return results;
		}
		em.getTransaction().commit();

		return new ArrayList<Eatery>();
	}

	// Lay a_id tra ve thong tin chi tiet entry trong food va abstract
	@RequestMapping("/food/details/id")
	public FoodDetails getFood(
			@RequestParam(value = "id", defaultValue = "0") int id) {
		
		FoodDetails fdl = new FoodDetails();
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		// Get food by aId
		ArrayList<Eatery> results = new ArrayList<Eatery>();
		// Find food by aId
		Query q = em.createNamedQuery("Food.findByaId", Food.class);
		q.setParameter("aId", id);
		// Find abstractTbl entry to provide name, description
		Query q2 = em.createNamedQuery("AbstractTbl.findById",
				AbstractTbl.class);
		q2.setParameter("aId", id);
		// Find list image for food by abstract id
		Query q3 = em.createNamedQuery("ImageAlbum.findByAId", ImageAlbum.class);
		q3.setParameter("aId", id);
		
		AbstractTbl abTbl = (AbstractTbl) q2.getSingleResult();

		if(abTbl != null){			
			Food f = (Food) q.getSingleResult();			
			fdl.setaId(abTbl.getaId());
			fdl.setName(abTbl.getName());
			fdl.setDescription(abTbl.getDescription());
			fdl.setFol(new ArrayList<FooOnLocation>());;
			for (FoodOnLocation item : f.getFoodOnLocations()) {
				fdl.getFol().add(new FooOnLocation(item.getFlId(), 
						item.getLocation().getLId(), 
						item.getPrice()));
			}
			
			if(q3.getSingleResult() != null){
				//Set images for food detail
				ImageAlbum imgs = (ImageAlbum) q3.getSingleResult();
				fdl.setImages(new ArrayList<String>());
				for (Image i : imgs.getImages()) {
					fdl.getImages().add(i.getPath());					
				}
			}			
		}		
		return fdl;
	}
}
