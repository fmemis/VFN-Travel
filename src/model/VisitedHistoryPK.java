package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the visited_history database table.
 * 
 */
@Embeddable
public class VisitedHistoryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="idvisited_history")
	private int idvisitedHistory;

	@Column(name="user_username", insertable=false, updatable=false)
	private String userUsername;

	public VisitedHistoryPK() {
	}
	public int getIdvisitedHistory() {
		return this.idvisitedHistory;
	}
	public void setIdvisitedHistory(int idvisitedHistory) {
		this.idvisitedHistory = idvisitedHistory;
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
		if (!(other instanceof VisitedHistoryPK)) {
			return false;
		}
		VisitedHistoryPK castOther = (VisitedHistoryPK)other;
		return 
			(this.idvisitedHistory == castOther.idvisitedHistory)
			&& this.userUsername.equals(castOther.userUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idvisitedHistory;
		hash = hash * prime + this.userUsername.hashCode();
		
		return hash;
	}
}