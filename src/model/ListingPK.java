package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the listings database table.
 * 
 */
@Embeddable
public class ListingPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idlisting;

	@Column(name="user_username", insertable=false, updatable=false)
	private String userUsername;

	public ListingPK() {
	}
	public int getIdlisting() {
		return this.idlisting;
	}
	public void setIdlisting(int idlisting) {
		this.idlisting = idlisting;
	}
	public String getUserUsername() {
		return this.userUsername;
	}
	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ListingPK)) {
			return false;
		}
		ListingPK castOther = (ListingPK)other;
		return 
			(this.idlisting == castOther.idlisting)
			&& this.userUsername.equals(castOther.userUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idlisting;
		hash = hash * prime + this.userUsername.hashCode();
		
		return hash;
	}
}