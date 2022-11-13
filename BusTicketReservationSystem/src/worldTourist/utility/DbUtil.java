package worldTourist.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtil {
	private static String username;
	private static String password;
	
	static {
		
		ResourceBundle rb= ResourceBundle.getBundle("dbdetails");
		
		rb.getString("db.url");
		rb.getString("db.drivername");
		username= rb.getString("db.username");
		password= rb.getString("db.password");
		
		
		
	}
	public static Connection provideConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/projectSB101";
	try {
		conn=	DriverManager.getConnection(url,username,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return conn;
	}
	
	
}
