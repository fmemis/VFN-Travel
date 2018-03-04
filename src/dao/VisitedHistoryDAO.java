package dao;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.VisitedHistory;

public class VisitedHistoryDAO implements VisitedHistoryDAOI {
	
	public boolean create(VisitedHistory visit) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		em.persist(visit);
		

		em.flush();
		return true;
	}

}
