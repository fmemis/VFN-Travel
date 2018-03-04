package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the images database table.
 * 
 */
@Embeddable
public class ImagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idimages;

	@Column(name="listings_idlisting", insertable=false, updatable=false)
	private int listingsIdlisting;

	@Column(name="listing_username", insertable=false, updatable=false)
	private String listingUsername;

	public ImagePK() {
	}
	public int getIdimages() {
		return this.idimages;
	}
	public void setIdimages(int idimages) {
		this.idimages = idimages;
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
		if (!(other instanceof ImagePK)) {
			return false;
		}
		ImagePK castOther = (ImagePK)other;
		return 
			(this.idimages == castOther.idimages)
			&& (this.listingsIdlisting == castOther.listingsIdlisting)
			&& this.listingUsername.equals(castOther.listingUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idimages;
		hash = hash * prime + this.listingsIdlisting;
		hash = hash * prime + this.listingUsername.hashCode();
		
		return hash;
	}
}