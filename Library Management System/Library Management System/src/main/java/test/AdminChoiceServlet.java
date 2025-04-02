package test;
import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/Admindis")
public class AdminChoiceServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String choice = req.getParameter("sb");
		if(choice.equals("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/AddBook.html");
			rd.forward(req, res);
		} 
		
		else if (choice.equals("delete")) {
			RequestDispatcher rd = req.getRequestDispatcher("/DeleteBook.html");
			rd.forward(req, res);
		} 
		
		
		else if (choice.equals("update")) {
			RequestDispatcher rd = req.getRequestDispatcher("/UpdateBook.html");
			rd.forward(req, res);
		} 
		
		else if (choice.equals("view")) {
			RequestDispatcher rd = req.getRequestDispatcher("ViewAllBook");
			rd.forward(req, res);
		}
		
		else if(choice.equals("logout")) {
			HttpSession h = req.getSession(false);  // Get the current session, don't create a new one
		    if (h != null) {
		        h.invalidate();  // Invalidate session if it exists
		    }
		    RequestDispatcher rd = req.getRequestDispatcher("/login.html");
		    rd.include(req,res); 
		}
		
	}
	
}



/*
CREATE TABLE BOOKS(
	BOOKID VARCHAR2(3) PRIMARY KEY,
	BOOKNAME VARCHAR2(10),
	BOOKAUTHOR VARCHAR2(10),
	BOOKPRICE NUMBER(6),
	BOOKQTY NUMBER(5)
);

*/