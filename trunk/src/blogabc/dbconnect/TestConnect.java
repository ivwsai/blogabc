package blogabc.dbconnect;

import java.sql.*;

public class TestConnect {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	public static void main(String[] ss) throws SQLException {

		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/blogdb?user=root&password=root&useUnicode=true&characterEncoding=UTF-8";

			conn = DriverManager.getConnection(url);

			String sql = "select * from user";
			sql = "select * from User";
			
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
		}

		catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
}
