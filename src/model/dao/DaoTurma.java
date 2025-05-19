package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import controller.CtrlPrograma;
import model.Turma;

@NamedQuery(name = "Turma.numContaCorrente", query = "SELECT c FROM Turma c WHERE c.numContaCorrente= :numero")
public class DaoTurma {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	//
	// MÉTODOS
	//
	public DaoTurma() {
	}

	/**
	 * Método para darmos "persistência" a um novo objeto Turma
	 * 
	 * @param p
	 * @return
	 */
	public boolean incluir(Turma a) {		
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(a);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean alterar(Turma a) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(a);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean remover(Turma a) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(a);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public Turma consultarPorId(int i) {
		Query query = entityManager.createQuery("SELECT t FROM Turma t WHERE t.id_turma = :i", Turma.class);
		query.setParameter("id_turma", i);
		List<Turma> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public Turma[] consultarTodos() {
		Query query = entityManager.createNamedQuery("Turma.all");
		List<Turma> resultado  = query.getResultList();
		Turma[] retorno = new Turma[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}