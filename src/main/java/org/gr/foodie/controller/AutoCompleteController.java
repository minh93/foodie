package org.gr.foodie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoCompleteController {

	@RequestMapping("/autocomplete/q")
	public List<String> getFoodById(
			@RequestParam(value = "id", defaultValue = "0") int id) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("demojpa");

		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();

		return new ArrayList<String>();
	}
}
