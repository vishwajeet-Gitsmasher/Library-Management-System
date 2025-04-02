package test;


import java.sql.*;

import jakarta.servlet.http.HttpServletRequest;

public class LoginDao {
	public AdminBean login(HttpServletRequest req)  {
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ADMINS WHERE name=? AND pass=?");
			ps.setString(1, req.getParameter("name"));
			ps.setString(2, req.getParameter("pass"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AdminBean ab = new AdminBean();
				ab.setName(rs.getString(1));
				ab.setPass(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setMail(rs.getString(5));
				ab.setPhno(rs.getString(6));
				return ab;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
