package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViewAllBookDao {
	public List<List<String>> viewAllBook() {
		List<List<String>> res = new ArrayList<>();
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BOOKS");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				List<String> temp = new ArrayList<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(Integer.toString(rs.getInt(4)));
				temp.add(Integer.toString(rs.getInt(5)));
				res.add(temp);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}