package servlets;

import java.io.IOException;


import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import helpFunctions.Hashing;
import jpautils.EntityManagerHelper;
import dao.UserDAO;
import dao.UserDAOI;
import model.User;

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


