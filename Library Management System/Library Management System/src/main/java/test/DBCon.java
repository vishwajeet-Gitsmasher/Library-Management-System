package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBCon {
	public static Connection getConnection() {
		Connection con = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","VISHWAJEET","123");
			Statement stm = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
