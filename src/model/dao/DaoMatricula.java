package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Matricula;

@NamedQueries({
    @NamedQuery(name = "Matricula.findById", query = "SELECT m FROM Matricula m WHERE m.id_matricula = :id_matricula"),
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
})


public class DaoMatricula {

	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public DaoMatricula() {	
	}
	
	public boolean incluir(Matricula d) {
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

	public boolean alterar(Matricula d) {
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

	public boolean remover(Matricula d) {
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
	
	public Matricula consultarPorId(int id) {
		TypedQuery<Matricula> query = entityManager.createNamedQuery("Matricula.findById", Matricula.class);
		query.setParameter("id_matricula", id);
		List<Matricula> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
	public Matricula[] consultarTodos() {
		TypedQuery<Matricula> query = entityManager.createNamedQuery("Matricula.findAll", Matricula.class);
		List<Matricula> resultado = query.getResultList();
		Matricula[] retorno = new Matricula[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
	
}
