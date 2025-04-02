package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateBookDao {
	public int updateBook(BookBean b) {
		int k = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE BOOKS SET BOOKNAME = ?,BOOKAUTHOR=?,BOOKPRICE=?, BOOKQTY=? WHERE BOOKID = ?");
			ps.setString(5, b.getBookId());
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getBookAuthor());
			ps.setInt(3, b.getBookPrice());
			ps.setInt(4, b.getBookQty());
			k = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}