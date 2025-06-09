package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Alocado;

@NamedQueries({
    @NamedQuery(name = "Alocado.findById", query = "SELECT a FROM Alocado a WHERE a.id_alocado = :id_alocado"),
    @NamedQuery(name = "Alocado.findAll", query = "SELECT a FROM Alocado a")
})

public class DaoAlocado {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	
	public DaoAlocado() {	
	}

	public boolean incluir(Alocado d) {
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

	public boolean alterar(Alocado d) {
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

	public boolean remover(Alocado d) {
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
	
	
	public Alocado consultarPorId(int id) {
		TypedQuery<Alocado> query = entityManager.createNamedQuery("Alocado.findById", Alocado.class);
		query.setParameter("id_alocado", id);
		List<Alocado> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
	public Alocado[] consultarTodos() {
		TypedQuery<Alocado> query = entityManager.createNamedQuery("Alocado.findAll", Alocado.class);
		List<Alocado> resultado = query.getResultList();
		Alocado[] retorno = new Alocado[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
	
	
}
