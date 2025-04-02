package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpServletRequest;

public class CustomerLoginDao {

	public CustomerBean login(HttpServletRequest req) {
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMERS WHERE CUSTOMERID = ? AND CUSTOMERNAME = ?");
			ps.setString(1, req.getParameter("cid"));
			ps.setString(2, req.getParameter("cname"));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				CustomerBean cb = new CustomerBean();
				cb.setCustomerId(rs.getInt(1));
				cb.setCustomerName(rs.getString(2));
				cb.setDob(rs.getString(3));
				cb.setGender(rs.getString(4));
				cb.setAddress(rs.getString(5));
				cb.setPhone(rs.getString(6));
				cb.setPhone(rs.getString(7));
				return cb;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
