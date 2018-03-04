package dao;


import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Listing;
import model.ListingPK;
import model.Reservation;
import model.Review;
import model.User;
import jpautils.EntityManagerHelper;

public class ListingDAO implements ListingDAOI  {

	public boolean create(Listing listing) {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		//EntityTransaction tx = em.getTransaction();
		//tx.begin();
		em.persist(listing);
		//tx.commit();

		em.flush();
		return true;
		
	}
	
	public Listing findById(int id,String username) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		ListingPK listingpk = new ListingPK();
		listingpk.setIdlisting(id);
		listingpk.setUserUsername(username);
		Listing listing = em.find(Listing.class, listingpk); 
        return listing;
	}
	
	public List<Listing> getListings() {
		String squery = "SELECT l from Listing l";
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Listing> searchQuery = em.createQuery(squery, Listing.class);
		List<Listing> listinglist = searchQuery.getResultList();
		return listinglist;
	}
	
	
	//create the sql query according to the search parameters received from the user(homepage)
	public List<Listing> search(SearchParams params, int page, int entries_per_page) {
		
		String squery = "SELECT l FROM Listing l ";
		boolean check = false;
		if(params.hasLocation()){
			squery += " WHERE";
			squery += " l.city LIKE :location";
			check = true;
		}
		
		if(params.hasDates()){
			if(check) {
				squery += " AND";
			}
			else {
				squery += " WHERE";
			}
			squery += " l.id.idlisting not in (SELECT re.listing.id.idlisting from Reservation re where  (re.startDate >= :start and re.startDate < :end) or (re.endDate >= :start and re.endDate < :end))";
		}
		if(params.hasGuests()){
			if(check) {
				squery += " AND";
			}
			else {
				squery += " WHERE";
				check = true;
			}
			squery += " l.maxPeople >= :guests";
		}
		
		squery += " ORDER BY l.dailyPrice";
	    
		//String squery = "SELECT l from Listing l where l.city LIKE :location AND  l.id.idlisting not in (SELECT re.listing.id.idlisting from Reservation re where  (re.startDate >= :start and re.startDate < :end) or (re.endDate >= :start and re.endDate < :end))";
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Listing> searchQuery = em.createQuery(squery, Listing.class);
		
		if(params.hasLocation()){
			searchQuery.setParameter("location", params.getLocation());
		}
		if(params.hasDates()){
			searchQuery.setParameter("start", params.getArrDate());
			searchQuery.setParameter("end", params.getDepDate());
		}
		if(params.hasGuests()){
			searchQuery.setParameter("guests", params.getGuests());
		}

		searchQuery.setFirstResult(page * entries_per_page); //begin from the appropriate result according to the page you are in
		searchQuery.setMaxResults(entries_per_page); //results are for this particular page.Not all of them
		return searchQuery.getResultList();
	}
	
	//create the sql query according to the search parameters received from the user(search results page - filters)
	public List<Listing> search(SearchParams params,SearchOptions options,int page,int entries_per_page) {
		String squery = "SELECT l FROM Listing l ";
		boolean check = false;
		if(params.hasLocation()){
			squery += " WHERE";
			squery += " l.city LIKE :location";
			check = true;
		}
		
		if(params.hasDates()){
			if(check) {
				squery += " AND";
			}
			else {
				squery += " WHERE";
				check = true;
			}
			squery += " l.id.idlisting not in (SELECT re.listing.id.idlisting from Reservation re where  (re.startDate >= :start and re.startDate < :end) or (re.endDate >= :start and re.endDate < :end))";
		}
		if(params.hasGuests()){
			if(check) {
				squery += " AND";
			}
			else {
				squery += " WHERE";
				check = true;
			}
			squery += " l.maxPeople >= :guests";
		}
		
		
		
		if (options.getAircondition() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.aircondition = 1";
			}
			else {
				squery += " WHERE l.aircondition = 1";
			}
				
		}
		
		if (options.getApartment() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.type = 1";
			}
			else {
				squery += " WHERE l.type = 1";
			}
				
		}
		
		if (options.getBungalow() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.type = 2";
			}
			else {
				squery += " WHERE l.type = 2";
			}
				
		}
		
		if (options.getHotel() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.type = 3";
			}
			else {
				squery += " WHERE l.type = 3";
			}
				
		}
		
		if (options.getStudio() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.type = 4";
			}
			else {
				squery += " WHERE l.type = 4";
			}
				
		}
		
		if (options.getVilla() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.type = 5";
			}
			else {
				squery += " WHERE l.type = 5";
			}
				
		}
		
		if (options.getHeating() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.heating = 1";
			}
			else {
				squery += " WHERE l.heating = 1";
			}
				
		}
		
		if (options.getWifi() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.wifi = 1";
			}
			else {
				squery += " WHERE l.wifi = 1";
			}
				
		}
		
		if (options.getParking() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND l.parking = 1";
			}
			else {
				squery += " WHERE l.parking = 1";
			}
				
		}
		boolean pricecheck = false;
		if (options.getPrice1() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				squery +=" AND ((l.dailyPrice < 101)";
			}
			else {
				squery += " WHERE ((l.dailyPrice < 101";
			}
			pricecheck = true;
				
		}
		
		if (options.getPrice2() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				if (!pricecheck)
					squery +=" AND ((l.dailyPrice < 151 AND l.dailyPrice > 100) ";
				else
					squery += " OR (l.dailyPrice < 151 AND l.dailyPrice > 100)";
			}
			else {
				squery += " WHERE ((l.dailyPrice < 151 AND l.dailyPrice > 100)";
			}
			pricecheck = true;
		}
		
		if (options.getPrice3() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				if (!pricecheck)
					squery +=" AND ((l.dailyPrice < 201 AND l.dailyPrice > 150) ";
				else
					squery += " OR (l.dailyPrice < 201 AND l.dailyPrice > 150)";
			}
			else {
				squery += " WHERE ((l.dailyPrice < 201 AND l.dailyPrice > 150)";
			}
			pricecheck = true;
		}
		
		if (options.getPrice4() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				if (!pricecheck)
					squery +=" AND ((l.dailyPrice < 301 AND l.dailyPrice > 200) ";
				else
					squery += " OR (l.dailyPrice < 301 AND l.dailyPrice > 200)";
			}
			else {
				squery += " WHERE ((l.dailyPrice < 301 AND l.dailyPrice > 200)";
			}
			pricecheck = true;
		}
		
		if (options.getPrice5() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				if (!pricecheck)
					squery +=" AND ((l.dailyPrice < 501 AND l.dailyPrice > 300) ";
				else
					squery += " OR (l.dailyPrice < 501 AND l.dailyPrice > 300)";
			}
			else {
				squery += " WHERE ((l.dailyPrice < 501 AND l.dailyPrice > 300)";
			}
			pricecheck = true;
		}
		
		if (options.getPrice6() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				if (!pricecheck)
					squery +=" AND ((l.dailyPrice < 1001 AND l.dailyPrice > 500) ";
				else
					squery += " OR (l.dailyPrice < 1001 AND l.dailyPrice > 500)";
			}
			else {
				squery += " WHERE ((l.dailyPrice < 1001 AND l.dailyPrice > 500)";
			}
			pricecheck = true;
		}
		
		if (options.getPrice7() == 1) {
			if (!squery.equals("SELECT l FROM Listing l ")) {
				if (!pricecheck)
					squery +=" AND ( l.dailyPrice > 1000 ";
				else
					squery += " OR l.dailyPrice > 1000";
			}
			else {
				squery += " WHERE  (l.dailyPrice > 100";
			}
			pricecheck = true;
		}
		
		if (pricecheck)
			squery += ")";
	    
		squery += " ORDER BY l.dailyPrice";
		
		//String squery = "SELECT l from Listing l where l.city LIKE :location AND  l.id.idlisting not in (SELECT re.listing.id.idlisting from Reservation re where  (re.startDate >= :start and re.startDate < :end) or (re.endDate >= :start and re.endDate < :end))";
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Listing> searchQuery = em.createQuery(squery, Listing.class);
		
		if(params.hasLocation()){
			searchQuery.setParameter("location", params.getLocation());
		}
		if(params.hasDates()){
			searchQuery.setParameter("start", params.getArrDate());
			searchQuery.setParameter("end", params.getDepDate());
		}
		if(params.hasGuests()){
			searchQuery.setParameter("guests", params.getGuests());
		}

		searchQuery.setFirstResult(page * entries_per_page); //begin from the appropriate result according to the page you are in
		searchQuery.setMaxResults(entries_per_page); //results are for this particular page.Not all of them
		return searchQuery.getResultList();
	}
	
	public List<Listing> getProviderListing(String listingusername) {
		
		String squery = "SELECT l FROM Listing l WHERE l.user.username =:listingusername";
	    
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		TypedQuery<Listing> searchQuery = em.createQuery(squery, Listing.class);
		
		searchQuery.setParameter("listingusername", listingusername);
		return searchQuery.getResultList();
	}

}