/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package mytest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TestMysqlCn {
	private static final String JDBC_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String Database_URL = "jdbc:mysql://localhost:3306/blogdb?characterEncoding=UTF-8";

	public static void main(String ivpArgs[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Class.forName(JDBC_DRIVER).newInstance();
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(Database_URL, username, password);
		String sql = "insert into user(firstName,lastName,name,point) values('陆','韩','eric',100)";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println(new Date());
		System.out.println("add user OK!");
		stmt.close();
		showTable(con, "user");
	}

	private static void showTable(Connection con, String tableName) throws SQLException {
		Statement stmt = con.createStatement();
		String query = "select * from " + tableName;
		ResultSet rs = stmt.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		System.out.println("====table " + tableName + "====");
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				String out = rsmd.getColumnName(i);
				if (rs.getString(i) != null)
					out += "=" + rs.getString(i);
				System.out.print(out);// 打印每一列内容
				if (i < columnCount)
					System.out.println(",");
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		rs.close();
		stmt.close();
	}
}
