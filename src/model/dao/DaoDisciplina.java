package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Disciplina;

@NamedQueries({
    @NamedQuery(name = "Disciplina.findById", query = "SELECT d FROM Disciplina d WHERE d.id_disciplina = :id_disciplina"),
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
})
public class DaoDisciplina {

	private static EntityManager entityManager = CtrlPrograma.getEntityManager();

	
	public DaoDisciplina() {
	}
	
	public boolean incluir(Disciplina d) {
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

	public boolean alterar(Disciplina d) {
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

	public boolean remover(Disciplina d) {
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

	public Disciplina consultarPorId(int id) {
		TypedQuery<Disciplina> query = entityManager.createNamedQuery("Disciplina.findById", Disciplina.class);
		query.setParameter("id_disciplina", id);
		List<Disciplina> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public Disciplina[] consultarTodos() {
		TypedQuery<Disciplina> query = entityManager.createNamedQuery("Disciplina.findAll", Disciplina.class);
		List<Disciplina> resultado = query.getResultList();
		Disciplina[] retorno = new Disciplina[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}