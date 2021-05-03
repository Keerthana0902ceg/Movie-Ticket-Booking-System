import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MainClass {
	static final String DB_URL = "jdbc:oracle:thin:@//localhost/oracle";

	  static final String USER = "java_project";
	  static final String PASS = "pass";
	public static void main(String args[])  {
		new FrontPage();
	}
}
