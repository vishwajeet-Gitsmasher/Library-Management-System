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

@WebServlet("/Buybook")
public class BuyBookServlet extends HttpServlet{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        processRequest(req, res);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession(false);//Accessing Existing Session
		if(hs==null) {
			req.setAttribute("msg", "Session Expired....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String id = req.getParameter("id");
			String bookName = req.getParameter("name");
			int price = Integer.parseInt(req.getParameter("price"));
			req.setAttribute("id", id);
			req.setAttribute("bookName", bookName);
			req.setAttribute("price", price);
			RequestDispatcher rd = req.getRequestDispatcher("Bill.jsp");
			rd.forward(req, res);
	
		}
	}
}
