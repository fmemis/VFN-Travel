package dao;

import java.util.List;

import model.Listing;
import model.Review;

public interface ReviewDAOI {
	public boolean create(Review review);
	public List<Review> getReviews(int listingid);
}
