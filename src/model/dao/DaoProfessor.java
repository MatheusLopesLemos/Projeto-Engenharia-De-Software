package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import controller.CtrlPrograma;
import model.Professor;

@NamedQuery(name = "Professor.numContaCorrente", query = "SELECT c FROM Professor c WHERE c.numContaCorrente= :numero")
public class DaoProfessor {

	private static EntityManager entityManager = CtrlPrograma.getEntityManager();

	//
	// MÉTODOS
	//
	public DaoProfessor() {
	}

	/**
	 * Método para darmos "persistência" a um novo objeto Professor
	 * 
	 * @param p
	 * @return
	 */
	public boolean incluir(Professor a) {
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

	public boolean alterar(Professor a) {
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

	public boolean remover(Professor a) {
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

	public Professor consultarPorCpf(String cpf) {
		Query query = entityManager.createQuery("SELECT a FROM Professor a WHERE a.cpf = :cpf", Professor.class);
		query.setParameter("cpf", cpf);
		List<Professor> resultado = query.getResultList();
		if (resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public Professor[] consultarTodos() {
		Query query = entityManager.createNamedQuery("Professor.all");
		List<Professor> resultado = query.getResultList();
		Professor[] retorno = new Professor[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}