package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    AdminBean ab = new LoginDao().login(req);

	    if (ab != null) {
	        HttpSession hs = req.getSession();  // Creating new session
	        hs.setAttribute("abean", ab);       // AdminBean is added to the session
	        RequestDispatcher rd = req.getRequestDispatcher("loginsuccess.jsp");
	        rd.forward(req, res);
	    } else {
	        // Store the error message as a request attribute
	        //req.setAttribute("errorMessage", "Login failed due to wrong name or password!");
	        PrintWriter pw = res.getWriter();
	        pw.println("<h1>Login Failed due to wrong name or password!</h1>");
	        // Forward the request to the login page
	        RequestDispatcher rd = req.getRequestDispatcher("login.html");
	        rd.include(req, res);
	    }
	}

}


