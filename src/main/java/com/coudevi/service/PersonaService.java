package com.coudevi.service;

import java.util.List;

import com.coudevi.model.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaService {
	private final EntityManagerFactory factory;

	public PersonaService() {
		this.factory = Persistence.createEntityManagerFactory("oneToOnePU");
	}

	public void crearPersona(Persona persona) {
		EntityManager manager = factory.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(persona);
			manager.getTransaction().commit();
		} catch (Exception e) {
			if (manager.getTransaction().isActive()) {
				manager.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			manager.close();
		}
	}

	public List<Persona> obtenerPersonas() {
		EntityManager manager = factory.createEntityManager();
		try {
			return manager.createQuery("SELECT p FROM Persona p LEFT JOIN FETCH p.documento", Persona.class)
					.getResultList();
		} finally {
			manager.close();
		}
	}

	public void cerrar() {
		factory.close();
	}
}
