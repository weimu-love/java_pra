package cherry.pra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Mysql_pra {

	public static void main(String[] args) {
//		后面的两个参数表示不使用SSL加密，使用UTF-8作为字符编码（注意MySQL的UTF-8是utf8）。
		String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc?useSSL=false&characterEncoding=utf8";

		String JDBC_USER = "root";
		String JDBC_PASSWORD = "root";
		/*
		 * // 因为JDBC连接是一种昂贵的资源，所以使用后要及时释放。使用try (resource)来自动释放JDBC连接 try (Connection
		 * conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
		 * 
		 * // Statment和ResultSet都是需要关闭的资源，因此嵌套使用try (resource)确保及时关闭； try (Statement
		 * stmt = conn.createStatement()) { try (ResultSet rs = stmt.
		 * executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1"))
		 * {
		 * 
		 * // rs.next()用于判断是否有下一行记录，如果有，将自动把当前行移动到下一行（一开始获得ResultSet时当前行不是第一行）； //
		 * System.out.println(rs.getString(3)); while (rs.next()) { //
		 * ResultSet获取列时，索引从1开始而不是0； //
		 * 必须根据SELECT的列的对应位置来调用getLong(1)，getString(2)这些方法，否则对应位置的数据类型不对，将报错。 long id =
		 * rs.getLong(1); long grade = rs.getLong(2); String name = rs.getString(3); int
		 * gender = rs.getInt(4); System.out.println(name); } } } } catch (SQLException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		
//		使用PreparedStatement可以完全避免SQL注入的问题
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
		    try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
		        ps.setObject(1, 0); // 注意：索引从1开始
		        ps.setObject(2, 3);
		        try (ResultSet rs = ps.executeQuery()) {
		            while (rs.next()) {
		                long id = rs.getLong("id");
		                long grade = rs.getLong("grade");
		                String name = rs.getString("name");
		                String gender = rs.getString("gender");
		                System.out.println(name);
		            }
		        }
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
