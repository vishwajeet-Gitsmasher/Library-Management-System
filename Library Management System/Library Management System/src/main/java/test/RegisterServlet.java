package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/registeradmin")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        // Collecting form data
        AdminBean ab = new AdminBean();
        ab.setName(req.getParameter("name"));
        ab.setPass(req.getParameter("pass"));
        ab.setFname(req.getParameter("fname"));
        ab.setLname(req.getParameter("lname"));
        ab.setMail(req.getParameter("mail"));
        ab.setPhno(req.getParameter("ph"));

        // Calling DAO to register
        int k = new AdminDao().reg(ab);

        // Set response type and create a single PrintWriter
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        // Output message
        if (k > 0) {
        	pw.println("<div style=\""
        	        + "background: linear-gradient(135deg, #28a745, #218838);"
        	        + "color: white;"
        	        + "text-align: center;"
        	        + "font-size: 28px;"
        	        + "padding: 10px;"
        	        + "border-radius: 12px;"
        	        + "box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);"
        	        + "margin: 20px;"
        	        + "max-width: 500px;\">"
        	        + "✅ Admin Registered Successfully!"
        	        + "</div>");

        } else {
            pw.println("<h1>Admin Registration Failed!! Admin name already exists!!</h1>");
        }

        // Include home.html in both cases
        RequestDispatcher rd = req.getRequestDispatcher("login.html");
        rd.include(req, res);
        
        // Close the PrintWriter
        pw.close();
    }
}
