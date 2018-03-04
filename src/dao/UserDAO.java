package dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Listing;
import model.User;
import jpautils.EntityManagerHelper;

public class UserDAO implements UserDAOI  {

	public boolean create(User user) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		em.persist(user);
		//tx.commit();

		em.flush();
		return true;
		
	}
	
	@Override
	public User findByUsername(String username){
		EntityManager em = EntityManagerHelper.getEntityManager();
		User user = em.find(User.class, username); 
        return user;
	}
	
	public List<User> getUsers() {
		String squery = "SELECT u from User u";
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<User> searchQuery = em.createQuery(squery, User.class);
		List<User> userlist = searchQuery.getResultList();
		return userlist;
	}
}