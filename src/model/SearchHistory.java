package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the search_history database table.
 * 
 */
@Entity
@Table(name="search_history")
@NamedQuery(name="SearchHistory.findAll", query="SELECT s FROM SearchHistory s")
public class SearchHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SearchHistoryPK id;

	private String listinghost;

	private int listingid;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public SearchHistory() {
	}

	public SearchHistoryPK getId() {
		return this.id;
	}

	public void setId(SearchHistoryPK id) {
		this.id = id;
	}

	public String getListinghost() {
		return this.listinghost;
	}

	public void setListinghost(String listinghost) {
		this.listinghost = listinghost;
	}

	public int getListingid() {
		return this.listingid;
	}

	public void setListingid(int listingid) {
		this.listingid = listingid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}