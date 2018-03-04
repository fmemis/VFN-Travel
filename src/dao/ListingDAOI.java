package dao;

import model.Listing;
import java.util.List;

public interface ListingDAOI {

	public boolean create(Listing listing);
	public Listing findById(int id,String username);
	public List<Listing> getListings();
	public List<Listing> search(SearchParams params, int page, int entries_per_page);
	public List<Listing> search(SearchParams params,SearchOptions options,int page,int entries_per_page);
	public List<Listing> getProviderListing(String listingusername);
}

