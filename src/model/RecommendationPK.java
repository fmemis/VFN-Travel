package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the recommendation database table.
 * 
 */
@Embeddable
public class RecommendationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idrecommendation;

	@Column(name="user_username", insertable=false, updatable=false)
	private String userUsername;

	public RecommendationPK() {
	}
	public int getIdrecommendation() {
		return this.idrecommendation;
	}
	public void setIdrecommendation(int idrecommendation) {
		this.idrecommendation = idrecommendation;
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
		if (!(other instanceof RecommendationPK)) {
			return false;
		}
		RecommendationPK castOther = (RecommendationPK)other;
		return 
			(this.idrecommendation == castOther.idrecommendation)
			&& this.userUsername.equals(castOther.userUsername);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idrecommendation;
		hash = hash * prime + this.userUsername.hashCode();
		
		return hash;
	}
}