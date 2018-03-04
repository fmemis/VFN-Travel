package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String cell;

	private String city;

	private String country;

	private String email;

	private String name;

	private String password;

	@Lob
	private String photo;

	private String surname;

	private String telephone;

	private String trn;

	private int type;

	//bi-directional many-to-one association to Listing
	@OneToMany(mappedBy="user")
	private List<Listing> listings;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

	//bi-directional many-to-one association to Recommendation
	@OneToMany(mappedBy="user")
	private List<Recommendation> recommendations;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="user")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="user")
	private List<Review> reviews;

	//bi-directional many-to-one association to SearchHistory
	@OneToMany(mappedBy="user")
	private List<SearchHistory> searchHistories;

	//bi-directional many-to-one association to VisitedHistory
	@OneToMany(mappedBy="user")
	private List<VisitedHistory> visitedHistories;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCell() {
		return this.cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTrn() {
		return this.trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<Listing> getListings() {
		return this.listings;
	}

	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	public Listing addListing(Listing listing) {
		getListings().add(listing);
		listing.setUser(this);

		return listing;
	}

	public Listing removeListing(Listing listing) {
		getListings().remove(listing);
		listing.setUser(null);

		return listing;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setUser2(null);

		return messages2;
	}

	public List<Recommendation> getRecommendations() {
		return this.recommendations;
	}

	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}

	public Recommendation addRecommendation(Recommendation recommendation) {
		getRecommendations().add(recommendation);
		recommendation.setUser(this);

		return recommendation;
	}

	public Recommendation removeRecommendation(Recommendation recommendation) {
		getRecommendations().remove(recommendation);
		recommendation.setUser(null);

		return recommendation;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setUser(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setUser(null);

		return reservation;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setUser(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setUser(null);

		return review;
	}

	public List<SearchHistory> getSearchHistories() {
		return this.searchHistories;
	}

	public void setSearchHistories(List<SearchHistory> searchHistories) {
		this.searchHistories = searchHistories;
	}

	public SearchHistory addSearchHistory(SearchHistory searchHistory) {
		getSearchHistories().add(searchHistory);
		searchHistory.setUser(this);

		return searchHistory;
	}

	public SearchHistory removeSearchHistory(SearchHistory searchHistory) {
		getSearchHistories().remove(searchHistory);
		searchHistory.setUser(null);

		return searchHistory;
	}

	public List<VisitedHistory> getVisitedHistories() {
		return this.visitedHistories;
	}

	public void setVisitedHistories(List<VisitedHistory> visitedHistories) {
		this.visitedHistories = visitedHistories;
	}

	public VisitedHistory addVisitedHistory(VisitedHistory visitedHistory) {
		getVisitedHistories().add(visitedHistory);
		visitedHistory.setUser(this);

		return visitedHistory;
	}

	public VisitedHistory removeVisitedHistory(VisitedHistory visitedHistory) {
		getVisitedHistories().remove(visitedHistory);
		visitedHistory.setUser(null);

		return visitedHistory;
	}

}