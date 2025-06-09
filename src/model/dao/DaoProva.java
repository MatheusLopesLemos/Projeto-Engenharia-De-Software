package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Prova;

@NamedQueries({
    @NamedQuery(name = "Prova.findById", query = "SELECT p FROM Prova p WHERE p.id_prova = :id_prova"),
    @NamedQuery(name = "Prova.findAll", query = "SELECT p FROM Prova p")
})



public class DaoProva {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public DaoProva() {
	}
	
	public boolean incluir(Prova d) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(d);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean alterar(Prova d) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(d);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean remover(Prova d) {
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(d);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	
	public Prova consultarPorId(int id) {
		TypedQuery<Prova> query = entityManager.createNamedQuery("Prova.findById", Prova.class);
		query.setParameter("id_prova", id);
		List<Prova> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
	public Prova[] consultarTodos() {
		TypedQuery<Prova> query = entityManager.createNamedQuery("Prova.findAll", Prova.class);
		List<Prova> resultado = query.getResultList();
		Prova[] retorno = new Prova[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
	

}
