package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import dao.ImageDAO;
import dao.ImageDAOI;
import dao.ListingDAO;
import dao.ListingDAOI;
import dao.UserDAO;
import dao.UserDAOI;
import jpautils.EntityManagerHelper;
import model.Image;
import model.ImagePK;
import model.Listing;
import model.ListingPK;
import model.User;

/**
 * Servlet implementation class ProviderProfileServlet
 */
@WebServlet("/ProviderProfileServlet")
@MultipartConfig
public class ProviderProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProviderProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp;
		User user; 
		String usernamee = (String)request.getSession().getAttribute("username");
		UserDAOI dao = new UserDAO();
		user = dao.findByUsername(usernamee);
		String address = request.getParameter("address");
		String area = request.getParameter("area");
		int baths = Integer.parseInt(request.getParameter("baths"));
		int beds = Integer.parseInt(request.getParameter("beds"));
		String city = request.getParameter("city");
		int dprice = Integer.parseInt(request.getParameter("dprice"));
		int airc = Integer.parseInt(request.getParameter("aircondition"));
		int elevator = Integer.parseInt(request.getParameter("elevator"));
		int heat = Integer.parseInt(request.getParameter("heat"));
		String name = request.getParameter("name");
		int kitchen = Integer.parseInt(request.getParameter("kitchen"));
		int parking = Integer.parseInt(request.getParameter("parking"));
		int wifi = Integer.parseInt(request.getParameter("wifi"));
		int size = Integer.parseInt(request.getParameter("size"));
		int tv = Integer.parseInt(request.getParameter("tv"));
		String description = request.getParameter("description");
		float latitude = Float.parseFloat(request.getParameter("latitude"));
		float longtitude = Float.parseFloat(request.getParameter("longtitude"));
		int maxpeople = Integer.parseInt(request.getParameter("maxp"));
		int roomsnumber = Integer.parseInt(request.getParameter("roomsnumber"));
		int pets = Integer.parseInt(request.getParameter("pets"));
		int roomtype = Integer.parseInt(request.getParameter("rtype"));
		
	    
		
		
		ListingDAOI daoo = new ListingDAO();
		Listing listing = new Listing();
		ListingPK lpk = new ListingPK();
		
		listing.setAdress(address);
		listing.setArea(area);
		listing.setBathsNumber(baths);
		listing.setBedsNumber(beds);
		listing.setCity(city);
		listing.setDailyPrice(dprice);
		listing.setAircondition(airc);
		listing.setElevator(elevator);
		listing.setHeating(heat);
		listing.setName(name);
		listing.setKitchen(kitchen);
		listing.setParking(parking);
		listing.setWifi(wifi);
		listing.setSize(size);
		listing.setTv(tv);
		listing.setDescription(description);
		listing.setLatitude(latitude);
		listing.setLongtitude(longtitude);
		listing.setMaxPeople(maxpeople);
		listing.setRoomsNumber(roomsnumber);
		listing.setType(roomtype);
		listing.setDogs(pets);		
		listing.setUser(user);
		listing.setId(lpk);
		listing.setPhoto1("1");
		
		
		//provider can add a new listing.We need to take care of the photos that he/she wants to upload
		
		Image image;
		ImageDAOI imagedao = new ImageDAO();
		ArrayList<Image> images = new ArrayList<>();
		
		
		List<Part> fileParts = request.getParts().stream().filter(part -> "uploadingFiles".equals(part.getName())).collect(Collectors.toList()); 
		File path = new File(getServletContext().getInitParameter("photos.location"));
		//long photosMaxSize= Long.parseLong(getServletContext().getInitParameter("photos.maxsize"));
		long photosMaxSize = 7000000;
		int count = 0;
		String savename;
		daoo.create(listing);
		
		//We save the photos after we have created the listing.(it will be the listing with the maxid.
		String squery = "SELECT MAX(l.id.idlisting) FROM Listing l ";
		EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT MAX(l.id.idlisting) FROM Listing l WHERE l.id.userUsername = :provname");
		query.setParameter("provname", usernamee);
		int id = (int)query.getSingleResult();
		System.out.println(query.getSingleResult() + usernamee);
		
		
		String username = listing.getId().getUserUsername();
		int something = listing.getRoomsNumber();
		///System.out.println("1" + listing.getId().getIdlisting());
		System.out.println("2" + listing.getCity());
		System.out.println(id + username + something);
		
		listing = daoo.findById(id, usernamee);
		System.out.println("1" + listing.getCity());
		
		for (Part filePart : fileParts) {
	        String photoName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
	       // InputStream fileContent = filePart.getInputStream();
	        System.out.println("1" + listing.getCity());
	        if (photoName.lastIndexOf(".") != -1) { // No extension.
				String ending = photoName.substring(photoName.lastIndexOf("."));
				long photoSize =filePart.getSize();
				System.out.println("2" + listing.getCity());
				if (ending.equalsIgnoreCase(".png") || ending.equalsIgnoreCase(".jpg") || ending.equals(".jpeg")) {
					if (photoSize <= photosMaxSize) {
						//different name each time.That way we can save each photo multiple times and its clear to which listing the photos are attached to.
						savename = listing.getId().getIdlisting() + "_" + count + ending;
						File photo = new File(path,savename);
						Files.copy(filePart.getInputStream(), photo.toPath());
						image = new Image();
						ImagePK imagePK = new ImagePK();
						//listing = daoo.findById(listing.getId().getIdlisting(), listing.getId().getUserUsername());
						System.out.println("3" + listing.getCity());
						image.setListing(listing);
						image.setId(imagePK);
						image.setPhoto(savename);
						imagedao.create(image);
						System.out.println("4" + listing.getCity());
						listing.addImage(image);
						System.out.println("5" + listing.getCity());
						++count;
					}	
				}
	        }
		}
		
		
		
		request.setAttribute("user", user);
		//disp = getServletContext().getRequestDispatcher("/providerprofile.jsp");
		//disp.forward(request, response);
		response.sendRedirect("userprofile");
	}

}
