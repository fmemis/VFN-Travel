package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListingDAO;
import dao.ListingDAOI;
import dao.SearchParams;
import dao.SearchOptions;
import model.Listing;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(urlPatterns = {"/Search", "/SearchFilters"})
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int searchResultsPerPage = 10;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url_path = request.getRequestURI().substring(request.getContextPath().length());
		if (url_path.equals("/Search")) {
			doPost(request, response);
		}
		else
			searchFilters(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//This method is called from the homepage.
		RequestDispatcher disp;
		SearchOptions options = new SearchOptions();
		SearchParams params = new SearchParams();
		
		String city = request.getParameter("City");
		String arrival = request.getParameter("arrival");
		String departure = request.getParameter("departure");
		String guests = request.getParameter("guests");
		
		if(guests != null && !guests.equals("")){
			int guestNumber = Integer.parseInt(guests);
			params.setGuests(guestNumber);
		}
		
		if(city != null && !city.equals("")){
			params.setLocation(city);
		}
		
		//convert the dates into a form which can be used in a sql query
		if(arrival != null && !arrival.equals("") && departure != null && !departure.equals("")) {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		    Date parsedate = null;
			try {
				parsedate = format.parse(arrival);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    java.sql.Date start = new java.sql.Date(parsedate.getTime());
			
		    Date parsedate2 = null;
			try {
				parsedate2 = format.parse(departure);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    java.sql.Date end = new java.sql.Date(parsedate2.getTime());
		    
		    params.setDates(start, end);
		}
		
		//results pagination
		String pageStr = request.getParameter("page");
		
		int page = 0;
		
		if(pageStr != null){
			try{
				page = Integer.parseInt(pageStr);
			}
			catch (NumberFormatException e){}
		}
		
		if(page < 0){
			page = 0;
		}
		
		ListingDAOI listingdao = new ListingDAO();
		//return the appropriate results according to the page.
		List<Listing> results=listingdao.search(params ,page, searchResultsPerPage);
		
		boolean has_next_page = false;
		boolean has_prev_page = false;
		
		if (listingdao.search(params , ((page + 1) * searchResultsPerPage), 1).size() > 0){
			has_next_page = true;
		}
		else {
			has_next_page = false;
		}
		
		if (page != 0){
			has_prev_page = true;
		}
		else {
			has_prev_page = false;
		}
		
		//set the necessary attributes to present the results
		request.setAttribute("searchResults", results);
		request.setAttribute("nextPage", has_next_page);
		request.setAttribute("prevPage", has_prev_page);
		request.setAttribute("currentPage", page);
		request.setAttribute("City", city);
		request.setAttribute("arrival", arrival);
		request.setAttribute("departure", departure);
		request.setAttribute("guests", guests);
		request.setAttribute("options", options);
		
		disp = getServletContext().getRequestDispatcher("/search.jsp");
		disp.forward(request, response);
	}
	
	protected void searchFilters(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//this method is called from the search results page when the user applies filters
		RequestDispatcher disp;
		String trial = request.getParameter("trial");
		String city = request.getParameter("City");
		String arrival = request.getParameter("arrival");
		String departure = request.getParameter("departure");
		String guests = request.getParameter("guests");
		SearchOptions options = new SearchOptions();
		SearchParams params = new SearchParams();
		options.setPrice1(Integer.parseInt(request.getParameter("price1")));
		options.setPrice2(Integer.parseInt(request.getParameter("price2")));
		options.setPrice3(Integer.parseInt(request.getParameter("price3")));
		options.setPrice4(Integer.parseInt(request.getParameter("price4")));
		options.setPrice5(Integer.parseInt(request.getParameter("price5")));
		options.setPrice6(Integer.parseInt(request.getParameter("price6")));
		options.setPrice7(Integer.parseInt(request.getParameter("price7")));
		options.setAircondition(Integer.parseInt(request.getParameter("aircondition")));
		options.setApartment(Integer.parseInt(request.getParameter("apartment")));
		options.setBungalow(Integer.parseInt(request.getParameter("bungalow")));
		options.setHeating(Integer.parseInt(request.getParameter("heating")));
		options.setHotel(Integer.parseInt(request.getParameter("hotel")));
		options.setParking(Integer.parseInt(request.getParameter("parking")));
		options.setStudio(Integer.parseInt(request.getParameter("studio")));
		options.setVilla(Integer.parseInt(request.getParameter("villa")));
		options.setWifi(Integer.parseInt(request.getParameter("wifi")));
		
		if(guests != null && !guests.equals("")){
			int guestNumber = Integer.parseInt(guests);
			params.setGuests(guestNumber);
		}
		
		if(city != null && !city.equals("")){
			params.setLocation(city);
		}
		
		//convert the dates into a form which can be used in a sql query
		if(arrival != null && !arrival.equals("") && departure != null && !departure.equals("")) {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		    Date parsedate = null;
			try {
				parsedate = format.parse(arrival);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    java.sql.Date start = new java.sql.Date(parsedate.getTime());
			
		    Date parsedate2 = null;
			try {
				parsedate2 = format.parse(departure);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    java.sql.Date end = new java.sql.Date(parsedate2.getTime());
		    
		    params.setDates(start, end);
		}
		
		
		//results pagination
		String pageStr = request.getParameter("page");
		
		int page = 0;
		
		if(pageStr != null){
			try{
				page = Integer.parseInt(pageStr);
			}
			catch (NumberFormatException e){}
		}
		
		if(page < 0){
			page = 0;
		}
		
		ListingDAOI listingdao = new ListingDAO();
		//return the appropriate results according to the page.
		List<Listing> results=listingdao.search(params ,options,page, searchResultsPerPage);
		
		boolean has_next_page = false;
		boolean has_prev_page = false;
		
		if (listingdao.search(params ,  ((page + 1) * searchResultsPerPage), 1).size() > 0){
			has_next_page = true;
		}
		else {
			has_next_page = false;
		}
		
		if (page != 0){
			has_prev_page = true;
		}
		else {
			has_prev_page = false;
		}
		
		request.setAttribute("searchResults", results);
		request.setAttribute("nextPage", has_next_page);
		request.setAttribute("prevPage", has_prev_page);
		request.setAttribute("currentPage", page);
		request.setAttribute("City", city);
		request.setAttribute("arrival", arrival);
		request.setAttribute("departure", departure);
		request.setAttribute("guests", guests);
		//request.setAttribute("airc", "a");
		request.setAttribute("options", options);
		
		if (options.getAircondition() == 1)
			request.setAttribute("airc", "a");
		if (options.getApartment() == 1)
			request.setAttribute("apart", "a");
		if (options.getBungalow() == 1)
			request.setAttribute("bung", "a");
		if (options.getHeating() == 1)
			request.setAttribute("heat", "a");
		if (options.getHotel() == 1)
			request.setAttribute("hot", "a");
		if (options.getParking() == 1)
			request.setAttribute("park", "a");
		if (options.getPrice1() == 1)
			request.setAttribute("pr1", "a");
		if (options.getPrice2() == 1)
			request.setAttribute("pr2", "a");
		if (options.getPrice3() == 1)
			request.setAttribute("pr3", "a");
		if (options.getPrice4() == 1)
			request.setAttribute("pr4", "a");
		if (options.getPrice5() == 1)
			request.setAttribute("pr5", "a");
		if (options.getPrice6() == 1)
			request.setAttribute("pr6", "a");
		if (options.getPrice7() == 1)
			request.setAttribute("pr7", "a");
		if (options.getStudio() == 1)
			request.setAttribute("st", "a");
		if (options.getVilla() == 1)
			request.setAttribute("vil", "a");
		if (options.getWifi() == 1)
			request.setAttribute("wi", "a");
		
		disp = getServletContext().getRequestDispatcher("/search.jsp");
		disp.forward(request, response);
	}

}
