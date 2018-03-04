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
 * Servlet implementation class AcceptProviderServlet
 * Admin allows a new provider full access to the provider capabilities
 */
@WebServlet("/AcceptProviderServlet")
public class AcceptProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptProviderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp;
		UserDAOI dao = new UserDAO();
		User user1; 
		String uname = request.getParameter("param1");
		user1 = dao.findByUsername(uname);
		user1.setType(2);
		disp = request.getRequestDispatcher("AdminServlet");
		disp.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
