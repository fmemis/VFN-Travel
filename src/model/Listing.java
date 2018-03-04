package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the listings database table.
 * 
 */
@Entity
@Table(name="listings")
@NamedQuery(name="Listing.findAll", query="SELECT l FROM Listing l")
public class Listing implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ListingPK id;

	private String adress;

	private int aircondition;

	private String area;

	@Column(name="baths_number")
	private int bathsNumber;

	@Column(name="beds_number")
	private int bedsNumber;

	private String city;

	@Column(name="daily_price")
	private int dailyPrice;

	@Lob
	private String description;

	private int dogs;

	private int elevator;

	private int heating;

	private int kitchen;

	private float latitude;

	private float longtitude;

	@Column(name="max_people")
	private int maxPeople;

	@Column(name="monthly_price")
	private int monthlyPrice;

	private String name;

	private int parking;

	@Lob
	private String photo1;

	@Lob
	private String photo2;

	@Lob
	private String photo3;

	@Column(name="reviews_avg_score")
	private float reviewsAvgScore;

	@Column(name="room_type")
	private String roomType;

	@Column(name="rooms_number")
	private int roomsNumber;

	private int size;

	@Column(name="total_score")
	private int totalScore;

	private int tv;

	private int type;

	@Column(name="weekly_price")
	private int weeklyPrice;

	private int wifi;

	//bi-directional many-to-one association to Image
	@OneToMany(mappedBy="listing")
	private List<Image> images;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="listing")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="listing")
	private List<Review> reviews;

	public Listing() {
	}

	public ListingPK getId() {
		return this.id;
	}

	public void setId(ListingPK id) {
		this.id = id;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getAircondition() {
		return this.aircondition;
	}

	public void setAircondition(int aircondition) {
		this.aircondition = aircondition;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getBathsNumber() {
		return this.bathsNumber;
	}

	public void setBathsNumber(int bathsNumber) {
		this.bathsNumber = bathsNumber;
	}

	public int getBedsNumber() {
		return this.bedsNumber;
	}

	public void setBedsNumber(int bedsNumber) {
		this.bedsNumber = bedsNumber;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDailyPrice() {
		return this.dailyPrice;
	}

	public void setDailyPrice(int dailyPrice) {
		this.dailyPrice = dailyPrice;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDogs() {
		return this.dogs;
	}

	public void setDogs(int dogs) {
		this.dogs = dogs;
	}

	public int getElevator() {
		return this.elevator;
	}

	public void setElevator(int elevator) {
		this.elevator = elevator;
	}

	public int getHeating() {
		return this.heating;
	}

	public void setHeating(int heating) {
		this.heating = heating;
	}

	public int getKitchen() {
		return this.kitchen;
	}

	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}

	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongtitude() {
		return this.longtitude;
	}

	public void setLongtitude(float longtitude) {
		this.longtitude = longtitude;
	}

	public int getMaxPeople() {
		return this.maxPeople;
	}

	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}

	public int getMonthlyPrice() {
		return this.monthlyPrice;
	}

	public void setMonthlyPrice(int monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParking() {
		return this.parking;
	}

	public void setParking(int parking) {
		this.parking = parking;
	}

	public String getPhoto1() {
		return this.photo1;
	}

	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}

	public String getPhoto2() {
		return this.photo2;
	}

	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}

	public String getPhoto3() {
		return this.photo3;
	}

	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}

	public float getReviewsAvgScore() {
		return this.reviewsAvgScore;
	}

	public void setReviewsAvgScore(float reviewsAvgScore) {
		this.reviewsAvgScore = reviewsAvgScore;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomsNumber() {
		return this.roomsNumber;
	}

	public void setRoomsNumber(int roomsNumber) {
		this.roomsNumber = roomsNumber;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTv() {
		return this.tv;
	}

	public void setTv(int tv) {
		this.tv = tv;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getWeeklyPrice() {
		return this.weeklyPrice;
	}

	public void setWeeklyPrice(int weeklyPrice) {
		this.weeklyPrice = weeklyPrice;
	}

	public int getWifi() {
		return this.wifi;
	}

	public void setWifi(int wifi) {
		this.wifi = wifi;
	}

	public List<Image> getImages() {
		return this.images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Image addImage(Image image) {
		getImages().add(image);
		image.setListing(this);

		return image;
	}

	public Image removeImage(Image image) {
		getImages().remove(image);
		image.setListing(null);

		return image;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setListing(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setListing(null);

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
		review.setListing(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setListing(null);

		return review;
	}

}