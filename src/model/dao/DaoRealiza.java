package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Realiza;


@NamedQueries({
    @NamedQuery(name = "Realiza.findById", query = "SELECT r FROM Realiza r WHERE r.id_realiza = :id_realiza"),
    @NamedQuery(name = "Realiza.findAll", query = "SELECT r FROM Realiza r")
})

public class DaoRealiza {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	
	public DaoRealiza() {	
	}
	
	public boolean incluir(Realiza d) {
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

	public boolean alterar(Realiza d) {
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

	public boolean remover(Realiza d) {
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
	
	
	public Realiza consultarPorId(int id) {
		TypedQuery<Realiza> query = entityManager.createNamedQuery("Realiza.findById", Realiza.class);
		query.setParameter("id_realiza", id);
		List<Realiza> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
	public Realiza[] consultarTodos() {
		TypedQuery<Realiza> query = entityManager.createNamedQuery("Realiza.findAll", Realiza.class);
		List<Realiza> resultado = query.getResultList();
		Realiza[] retorno = new Realiza[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
	
	

}
