package dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Message;
import jpautils.EntityManagerHelper;

public class MessageDAO implements MessageDAOI  {

	public boolean create(Message message) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		em.persist(message);
		//tx.commit();

		em.flush();
		return true;
		
	}

}
