package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the search_history database table.
 * 
 */
@Embeddable
public class SearchHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idsearch_history")
	private int idsearchHistory;

	@Column(name="user_username", insertable=false, updatable=false)
	private String userUsername;

	public SearchHistoryPK() {
	}
	public int getIdsearchHistory() {
		return this.idsearchHistory;
	}
	public void setIdsearchHistory(int idsearchHistory) {
		this.idsearchHistory = idsearchHistory;
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
		if (!(other instanceof SearchHistoryPK)) {
			return false;
		}
		SearchHistoryPK castOther = (SearchHistoryPK)other;
		return 
			(this.idsearchHistory == castOther.idsearchHistory)
			&& this.userUsername.equals(castOther.userUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idsearchHistory;
		hash = hash * prime + this.userUsername.hashCode();
		
		return hash;
	}
}