package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the review database table.
 * 
 */
@Embeddable
public class ReviewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idreview;

	@Column(name="user_username", insertable=false, updatable=false)
	private String userUsername;

	@Column(name="listings_idlisting", insertable=false, updatable=false)
	private int listingsIdlisting;

	@Column(name="lisitng_username", insertable=false, updatable=false)
	private String lisitngUsername;

	public ReviewPK() {
	}
	public int getIdreview() {
		return this.idreview;
	}
	public void setIdreview(int idreview) {
		this.idreview = idreview;
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
	public String getLisitngUsername() {
		return this.lisitngUsername;
	}
	public void setLisitngUsername(String lisitngUsername) {
		this.lisitngUsername = lisitngUsername;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReviewPK)) {
			return false;
		}
		ReviewPK castOther = (ReviewPK)other;
		return 
			(this.idreview == castOther.idreview)
			&& this.userUsername.equals(castOther.userUsername)
			&& (this.listingsIdlisting == castOther.listingsIdlisting)
			&& this.lisitngUsername.equals(castOther.lisitngUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idreview;
		hash = hash * prime + this.userUsername.hashCode();
		hash = hash * prime + this.listingsIdlisting;
		hash = hash * prime + this.lisitngUsername.hashCode();
		
		return hash;
	}
}