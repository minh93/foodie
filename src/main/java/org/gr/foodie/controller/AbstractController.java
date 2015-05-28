package org.gr.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.gr.foodie.db.entity.AbstractTbl;
import org.gr.foodie.program.entity.FoodDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbstractController {

	@RequestMapping("/search/query")
	public List<AbstractTbl> getFoodById(
			@RequestParam(value = "q", defaultValue = "0") String query) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Query q = em.createNamedQuery("AbstractTbl.find", AbstractTbl.class);

		q.setParameter(1, query);
		try {			
			List<AbstractTbl> result = q.getResultList();
			return result;
		}catch(Exception e){
			
		}
		em.getTransaction().commit();
		return new ArrayList<AbstractTbl>();
	}

	// Get populated entry (sample 20 entry)
	@RequestMapping("/populated")
	public List<AbstractTbl> getPopulatedFood(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "num", defaultValue = "20") int num) {

		List<AbstractTbl> result = new ArrayList<AbstractTbl>();

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		Query q = em.createNamedQuery("AbstractTbl.findAll", AbstractTbl.class);
		//Sample
		try {			
			List<AbstractTbl> list = q.getResultList();
			int counter = 0;
			for (AbstractTbl abstractTbl : list) {
				result.add(abstractTbl);
				counter += 1;
				if(counter >19)
					break;
			}		
		}catch(Exception e){
			
		}
		em.getTransaction().commit();
		
		return result;
	}

}
