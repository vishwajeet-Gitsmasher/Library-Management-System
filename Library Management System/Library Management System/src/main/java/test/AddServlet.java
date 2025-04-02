package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs==null) {
		req.setAttribute("msg", "Session Expired....<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		} else {
		
			BookBean ab = new BookBean();
			ab.setBookId(req.getParameter("id"));
			ab.setBookName(req.getParameter("name"));
			ab.setBookAuthor(req.getParameter("author"));
			if(req.getParameter("price")!=null && req.getParameter("qty")!=null) {
				ab.setBookPrice(Integer.parseInt(req.getParameter("price")));
				ab.setBookQty(Integer.parseInt(req.getParameter("qty")));
				
				int k = new BookDao().addBook(ab);
				if(k>0) {
					PrintWriter pw = res.getWriter();
					res.setContentType("text/html");
					pw.println("Book Added Successfully!!");
					RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
					rd.include(req, res);
				} else {
					PrintWriter pw = res.getWriter();
					res.setContentType("text/html");
					pw.println("Book Adding Failed!! Book ID already exists!!");
					RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
					rd.include(req, res);
				}
			} else {
				PrintWriter pw = res.getWriter();
				pw.println("Some book details are null.");
			}
		}
	}
	
}


