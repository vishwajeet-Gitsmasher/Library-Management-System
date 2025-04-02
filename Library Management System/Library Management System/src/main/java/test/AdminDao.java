package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	public int reg(AdminBean ab) {
		int k = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO ADMINS VALUES(?,?,?,?,?,?)");
			ps.setString(1, ab.getName());
			ps.setString(2, ab.getPass());
			ps.setString(3, ab.getFname());
			ps.setString(4, ab.getLname());
			ps.setString(5, ab.getMail());
			ps.setString(6, ab.getPhno());
			k = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}

/*
CREATE TABLE ADMINS(
	NAME VARCHAR2(20) PRIMARY KEY,
	PASS VARCHAR2(20),
	FNAME VARCHAR2(20),
	LNAME VARCHAR2(20),
	MAIL VARCHAR2(20),
	PHNO VARCHAR2(20));
*/