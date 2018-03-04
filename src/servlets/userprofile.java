package servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ListingDAO;
import dao.ListingDAOI;
import dao.UserDAO;
import dao.UserDAOI;
import model.Listing;
import model.User;
import model.VisitedHistory;



/**
 * Servlet implementation class userprofile
 */
@WebServlet("/userprofile")
@MultipartConfig
public class userprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher disp;
		UserDAOI dao = new UserDAO();
		User user; 
		String username;
		if (request.getSession().getAttribute("username") != null) {
			username = (String)request.getSession().getAttribute("username");
			user = dao.findByUsername(username);
			if(user.getType() == 1) {
				username = (String)request.getSession().getAttribute("username");
				user = dao.findByUsername(username);
				if(username.equals("admin")) {
					disp = request.getRequestDispatcher("AdminServlet");
					disp.forward(request,response);
				}
				else {
					//List<VisitedHistory> visits = user.getVisitedHistories();
					request.setAttribute("user", user);
					//request.setAttribute("visits", visits);
					
					disp = getServletContext().getRequestDispatcher("/profile.jsp");
				}
			}
			else {
				username = (String)request.getSession().getAttribute("username");
				user = dao.findByUsername(username);
				if(username.equals("admin")) {
					disp = request.getRequestDispatcher("AdminServlet");
					disp.forward(request,response);
				}
				else {
					request.setAttribute("user", user);
					ListingDAOI listingdao = new ListingDAO();
					List<Listing> results=listingdao.getProviderListing(username);
					request.setAttribute("listingl", results);
					disp = getServletContext().getRequestDispatcher("/providerprofile.jsp");
				}
			}
			
		}
		else {
			disp = getServletContext().getRequestDispatcher("/login.jsp");
		}
		disp.forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp;
		UserDAOI dao = new UserDAO();
		User user; 
		String usernamee = (String)request.getSession().getAttribute("username");
		user = dao.findByUsername(usernamee);
		
		//edit users info
		if(user.getTrn() == null) {
		   	 String firstname = request.getParameter("first_name");
			 if(!firstname.equals("")) {
				 user.setName(firstname);
			 }
			 String lname = request.getParameter("last_name");
			 if(!lname.equals("")) {
			 	user.setSurname(lname);
			 }
			 String email = request.getParameter("email");
			 if(!email.equals("")) {
			 	user.setEmail(email);
			 }
			 String phone = request.getParameter("phone");
			 if(!phone.equals("")) {
			 	user.setTelephone(phone);
			 }
			 String country = request.getParameter("country");
			 if(!country.equals("")) {
			 	user.setCountry(country);
			 }
			 String city = request.getParameter("city");
			 if(!city.equals("")) {
			 	user.setCity(city);
			 }
			 String cell = request.getParameter("cell");
			 if(!cell.equals("")) {
			 	user.setCell(cell);
			 }
			 String username = request.getParameter("username");
			 
			 //change user's profile photo
			 Part filePart = request.getPart("uploadingFile");
			 String savename;
				File path = new File(getServletContext().getInitParameter("photos.location"));
				//long photosMaxSize= Long.parseLong(getServletContext().getInitParameter("photos.maxsize"));
				long photosMaxSize= 7000000;
				String photoName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				if (filePart != null) {
					if (photoName.lastIndexOf(".") != -1) { // No extension.
						String ending = photoName.substring(photoName.lastIndexOf("."));
						long photoSize =filePart.getSize();
						if (ending.equalsIgnoreCase(".png") || ending.equalsIgnoreCase(".jpg") || ending.equals(".jpeg")) {
							if (photoSize <= photosMaxSize) {
								savename = user.getPhoto() + username + ending;
								File photo = new File(path,savename);
								Files.copy(filePart.getInputStream(), photo.toPath());
								user.setPhoto(savename);
							}
						}
					}
				}
			 /*user.setUsername(username);*/
				request.setAttribute("user", user);
				response.sendRedirect("userprofile");
		}
		else {
			//practically the same as above but for a provider,not a simple user
			String firstname = request.getParameter("first_name");
			 if(!firstname.equals("")) {
				 user.setName(firstname);
			 }
			 String lname = request.getParameter("last_name");
			 if(!lname.equals("")) {
			 	user.setSurname(lname);
			 }
			 String email = request.getParameter("email");
			 if(!email.equals("")) {
			 	user.setEmail(email);
			 }
			 String phone = request.getParameter("phone");
			 if(!phone.equals("")) {
			 	user.setTelephone(phone);
			 }
			 String country = request.getParameter("country");
			 if(!country.equals("")) {
			 	user.setCountry(country);
			 }
			 String city = request.getParameter("city");
			 if(!city.equals("")) {
			 	user.setCity(city);
			 }
			 String cell = request.getParameter("cell");
			 if(!cell.equals("")) {
			 	user.setCell(cell);
			 }
			 String trn = request.getParameter("trn");
			 if(!trn.equals("")) {
			 	user.setTrn(trn);
			 }
			 String username = request.getParameter("username");
			 /*user.setUsername(username);*/
			 Part filePart = request.getPart("uploadingFile");
			 String savename;
				File path = new File(getServletContext().getInitParameter("photos.location"));
				//long photosMaxSize= Long.parseLong(getServletContext().getInitParameter("photos.maxsize"));
				long photosMaxSize = 7000000;
				String photoName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
				if (filePart != null) {
					if (photoName.lastIndexOf(".") != -1) { // No extension.
						String ending = photoName.substring(photoName.lastIndexOf("."));
						long photoSize =filePart.getSize();
						if (ending.equalsIgnoreCase(".png") || ending.equalsIgnoreCase(".jpg") || ending.equals(".jpeg")) {
							if (photoSize <= photosMaxSize) {
								savename = user.getPhoto() + username + ending;
								File photo = new File(path,savename);
								Files.copy(filePart.getInputStream(), photo.toPath());
								user.setPhoto(savename);
							}
						}
					}
				}
				request.setAttribute("user", user);
				response.sendRedirect("userprofile");
			
			
		}
		 
	}

}
