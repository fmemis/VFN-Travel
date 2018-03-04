package dao;

import javax.persistence.EntityManager;

import jpautils.EntityManagerHelper;
import model.SearchHistory;


public class SearchHistoryDAO implements SearchHistoryDAOI {
	
	public boolean create(SearchHistory search) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		em.persist(search);
		

		em.flush();
		return true;
	}

}
