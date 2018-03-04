package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the visited_history database table.
 * 
 */
@Entity
@Table(name="visited_history")
@NamedQuery(name="VisitedHistory.findAll", query="SELECT v FROM VisitedHistory v")
public class VisitedHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VisitedHistoryPK id;

	private String url;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public VisitedHistory() {
	}

	public VisitedHistoryPK getId() {
		return this.id;
	}

	public void setId(VisitedHistoryPK id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}