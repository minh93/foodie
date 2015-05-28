package org.gr.foodie.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.gr.foodie.db.entity.AbstractTbl;
import org.gr.foodie.db.entity.Food;
import org.gr.foodie.db.entity.FoodOnLocation;
import org.gr.foodie.db.entity.Image;
import org.gr.foodie.db.entity.ImageAlbum;
import org.gr.foodie.db.entity.Location;
import org.gr.foodie.program.entity.Eatery;
import org.gr.foodie.program.entity.FooOnLocation;
import org.gr.foodie.program.entity.FooOnLocationDetails;
import org.gr.foodie.program.entity.FoodDetails;
import org.gr.foodie.program.entity.LocationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	// Lay a_id tra ve thong tin chi tiet entry trong location va abstract
	@RequestMapping("/location/details/id")
	public LocationDetails getLocation(
			@RequestParam(value = "id", defaultValue = "0") int id) {

		LocationDetails lod = new LocationDetails();

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		// Find food by aId
		Query q = em.createNamedQuery("Location.findByaId", Location.class);
		q.setParameter("aId", id);
		// Find abstractTbl entry to provide name, description
		Query q2 = em.createNamedQuery("AbstractTbl.findById",
				AbstractTbl.class);
		q2.setParameter("aId", id);
		// Find list image for food by abstract id
		Query q3 = em
				.createNamedQuery("ImageAlbum.findByAId", ImageAlbum.class);
		q3.setParameter("aId", id);

		try {
			AbstractTbl abTbl = (AbstractTbl) q2.getSingleResult();
			Location l = (Location) q.getSingleResult();
			lod.setaId(abTbl.getaId());
			lod.setName(abTbl.getName());
			lod.setDescription(abTbl.getDescription());
			lod.setFol(new ArrayList<FooOnLocationDetails>());			
			for (FoodOnLocation item : l.getFoodOnLocations()) {
				FooOnLocationDetails fod = new FooOnLocationDetails();
				fod.setFl_id(item.getFlId());
				fod.setAddress(l.getAddress());								
				fod.setLocation_id(l.getAId());
				fod.setPrice(item.getPrice());
				// Find food name in location
				int fAId = item.getFood().getAId();
				q2.setParameter("aId", fAId);
				try {
					abTbl = (AbstractTbl) q2.getSingleResult();
					fod.setFoodName(abTbl.getName());
					fod.setDescription(abTbl.getDescription());
					fod.setCreateBy(abTbl.getUserID());
					fod.setThumbnail(abTbl.getLinkToThumbnail());
				} catch (Exception e) {

				}
				lod.getFol().add(fod);
			}

			try {
				// Set images for food detail
				ImageAlbum imgs = (ImageAlbum) q3.getSingleResult();
				lod.setImages(new ArrayList<String>());
				for (Image i : imgs.getImages()) {
					lod.getImages().add(i.getPath());
				}
			} catch (Exception e) {

			}

			lod.setAddress(l.getAddress());
			lod.setCity(l.getCity());
			lod.setThumbnail(abTbl.getLinkToThumbnail());
		} catch (Exception e) {

		}
		return lod;
	}
}
