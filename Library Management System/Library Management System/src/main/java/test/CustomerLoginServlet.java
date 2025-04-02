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
@WebServlet("/customerlogin")
public class CustomerLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        CustomerBean cb = new CustomerLoginDao().login(req);

        if (cb != null) {
            HttpSession hs = req.getSession();
            hs.setAttribute("cbean", cb);  // Store customer bean in session
            req.setAttribute("message", "Customer Login Successful.");
            req.setAttribute("custname", cb.getCustomerName());

            RequestDispatcher rd = req.getRequestDispatcher("customerloginsuccess.jsp");
            rd.forward(req, res);
        } else {
        	PrintWriter pw = res.getWriter();
        	res.setContentType("text/html");
	        pw.println("<h2>Login Failed due to wrong <br> name or password!</h2>");
            RequestDispatcher rd = req.getRequestDispatcher("customerlogin.html");
            rd.include(req, res);
        }
    }
}
