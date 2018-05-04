package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListingDAO;
import dao.ListingDAOI;
import dao.ReviewDAO;
import dao.ReviewDAOI;
import dao.UserDAO;
import dao.UserDAOI;
import helpFunctions.CSVUtils;
import jpautils.EntityManagerHelper;
import model.Listing;
import model.ListingPK;
import model.Review;
import model.ReviewPK;
import model.User;
import model.VisitedHistory;

/**
 * Servlet implementation class IntroToDBServlet
 */
@WebServlet("/IntroToDBServlet")
public class IntroToDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntroToDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp;
		if (request.getSession().getAttribute("username") != null) {
			String check = (String)request.getSession().getAttribute("username");
			if (!check.equals("admin")) {
				disp = getServletContext().getRequestDispatcher("/index.jsp");
				disp.forward(request, response);
			}
		}
				

		String csvFile= getServletContext().getInitParameter("csv.location");

		BufferedReader scanner = null;
        scanner = new BufferedReader(new FileReader(new File(csvFile)));
        String something;
        int count = 0;

        scanner.readLine();
        EntityManager em = EntityManagerHelper.getEntityManager();
		Query query = em.createQuery("SELECT MAX(l.id.idlisting) FROM Listing l");
		int idPK = (int)query.getSingleResult() + 1;
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        while ((something = scanner.readLine()) != null && count < 740) {

        	List<String> line = CSVUtils.parseLine(something);
        	User user = new User();
        	User user2;
    		String username = line.get(3);
    		
    		UserDAOI dao = new UserDAO();
    		user2 = dao.findByUsername(username);
    		
    		
    		if (user2 == null) {
    			user.setUsername(username);
        		user.setName(line.get(4));
        		user.setCity("Athens");
        		user.setTrn("123456789");
        		user.setType(2);
        		user.setCell("");
        		user.setCountry("");
        		user.setSurname("");
        		user.setTelephone("");
        		user.setEmail("");
        		user.setPassword("geia");
        		dao.create(user);
        		user=dao.findByUsername(line.get(3));
        		user2=user;
    		}
        	
        	
            ListingDAOI daoo = new ListingDAO();
        	Listing listing = new Listing();
        	ListingPK lpk = new ListingPK();
        	listing.setUser(user2);
        	listing.setId(lpk);
        	listing.setPhoto1("1");
        	int id = Integer.parseInt(line.get(0));
        	hmap.put(id, idPK);
        	++idPK;
        	listing.setAdress("");
        	listing.setName(line.get(1));
        	listing.setDescription(line.get(2));
        	listing.setCity(line.get(7));
        	listing.setArea(line.get(6));
        	listing.setLatitude(Float.parseFloat(line.get(9)));
        	listing.setLongtitude(Float.parseFloat(line.get(10)));
        	

        	if (!line.get(13).isEmpty() && !line.get(13).equals(""))
        		listing.setMaxPeople((int)Float.parseFloat(line.get(13)));
        	if (!line.get(14).isEmpty() && !line.get(14).equals(""))
        		listing.setBathsNumber((int)Float.parseFloat(line.get(14)));
        	if (!line.get(15).isEmpty() && !line.get(15).equals(""))
        		listing.setRoomsNumber((int)Float.parseFloat(line.get(15)));
        	if (!line.get(16).isEmpty() && !line.get(16).equals(""))
        		listing.setBedsNumber((int)Float.parseFloat(line.get(16)));
        	if (!line.get(17).isEmpty() && !line.get(18).equals(""))
        		listing.setSize((int)Float.parseFloat(line.get(18)));
        	
        	String amenities = "";
        	amenities = line.get(17);
        	if (amenities.indexOf("Air Conditioning") != -1) {
        		listing.setAircondition(1);
        	}
        	if (amenities.indexOf("Pets") != -1 || amenities.indexOf("Dogs") != -1) {
        		listing.setDogs(1);
        	}
        	if (amenities.indexOf("Elevator") != -1) {
        		listing.setElevator(1);
        	}
        	if (amenities.indexOf("Heating") != -1) {
        		listing.setHeating(1);
        	}
        	if (amenities.indexOf("Kitchen") != -1) {
        		listing.setKitchen(1);
        	}
        	if (amenities.indexOf("Parking") != -1) {
        		listing.setParking(1);
        	}
        	if (amenities.indexOf("TV") != -1) {
        		listing.setTv(1);
        	}
        	
        	if (amenities.indexOf("Wireless Internet") != -1) {
        		listing.setWifi(1);
        	}
        	
        	String type = line.get(11);
        	if (type.indexOf("Villa") != -1) {
        		listing.setType(5);
        	}
        	
        	if (type.indexOf("Apartment") != -1) {
        		listing.setType(1);
        	}
        	
        	if (type.indexOf("Loft") != -1) {
        		listing.setType(2);
        	}
        	
        	if (type.indexOf("Dorm") != -1) {
        		listing.setType(4);
        	}
        	
        	int price = (int)Float.parseFloat(line.get(19).substring(1));
        	listing.setDailyPrice(price);
        	
        	daoo.create(listing);
            
            ++count;
        }
        scanner.close();
       
        
        
        csvFile= getServletContext().getInitParameter("csv2.location");
        scanner = null;
        scanner = new BufferedReader(new FileReader(new File(csvFile)));
        count = 0;
        scanner.readLine();
        while ((something = scanner.readLine()) != null) {
        	List<String> line = CSVUtils.parseLine(something);
        	if (line.size() < 6)
        		continue;
        	if (!line.get(0).matches(".*\\d+.*") || !line.get(1).matches(".*\\d+.*" ) || !line.get(2).matches(".*\\d+.*" ) || !line.get(3).matches(".*\\d+.*" ))
        		continue;
        	if (line.get(0).matches(".*[a-zA-Z]+.*"))
        		continue;
        	int id = Integer.parseInt(line.get(0));
        	if (hmap.get(id) == null)
        		continue;
        	int listingid = hmap.get(id);
        	if (listingid > 106 && listingid < 112)
        		continue;
        	Listing listing;

        	TypedQuery<Listing> searchQuery = em.createQuery("SELECT l FROM Listing l WHERE l.id.idlisting = :id",Listing.class); 
			searchQuery.setParameter("id", listingid);
			List<Listing> list = searchQuery.getResultList();
			if (list == null || list.isEmpty()) { System.out.println("nothing here");continue; }
			else
				listing = list.get(0);
 
        	
        	User user = new User();
        	User user2;
    		String username = line.get(3);
    		
    		UserDAOI dao = new UserDAO();
    		user2 = dao.findByUsername(username);
    		
    		
    		if (user2 == null) {
    			user.setUsername(username);
        		user.setName(line.get(4));
        		user.setCity("Athens");
        		user.setTrn("123456789");
        		user.setType(1);
        		user.setCell("");
        		user.setCountry("");
        		user.setSurname("");
        		user.setTelephone("");
        		user.setEmail("");
        		user.setPassword("geia");
        		dao.create(user);
        		user=dao.findByUsername(line.get(3));
        		user2=user;
    		}
    		ReviewDAOI reviewdao = new ReviewDAO();
    		Review review = new Review();
    		
    		ReviewPK rpk = new ReviewPK();
    		String text = line.get(5);
    		
    		
    		review.setId(rpk);
    		review.setListing(listing);
    		float score = 3;
    		review.setScore(score);
    		review.setText(text);
    		review.setUser(user2);
    		
    		reviewdao.create(review);
    		
    		int totalscore = listing.getMonthlyPrice() + (int)score;
    		listing.setMonthlyPrice(totalscore);
    		float avgscore = totalscore / listing.getReviews().size();
    		listing.setReviewsAvgScore(avgscore);
        	++count;
        }
        disp = getServletContext().getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
