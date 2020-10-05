package test;
import java.sql.*;

public class DBConnection {
	private static Connection con;
	private DBConnection() {}
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "manager");
		}//end of try
		catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	public static Connection getCon() {
		return con;
	}
	}


