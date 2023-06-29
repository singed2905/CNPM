package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	private static String DB_URL = "jdbc:mysql://localhost:3306/QLKHACHSAN";
    private static String USER = "root";
	private static String PASS = "123456";
	private static Connection connection;
	public static Connection getConnection() {
		
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(DB_URL,USER,PASS);
				} catch (ClassNotFoundException  | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}						
				return connection;
	}
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}  
	public static void main(String[] args) {
		System.out.println(JDBCUtil.getConnection());
	}
}
