package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListingDAO;
import dao.ListingDAOI;
import dao.UserDAO;
import dao.UserDAOI;
import model.Listing;
import model.User;

/**
 * Servlet implementation class EditRoomServlet
 * Redirects to a page where the provider can change the info of his/her listing
 */
@WebServlet("/EditRoomServlet")
public class EditRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher disp;
		ListingDAOI dao = new ListingDAO();
		Listing listing; 
		String uname = request.getParameter("param1");
		int id = Integer.parseInt(request.getParameter("param2"));
		listing = dao.findById(id, uname);
		out.println("<p>You listing is: " + listing.getDescription() + "</p>");
		
		request.setAttribute("listing", listing);
		request.setAttribute("uname", uname);
		request.setAttribute("id", id);
		
		disp = request.getRequestDispatcher("/EditRoom.jsp");
		disp.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher disp;
		ListingDAOI dao = new ListingDAO();
		Listing listing; 
		String username;
		int id;
		username = request.getParameter("username");
		id = Integer.parseInt(request.getParameter("id"));
		listing = dao.findById(id, username);
		out.println("<p>You listing is: " + username  + "</p>");
		out.println("<p>You listing is: " + id  + "</p>");
		out.println("<p>You listing is: " + listing.getDescription()  + "</p>");
		
		UserDAOI daoo = new UserDAO();
		User user; 
		String usernamee = (String)request.getSession().getAttribute("username");
		user = daoo.findByUsername(usernamee);
		
		String address = request.getParameter("address");
		out.println("<p>You listing is: " + address  + "</p>");
		String area = request.getParameter("area");
		String baths = request.getParameter("baths");
		String beds = request.getParameter("beds");
		String city = request.getParameter("city");
		String dprice = request.getParameter("dprice");
		int airc = Integer.parseInt(request.getParameter("aircondition"));
		int elevator = Integer.parseInt(request.getParameter("elevator"));
		int heat = Integer.parseInt(request.getParameter("heat"));
		String name = request.getParameter("name");
		int kitchen = Integer.parseInt(request.getParameter("kitchen"));
		int parking = Integer.parseInt(request.getParameter("parking"));
		int wifi = Integer.parseInt(request.getParameter("wifi"));
		String size = request.getParameter("size");
		int tv = Integer.parseInt(request.getParameter("tv"));
		String description = request.getParameter("description");
		String latitude = request.getParameter("latitude");
		String longtitude = request.getParameter("longtitude");
		String maxpeople = request.getParameter("maxp");
		String roomsnumber = request.getParameter("roomsnumber");
		int pets = Integer.parseInt(request.getParameter("pets"));
		int roomtype = Integer.parseInt(request.getParameter("rtype"));
		
		if(!address.equals("")) {
			 listing.setAdress(address);
		}
		if(!area.equals("")) {
			 listing.setArea(area);
		}
		if(!baths.equals("")) {
			 listing.setBathsNumber(Integer.parseInt(baths));
		}
		if(!beds.equals("")) {
			 listing.setBedsNumber(Integer.parseInt(beds));
		}
		if(!city.equals("")) {
			 listing.setCity(city);
		}
		if(!dprice.equals("")) {
			 listing.setDailyPrice(Integer.parseInt(dprice));
		}
		
		listing.setAircondition(airc);
		listing.setElevator(elevator);
		listing.setHeating(heat);
		
		if(!name.equals("")) {
			 listing.setName(name);
		}
		
		listing.setKitchen(kitchen);
		listing.setParking(parking);
		listing.setWifi(wifi);
		
		if(!size.equals("")) {
			 listing.setSize(Integer.parseInt(size));
		}
		
		listing.setTv(tv);
		
		if(!description.equals("")) {
			 listing.setDescription(description);
		}
		
		if(!latitude.equals("")) {
			 listing.setLatitude(Float.parseFloat(latitude));
		}
		if(!longtitude.equals("")) {
			 listing.setLongtitude(Float.parseFloat(longtitude));
		}
		if(!maxpeople.equals("")) {
			 listing.setMaxPeople(Integer.parseInt(maxpeople));
		}
		if(!roomsnumber.equals("")) {
			 listing.setRoomsNumber(Integer.parseInt(roomsnumber));
		}
		
		listing.setDogs(pets);
		listing.setType(roomtype);
		
		/*request.setAttribute("user", user);*/
		
		
		//disp = getServletContext().getRequestDispatcher("/providerprofile.jsp");
		//disp.forward(request, response);
		response.sendRedirect("userprofile");


		
	}

}
