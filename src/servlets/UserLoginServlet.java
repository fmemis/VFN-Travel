package servlets;

import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;
import helpFunctions.Hashing;
import jpautils.EntityManagerHelper;
import dao.UserDAO;
import dao.UserDAOI;
import model.Listing;
import model.Review;
import model.User;
import model.VisitedHistory;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/Login")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
			// User is already logged in, prevent him from double-logging.
			disp = getServletContext().getRequestDispatcher("/already_logged.jsp");
		} else {
			disp = getServletContext().getRequestDispatcher("/index.jsp");
		}
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher disp;
		if (username.length() == 0 || password.length() == 0 ) {
			request.setAttribute("msg","Wrong username or password");
			disp = getServletContext().getRequestDispatcher("/index.jsp");
			disp.forward(request, response);
			return;
			
		}
		
		UserDAOI dao = new UserDAO();
		User user = dao.findByUsername(username);
		String hpassword = Hashing.hash(password);
		if (user != null) {
			if (hpassword.equals(user.getPassword())) {
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("usertype", user.getType());
				if(!request.getParameter("listid").equals("") && request.getParameter("listid")!= null ) {
					disp = getServletContext().getRequestDispatcher("/Listing?listingid="+request.getParameter("listid")+"&provname="+request.getParameter("listprov"));
					disp.forward(request, response);
				}
				else {
					
					EntityManager em = EntityManagerHelper.getEntityManager();
					disp = getServletContext().getRequestDispatcher("/index.jsp");
					disp.forward(request, response);
				}
			}
			else {
				request.setAttribute("msg","Wrong username or password");
				if(!request.getParameter("listid").equals("") && request.getParameter("listid")!= null ) {
					request.setAttribute("listid", request.getParameter("listid"));
					request.setAttribute("listprov", request.getParameter("listprov"));
					request.setAttribute("Attrneeded", "something");
					disp = getServletContext().getRequestDispatcher("/Listing");
					disp.forward(request, response);
				}
				else {
					disp = getServletContext().getRequestDispatcher("/index.jsp");
					disp.forward(request, response);
				}
			}
		}
		
		
	}

}


