package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import controller.CtrlPrograma;
import model.Aluno;

@NamedQuery(name = "Aluno.numContaCorrente", query = "SELECT c FROM Aluno c WHERE c.numContaCorrente= :numero")
public class DaoAluno {

	private static EntityManager entityManager = CtrlPrograma.getEntityManager();

	//
	// MÉTODOS
	//
	public DaoAluno() {
	}

	/**
	 * Método para darmos "persistência" a um novo objeto Aluno
	 * 
	 * @param p
	 * @return
	 */
	public boolean incluir(Aluno a) {
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

	public boolean alterar(Aluno a) {
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

	public boolean remover(Aluno a) {
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

	public Aluno consultarPorCpf(String cpf) {
		Query query = entityManager.createQuery("SELECT a FROM Aluno a WHERE a.cpf = :cpf", Aluno.class);
		query.setParameter("cpf", cpf);
		List<Aluno> resultado = query.getResultList();
		if (resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public Aluno[] consultarTodos() {
		Query query = entityManager.createNamedQuery("Aluno.all");
		List<Aluno> resultado = query.getResultList();
		Aluno[] retorno = new Aluno[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}