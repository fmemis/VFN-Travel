package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import helpFunctions.Hashing;


import dao.UserDAO;
import dao.UserDAOI;
import model.User;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/Registration")
@MultipartConfig
public class UserRegistrationServlet extends HttpServlet {
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp;
		if(request.getSession().getAttribute("userID") != null){
			// User is already logged in, he can't register another account.
			disp = getServletContext().getRequestDispatcher("/index.jsp");
		}
		else{
			disp = getServletContext().getRequestDispatcher("/signup.jsp");
		}
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String userid_s = request.getParameter("username");
		String password = request.getParameter("pass");
		String passconf = request.getParameter("password_confirmation");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		String cell = request.getParameter("cell");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		Part filePart = request.getPart("uploadingFile");
		
	
		
	
		RequestDispatcher disp;
		if (userid_s.length() == 0 || password.length() == 0 || !password.equals(passconf) ) {
			request.setAttribute("msg","something");
			disp = getServletContext().getRequestDispatcher("/signup.jsp");
			disp.forward(request, response);
			return;
			
		}
				
//			int userid = Integer.parseInt(userid_s);
				
					
		UserDAOI dao = new UserDAO();
					
		// Populate user object.
		User user = new User();
		User user2 = null;
		user2 = dao.findByUsername(userid_s);
		if(user2 != null) {
			request.setAttribute("msg","username allready exists");
			request.setAttribute("username", userid_s);
			request.setAttribute("password", password);
			request.setAttribute("passc", passconf);
			request.setAttribute("name", name);
			request.setAttribute("surname", surname);
			request.setAttribute("city", city);
			request.setAttribute("country", country);
			request.setAttribute("cell", cell);
			request.setAttribute("telephone", telephone);
			request.setAttribute("email", email);
			disp = getServletContext().getRequestDispatcher("/signup.jsp");
			disp.forward(request, response);
		}
		
		
		
		
		String hpassword = Hashing.hash(password); //hash the password for security reasons.
		user.setPassword(hpassword);
		user.setUsername(userid_s);
		user.setCell(cell);
		user.setCity(city);
		user.setEmail(email);
		user.setCountry(country);
		user.setName(name);
		user.setSurname(surname);
		user.setTelephone(telephone);
		user.setType(1);
		String savename;
		
		//save the user's profile photo.
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
						savename = userid_s + ending;
						File photo = new File(path,savename);
						Files.copy(filePart.getInputStream(), photo.toPath());
						user.setPhoto(savename);
					}
				}
			}
		}
		
		dao.create(user);
		
		disp = getServletContext().getRequestDispatcher("/index.jsp");
		disp.forward(request, response);
					

	}
}

