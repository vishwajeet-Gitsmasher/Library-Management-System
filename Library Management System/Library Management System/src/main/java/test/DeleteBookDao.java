package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteBookDao {
	public int deleteBook(String bookId) {
		int k = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM BOOKS WHERE BOOKID = ?");
			ps.setString(1, bookId);
			k = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}