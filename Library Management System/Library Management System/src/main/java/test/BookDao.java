package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao {
	public int addBook(BookBean b) {
		int k = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?,?)");
			ps.setString(1, b.getBookId());
			ps.setString(2, b.getBookName());
			ps.setString(3, b.getBookAuthor());
			ps.setInt(4, b.getBookPrice());
			ps.setInt(5, b.getBookQty());
			k = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}