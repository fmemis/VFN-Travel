package servlets;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 * This servlet exists in order to be able to serve photos dynamically.
 */
@WebServlet("/image/*")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = URLDecoder.decode(request.getPathInfo().substring(1), "UTF-8"); // Get parameter from url.

		
		File file = new File(getServletContext().getInitParameter("photos.location"), fileName); // File location on disk.
		
		// Serve file.
		response.setHeader("Content-Type", getServletContext().getMimeType(fileName));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
		try{
			Files.copy(file.toPath(), response.getOutputStream());
		}
		catch(IOException e){
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/404.html");
			disp.forward(request, response);
		}
		catch(Exception e){
			// We display 404 on other exceptions too, but we log the error.
			e.printStackTrace(System.err);
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/404.html");
			disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
