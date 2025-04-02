package test;
import java.io.IOException;
import java.io.PrintWriter;

import java.net.http.HttpRequest;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerregister")
public class CustomerRegisterServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		CustomerBean cb = new CustomerBean(name, dob, gender, address, phone, email);
		
		int k = new CustomerRegisterDao().addCustomer(cb);

		if(k>0) {
			req.setAttribute("custname", cb.getCustomerName());
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.println("<br><h2> Customer Registered Successfully.</h2>");
			pw.println("<h2>Your Customer ID is :"+cb.getCustomerId()+" </h2><br>");
			RequestDispatcher rd = req.getRequestDispatcher("customerlogin.html");
			rd.include(req, res);
		} else {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");
			pw.println("<h1>Customer Registration Failed.</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("customer_register.html");
			rd.include(req, res);
		}
	}
}
