package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import jpautils.EntityManagerHelper;
import model.Listing;
import model.Review;

public class ReviewDAO implements ReviewDAOI {
	private static final int maxReviews = 3;
	
	public boolean create(Review review) {
			
			EntityManager em = EntityManagerHelper.getEntityManager();
			em.persist(review);
	
			em.flush();
			return true;
			
		}
	
	public List<Review> getReviews(int listingid) {
		
		String squery = "SELECT r FROM Review r WHERE r.listing.id.idlisting = :listing";
	    
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Review> searchQuery = em.createQuery(squery, Review.class);
		
		searchQuery.setParameter("listing", listingid);
		
		searchQuery.setMaxResults(maxReviews);
		return searchQuery.getResultList();
	}
}
