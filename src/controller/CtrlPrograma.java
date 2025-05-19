package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CtrlPrograma extends CtrlAbstrato {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_prjPOO");
	private static EntityManager        entityManager = entityManagerFactory.createEntityManager();
	
	public static EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return CtrlPrograma.entityManager;
	}

	public CtrlPrograma() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void finalizar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getBemTangivel() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
