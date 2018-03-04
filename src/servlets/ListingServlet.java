package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import dao.SearchHistoryDAO;
import dao.SearchHistoryDAOI;
import dao.UserDAO;
import dao.UserDAOI;
import dao.VisitedHistoryDAO;
import dao.VisitedHistoryDAOI;
import jpautils.EntityManagerHelper;
import model.Image;
import model.Listing;
import model.ListingPK;
import model.Review;
import model.SearchHistory;
import model.SearchHistoryPK;
import model.User;
import model.VisitedHistory;
import model.VisitedHistoryPK;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Servlet implementation class ListingServlet
 */
@WebServlet("/Listing")
public class ListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int listingid;
		String provname;
		Listing listing;
		EntityManager em = EntityManagerHelper.getEntityManager();
		
		
		//if we are returning from prompt to login,no take the listingid and provname from hidden inputs not parameters.
		if(request.getAttribute("Attrneeded")!= null && !request.getAttribute("Attrneeded").equals("")) {

			listingid = (int) request.getAttribute("listid");
			provname = (String) request.getAttribute("listprov");
		}
		
		//We receive listingid and provname from parameters in the url
		else {

			listingid = Integer.parseInt(request.getParameter("listingid"));
			provname = request.getParameter("provname");
			//if user is logged in store his search history
			if (request.getSession().getAttribute("username") != null) {
				SearchHistory search = new SearchHistory();
				SearchHistoryPK searchPK = new SearchHistoryPK();
				String username1 = (String)request.getSession().getAttribute("username");
				TypedQuery<SearchHistory> searchQuery1 = em.createQuery("SELECT s FROM SearchHistory s WHERE s.listingid = :sid AND s.listinghost = :host AND s.user.username = :username",SearchHistory.class); 
				searchQuery1.setParameter("sid", listingid);
				searchQuery1.setParameter("host", provname);
				searchQuery1.setParameter("username", username1);
				List<SearchHistory> list1 = searchQuery1.getResultList();
				if (list1 == null || list1.isEmpty()) { 
					UserDAOI dao1 = new UserDAO();
					User user1;
					user1 = dao1.findByUsername(username1);
					search.setId(searchPK);
					search.setListinghost(provname);
					search.setListingid(listingid);
					search.setUser(user1);
					SearchHistoryDAOI  searchdao = new SearchHistoryDAO();
				    searchdao.create(search);
				}
			}
		}
		RequestDispatcher disp;
			
			request.getSession().setAttribute("listingid", listingid);
			request.getSession().setAttribute("provname", provname);
		
			ListingDAOI listingdao = new ListingDAO();
			listing = listingdao.findById(listingid,provname);
			request.getSession().setAttribute("price",listing.getDailyPrice());
		
		request.setAttribute("listing", listing);
		List<Image> alist = listing.getImages();
		
		
		request.setAttribute("count", alist.size());
		request.setAttribute("test",false);
		
		UserDAOI providerdao = new UserDAO();
		User provider; 
		provider = providerdao.findByUsername(provname);
		request.setAttribute("provider", provider);
		
		ReviewDAOI reviewdao = new ReviewDAO();
		List<Review> results = reviewdao.getReviews(listingid);
		request.setAttribute("searchResults", results);
		
		 
		String username;
		//only users who have made a reservation in the listing can write a review.
		if (request.getSession().getAttribute("username") != null) {

			username = (String)request.getSession().getAttribute("username");

			String sid = "" + listing.getId().getIdlisting();

			TypedQuery<VisitedHistory> searchQuery = em.createQuery("SELECT v FROM VisitedHistory v WHERE v.url = :sid AND v.user.username = :username",VisitedHistory.class); 
			searchQuery.setParameter("sid", sid);
			searchQuery.setParameter("username", username);
			List<VisitedHistory> list = searchQuery.getResultList();
			if (list == null || list.isEmpty()) { System.out.println("empty"); }
			else  {
				System.out.println("not empty");
				request.setAttribute("visit","true");
			}
		}
		
		disp = getServletContext().getRequestDispatcher("/listing.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// TODO Auto-generated method stub
		
	}

}
