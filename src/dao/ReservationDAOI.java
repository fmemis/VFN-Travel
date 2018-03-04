package dao;

import java.util.Date;
import java.util.List;

import model.Reservation;

public interface ReservationDAOI {
	public boolean create(Reservation reservation);
	public boolean listingAvailable(Date start, Date end, int listingid);
	public boolean petsAllowed(int listingid);
	public List<Reservation> getResarvations(int listingid);
}
