package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Departamento;

@NamedQueries({
    @NamedQuery(name = "Departamento.findById", query = "SELECT d FROM Departamento d WHERE d.id_departamento = :id_departamento"),
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
})
public class DaoDepartamento {

	private static EntityManager entityManager = CtrlPrograma.getEntityManager();

	
	public DaoDepartamento() {
	}
	
	public boolean incluir(Departamento d) {
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

	public boolean alterar(Departamento d) {
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

	public boolean remover(Departamento d) {
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

	public Departamento consultarPorId(int id) {
		TypedQuery<Departamento> query = entityManager.createNamedQuery("Departamento.findById", Departamento.class);
		query.setParameter("id_departamento", id);
		List<Departamento> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public Departamento[] consultarTodos() {
		TypedQuery<Departamento> query = entityManager.createNamedQuery("Departamento.findAll", Departamento.class);
		List<Departamento> resultado = query.getResultList();
		Departamento[] retorno = new Departamento[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}