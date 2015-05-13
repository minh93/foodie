package org.gr.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.gr.foodie.db.entity.Food;
import org.gr.foodie.db.entity.FoodOnLocation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

//	@RequestMapping("/food/id")
//	public Dish getFoodById(
//			@RequestParam(value = "id", defaultValue = "0") int id) {
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("demojpa");
//
//		EntityManager em = factory.createEntityManager();
//
//		em.getTransaction().begin();
//
//		Query q = em.createNamedQuery("Food.findById", Food.class);
//		q.setParameter("fId", id);
//		if (q.getSingleResult() != null) {
//			Food dbFood = (Food) q.getSingleResult();
//			List<FoodOnLocation> dbFoodOnLocations = dbFood
//					.getFoodOnLocations();
//			List<Location> dbLocations = new ArrayList<Location>();
//			for (FoodOnLocation item : dbFoodOnLocations) {
//				dbLocations.add(item.getLocation());
//			}
//			
//			Dish d = new Dish(dbFood, dbLocations, new ArrayList<String>());
//			return d;
//		}
//		em.getTransaction().commit();
//		return new Dish();
//	}
//	
//	@RequestMapping("/food/name")
//	public List<Dish> getFoodByName(
//			@RequestParam(value = "name", defaultValue = "null") String name){
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("demojpa");
//
//		EntityManager em = factory.createEntityManager();
//
//		List<Dish> result = new ArrayList<Dish>();
//		
//		em.getTransaction().begin();
//		Query q = em.createNamedQuery("Food.findByName", Food.class);
//		q.setParameter("name", "%" + name + "%");
//		if(q.getResultList()!=null){
//			for (Food f : new ArrayList<Food>(q.getResultList())) {
//				List<FoodOnLocation> dbFoodOnLocations = f.getFoodOnLocations();
//				List<Location> dbLocations = new ArrayList<Location>();
//				for (FoodOnLocation subItem : dbFoodOnLocations) {
//					dbLocations.add(subItem.getLocation());
//				}
//				Dish d = new Dish(f, dbLocations, new ArrayList<String>());
//				result.add(d);
//			}
//		}
//		
//		em.getTransaction().commit();
//		return result;
//	}
}
