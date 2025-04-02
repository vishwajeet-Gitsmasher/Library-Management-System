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
@WebServlet("/update")
public class UpdateBookServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs==null) {
		req.setAttribute("msg", "Session Expired....<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {

			if(req.getParameter("id")!= null) {
				BookBean ab = new BookBean();
				ab.setBookId(req.getParameter("id"));
				ab.setBookName(req.getParameter("name"));
				ab.setBookAuthor(req.getParameter("author"));
				if(req.getParameter("price")!=null && req.getParameter("qty")!=null) {
					ab.setBookPrice(Integer.parseInt(req.getParameter("price")));
					ab.setBookQty(Integer.parseInt(req.getParameter("qty")));
					
					int k = new UpdateBookDao().updateBook(ab);
					if(k>0) {
						PrintWriter pw = res.getWriter();
						res.setContentType("text/html");
						pw.println("Book Updated Successfully!!");
						RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
						rd.include(req, res);
					} else {
						PrintWriter pw = res.getWriter();
						res.setContentType("text/html");
						pw.println("Book Updation Failed!! Book ID does not exist!!");
						RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
						rd.include(req, res);
					}
				} else {
					PrintWriter pw = res.getWriter();
					pw.println("Book price or qty is null.");
				}
			} else {
				PrintWriter pw = res.getWriter();
				pw.println("Book ID is null.");
			}
		}
	}
	
}


