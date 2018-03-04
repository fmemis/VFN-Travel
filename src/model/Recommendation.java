package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recommendation database table.
 * 
 */
@Entity
@NamedQuery(name="Recommendation.findAll", query="SELECT r FROM Recommendation r")
public class Recommendation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecommendationPK id;

	private String listinghost;

	private String listinghost2;

	private String listinghost3;

	private String listinghost4;

	private String listinghost5;

	private String listinghost6;

	private int listingid;

	private int listingid2;

	private int listingid3;

	private int listingid4;

	private int listingid5;

	private int listingid6;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Recommendation() {
	}

	public RecommendationPK getId() {
		return this.id;
	}

	public void setId(RecommendationPK id) {
		this.id = id;
	}

	public String getListinghost() {
		return this.listinghost;
	}

	public void setListinghost(String listinghost) {
		this.listinghost = listinghost;
	}

	public String getListinghost2() {
		return this.listinghost2;
	}

	public void setListinghost2(String listinghost2) {
		this.listinghost2 = listinghost2;
	}

	public String getListinghost3() {
		return this.listinghost3;
	}

	public void setListinghost3(String listinghost3) {
		this.listinghost3 = listinghost3;
	}

	public String getListinghost4() {
		return this.listinghost4;
	}

	public void setListinghost4(String listinghost4) {
		this.listinghost4 = listinghost4;
	}

	public String getListinghost5() {
		return this.listinghost5;
	}

	public void setListinghost5(String listinghost5) {
		this.listinghost5 = listinghost5;
	}

	public String getListinghost6() {
		return this.listinghost6;
	}

	public void setListinghost6(String listinghost6) {
		this.listinghost6 = listinghost6;
	}

	public int getListingid() {
		return this.listingid;
	}

	public void setListingid(int listingid) {
		this.listingid = listingid;
	}

	public int getListingid2() {
		return this.listingid2;
	}

	public void setListingid2(int listingid2) {
		this.listingid2 = listingid2;
	}

	public int getListingid3() {
		return this.listingid3;
	}

	public void setListingid3(int listingid3) {
		this.listingid3 = listingid3;
	}

	public int getListingid4() {
		return this.listingid4;
	}

	public void setListingid4(int listingid4) {
		this.listingid4 = listingid4;
	}

	public int getListingid5() {
		return this.listingid5;
	}

	public void setListingid5(int listingid5) {
		this.listingid5 = listingid5;
	}

	public int getListingid6() {
		return this.listingid6;
	}

	public void setListingid6(int listingid6) {
		this.listingid6 = listingid6;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}