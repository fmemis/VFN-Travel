package servlets;

import java.io.IOException;


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
import model.Listing;
import model.Review;
import model.ReviewPK;
import model.User;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/Review")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//save the user review and how it affects the listing's score
		String rating = request.getParameter("optradio");
		int score = 0;
		if(rating.equals("perfect")) {
			score = 5;
		}
		if(rating.equals("pretty good")) {
			score = 4;
		}
		if(rating.equals("good")) {
			score = 3;
		}
		if(rating.equals("mediocre")) {
			score = 2;
		}
		if(rating.equals("bad")) {
			score = 1;
		}
		
		User user; 
		String username = (String)request.getSession().getAttribute("username");
		UserDAOI dao = new UserDAO();
		user = dao.findByUsername(username);
		
		Listing listing;
		ListingDAOI listingdao = new ListingDAO();
		listing = listingdao.findById(Integer.parseInt(request.getParameter("listid")),request.getParameter("listprov"));
		
		String text = request.getParameter("review");
		
		ReviewDAOI reviewdao = new ReviewDAO();
		Review review = new Review();
		
		ReviewPK rpk = new ReviewPK();
		
		review.setId(rpk);
		review.setListing(listing);
		review.setScore(score);
		review.setText(text);
		review.setUser(user);
		
		reviewdao.create(review);
		int totalscore = listing.getTotalScore() + score;
		listing.setTotalScore(totalscore);                 
		float avgscore;
		if (totalscore > 0 && listing.getReviews().size() > 0)
			avgscore = totalscore / listing.getReviews().size();
		else
			avgscore = totalscore;
		listing.setReviewsAvgScore(avgscore);
		
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/Listing?listingid="+request.getParameter("listid")+"&provname="+request.getParameter("listprov"));
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
