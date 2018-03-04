package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the images database table.
 * 
 */
@Entity
@Table(name="images")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ImagePK id;

	@Lob
	private String photo;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="listing_username", referencedColumnName="user_username"),
		@JoinColumn(name="listings_idlisting", referencedColumnName="idlisting")
		})
	private Listing listing;

	public Image() {
	}

	public ImagePK getId() {
		return this.id;
	}

	public void setId(ImagePK id) {
		this.id = id;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}