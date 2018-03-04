package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the review database table.
 * 
 */
@Entity
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReviewPK id;

	private float score;

	@Lob
	private String text;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="lisitng_username", referencedColumnName="user_username"),
		@JoinColumn(name="listings_idlisting", referencedColumnName="idlisting")
		})
	private Listing listing;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Review() {
	}

	public ReviewPK getId() {
		return this.id;
	}

	public void setId(ReviewPK id) {
		this.id = id;
	}

	public float getScore() {
		return this.score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}