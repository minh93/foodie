package org.gr.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.gr.foodie.db.entity.AbstractTbl;
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
		if (q.getResultList() != null) {
			return q.getResultList();
		}
		em.getTransaction().commit();
		return new ArrayList<AbstractTbl>();
	}
	
}
