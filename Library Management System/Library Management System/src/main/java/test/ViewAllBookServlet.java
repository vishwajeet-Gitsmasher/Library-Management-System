package test;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/ViewAllBook")
public class ViewAllBookServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs==null) {
		req.setAttribute("msg", "Session Expired....<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
		
			List<List<String>> listOfBooks = new ViewAllBookDao().viewAllBook();
			req.setAttribute("list", listOfBooks);
			RequestDispatcher rd = req.getRequestDispatcher("DisplayBooks.jsp");
			rd.forward(req, res);
		}
		
	}
	
}