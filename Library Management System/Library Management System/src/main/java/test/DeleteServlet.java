package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/del")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs==null) {
		req.setAttribute("msg", "Session Expired....<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
		
		
			if(req.getParameter("id")!= null) {
				int k = new DeleteBookDao().deleteBook(req.getParameter("id"));
				if(k>0) {
					PrintWriter pw = res.getWriter();
					res.setContentType("text/html");
					pw.println("Book Deleted Successfully!!");
					RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
					rd.include(req, res);
				} else {
					PrintWriter pw = res.getWriter();
					res.setContentType("text/html");
					pw.println("Book Deletion Failed!! Book ID is not present to delete!!");
					RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
					rd.include(req, res);
				}
			} else {
				PrintWriter pw = res.getWriter();
				pw.println("Book ID is null.");
			}
		}
	}
	
}


