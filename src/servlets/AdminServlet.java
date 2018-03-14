package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dao.UserDAOI;

import java.util.List;
import model.User;
/**
 * Servlet implementation class AdminServlet
 * Sets the necessary attributes for admin page
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 RequestDispatcher disp;   

	     UserDAOI dao = new UserDAO();
	     String username = (String)request.getSession().getAttribute("username");
	     User user = dao.findByUsername(username);
			
	     List<User> userlist = dao.getUsers();
	     
	    request.setAttribute("user", user);
		request.setAttribute("users", userlist);
		disp = getServletContext().getRequestDispatcher("/AdminPage.jsp");
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
