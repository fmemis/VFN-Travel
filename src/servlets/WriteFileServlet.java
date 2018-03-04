package servlets;

import java.io.IOException;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;
import java.util.Iterator;
import java.util.List;

import dao.ListingDAO;
import dao.ListingDAOI;
import dao.UserDAO;
import dao.UserDAOI;
import dao.ReviewDAO;
import dao.ReviewDAOI;
import dao.ReservationDAO;
import dao.ReservationDAOI;

import java.util.ArrayList;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Listing;
import model.Review;
import model.User;
import model.Reservation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
/**
 * Servlet implementation class WriteFileServlet
 */
@WebServlet("/WriteFileServlet")
public class WriteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteFileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//generate an xml report
			response.setContentType("text/html");
			RequestDispatcher disp;
			
			UserDAOI dao = new UserDAO();
			List<User> userlist = dao.getUsers(); 
	        ListingDAOI listingdao = new ListingDAO();
			List<Listing> results;
			ReviewDAOI reviewdao = new ReviewDAO();
			List<Review> reviews;
			ReservationDAOI resdao = new ReservationDAO();
			List<Reservation> res;
			
	        response.setContentType("text/xml");
	        String reportName =  "GenerateXML_Report_"
	                +System.currentTimeMillis()+".xml";     
	        response.setHeader("Content-disposition", "attachment; filename=\"" + reportName + "");   

	        ArrayList<String> rows = new ArrayList<String>();
	        rows.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	        rows.add("<Details>");    
	        System.out.println("before users");
	        for (int i = 0; i < userlist.size(); i++) {
	            int j = i+1;
	            System.out.println("in users");
	            rows.add("<User" +(i+1)+ ">");
	            rows.add(userlist.get(i).getUsername());
	            results = listingdao.getProviderListing(userlist.get(i).getUsername());
	            System.out.println(results.size());
	             for (int k = 0; k < results.size(); k++) {
		           // int j = i+1;
	            	System.out.println("in listing");
		            rows.add("<Listingg" +(k+1)+ ">");
		            rows.add(results.get(k).getName());
		            reviews = reviewdao.getReviews(results.get(k).getId().getIdlisting());
		            for (int l = 0; l < reviews.size(); l++) {
			            //int j = i+1;
			            rows.add("<review" +(l+1)+ ">");
			            rows.add((String)reviews.get(l).getText());
			            rows.add("</review" +(l+1)+ ">");

			        }
		            res = resdao.getResarvations(results.get(k).getId().getIdlisting());
		            for (int g = 0; g < res.size(); g++) {
			            //int j = i+1;
			            rows.add("<reservation" +(g+1)+ ">");
			            rows.add((String)res.get(g).getUser().getUsername());
			            rows.add("</reservation" +(g+1)+ ">");

			        }
		            res.clear();
		            reviews.clear();
		            rows.add("</Listingg" +(k+1)+ ">");

		        }
	            results.clear();
	            rows.add("</User" +(i+1)+ ">");
	            

	        }
	        rows.add("</Details>"); 

	        Iterator<String> iter = rows.iterator();
	        while (iter.hasNext()){
	            String outputString = (String) iter.next();
	            response.getOutputStream().print(outputString);
	        }

	        response.getOutputStream().flush();

	    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
