package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the reservation database table.
 * 
 */
@Embeddable
public class ReservationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int reservationid;

	@Column(name="user_username", insertable=false, updatable=false)
	private String userUsername;

	@Column(name="listings_idlisting", insertable=false, updatable=false)
	private int listingsIdlisting;

	@Column(name="listing_username", insertable=false, updatable=false)
	private String listingUsername;

	public ReservationPK() {
	}
	public int getReservationid() {
		return this.reservationid;
	}
	public void setReservationid(int reservationid) {
		this.reservationid = reservationid;
	}
	public String getUserUsername() {
		return this.userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}
	public int getListingsIdlisting() {
		return this.listingsIdlisting;
	}
	public void setListingsIdlisting(int listingsIdlisting) {
		this.listingsIdlisting = listingsIdlisting;
	}
	public String getListingUsername() {
		return this.listingUsername;
	}
	public void setListingUsername(String listingUsername) {
		this.listingUsername = listingUsername;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservationPK)) {
			return false;
		}
		ReservationPK castOther = (ReservationPK)other;
		return 
			(this.reservationid == castOther.reservationid)
			&& this.userUsername.equals(castOther.userUsername)
			&& (this.listingsIdlisting == castOther.listingsIdlisting)
			&& this.listingUsername.equals(castOther.listingUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.reservationid;
		hash = hash * prime + this.userUsername.hashCode();
		hash = hash * prime + this.listingsIdlisting;
		hash = hash * prime + this.listingUsername.hashCode();
		
		return hash;
	}
}