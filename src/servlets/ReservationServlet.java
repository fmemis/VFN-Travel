package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListingDAO;
import dao.ListingDAOI;
import dao.ReservationDAOI;
import dao.ReservationDAO;
import dao.UserDAO;
import dao.UserDAOI;
import dao.VisitedHistoryDAO;
import dao.VisitedHistoryDAOI;
import model.Listing;
import model.Reservation;
import model.ReservationPK;
import model.User;
import model.VisitedHistory;
import model.VisitedHistoryPK;



/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/Reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//its called to check if we will proceed with the reservation

		RequestDispatcher disp;

		String guests = request.getParameter("guests");
		String arrival = request.getParameter("datepicker");
		String departure = request.getParameter("datepicker2");
		int price = (int)request.getSession().getAttribute("price");
		request.getSession().setAttribute("guests", guests);
		request.getSession().setAttribute("arrival", arrival);
		request.getSession().setAttribute("departure", departure);
		
		//convert the dates into a form which can be used in a sql query
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	    Date parsedate = null;
		try {
			parsedate = format.parse(arrival);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    java.sql.Date sql = new java.sql.Date(parsedate.getTime());
	    Date parsedate2 = null;
		try {
			parsedate2 = format.parse(departure);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    java.sql.Date sql2 = new java.sql.Date(parsedate2.getTime());
	    
	    long diff = sql2.getTime() - sql.getTime();
	    
		long total =Long.valueOf(price).longValue() * (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		request.setAttribute("price", total);
		String check = "first";
		request.setAttribute("check", check);
		
		int listingid = Integer.parseInt(request.getParameter("listid"));
		String provname = request.getParameter("listprov");
		
		ReservationDAOI res = new ReservationDAO();
		//check if the listing is available
		boolean available = res.listingAvailable(sql, sql2, listingid);
		if(available) {
			if(res.petsAllowed(listingid)) {
				request.setAttribute("pets", "Allowed");
			}
			else {
				request.setAttribute("pets", "Not allowed");
			}
			disp = getServletContext().getRequestDispatcher("/payment.jsp");
			disp.forward(request, response);
		}
		else {

			disp = getServletContext().getRequestDispatcher("/Listing?listingid="+listingid+"&provname="+provname);
			disp.forward(request, response);
		}		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//it finalizes the reservation
		String guests = (String)request.getSession().getAttribute("guests");
		String arrival = (String)request.getSession().getAttribute("arrival");
		String departure = (String)request.getSession().getAttribute("departure");
		int listingid = (int)request.getSession().getAttribute("listingid");
		String provname = (String)request.getSession().getAttribute("provname");
		String username = (String)request.getSession().getAttribute("username");
		UserDAOI dao = new UserDAO();
		User user = dao.findByUsername(username);
		ListingDAOI daoo = new ListingDAO();
		Listing listing = daoo.findById(listingid,provname);
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	    Date parsedate = null;
		try {
			parsedate = format.parse(arrival);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    java.sql.Date sql = new java.sql.Date(parsedate.getTime());
	    Date parsedate2 = null;
		try {
			parsedate2 = format.parse(departure);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    java.sql.Date sql2 = new java.sql.Date(parsedate2.getTime());
	    
	    
	    Reservation reservation = new Reservation();
	    ReservationPK reservationPK = new ReservationPK();
	    reservation.setId(reservationPK);
	    reservation.setStartDate(sql);
	    reservation.setEndDate(sql2);
	    reservation.setUser(user);
	    reservation.setListing(listing);
	    
	    ReservationDAOI reservationdao = new ReservationDAO();
	    reservationdao.create(reservation);
	    
	    
	    //the listing goes to the user's visited history
	    VisitedHistory visit = new VisitedHistory();
	    VisitedHistoryPK visitPK = new VisitedHistoryPK();
	    
	    
	    String sid = "" + listing.getId().getIdlisting();
	    visit.setId(visitPK);
	    visit.setUser(user);
	    visit.setUrl(sid);
	    
	    VisitedHistoryDAOI  visitdao = new VisitedHistoryDAO();
	    visitdao.create(visit);
	    
	    request.getSession().removeAttribute("guests");
	    request.getSession().removeAttribute("arrival");
	    request.getSession().removeAttribute("departure");
	    request.getSession().removeAttribute("listingid");
	    request.getSession().removeAttribute("provname");
	    request.getSession().removeAttribute("price");
	    response.sendRedirect(request.getContextPath());
		
	}

}
