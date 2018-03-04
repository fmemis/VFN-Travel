package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Listing;
import model.Reservation;
import model.Review;
import jpautils.EntityManagerHelper;

public class ReservationDAO implements ReservationDAOI {
	public boolean create(Reservation reservation) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		em.persist(reservation);
		//tx.commit();

		em.flush();
		return true;
		
	}
	public boolean petsAllowed(int listingid) {
		String squery = "SELECT l FROM Listing l WHERE l.id.idlisting = :idlisting AND l.dogs = 1";
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Listing> searchQuery = em.createQuery(squery, Listing.class);
		searchQuery.setParameter("idlisting", listingid);
		
	    return searchQuery.getResultList().size() == 1;
	}
	public boolean listingAvailable(Date start, Date end, int listingid) {
		String squery = "SELECT l FROM Listing l WHERE l.id.idlisting = :idlisting AND l.id.idlisting not in "
				+ "(SELECT re.listing.id.idlisting from Reservation re where  (re.startDate >= :start and re.startDate < :end)"
				+ " or (re.endDate >= :start and re.endDate < :end))";
		
		
	    
		//String squery = "SELECT l from Listing l where l.city LIKE :location AND  l.id.idlisting not in (SELECT re.listing.id.idlisting from Reservation re where  (re.startDate >= :start and re.startDate < :end) or (re.endDate >= :start and re.endDate < :end))";
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Listing> searchQuery = em.createQuery(squery, Listing.class);
		
		searchQuery.setParameter("start", start);
		searchQuery.setParameter("end", end);
		searchQuery.setParameter("idlisting", listingid);
		
	    return searchQuery.getResultList().size() == 1;
	}
	
public List<Reservation> getResarvations(int listingid) {
		
		String squery = "SELECT r FROM Reservation r WHERE r.listing.id.idlisting = :listing";
	    
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Reservation> searchQuery = em.createQuery(squery, Reservation.class);
		
		searchQuery.setParameter("listing", listingid);
		
		return searchQuery.getResultList();
	}

}
