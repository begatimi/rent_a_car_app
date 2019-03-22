package java_6;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqlFiekDBconnect {

	Connection conn = null;
	
	public static Connection connectFiekDb() {
		try {
			//merret driveri per lidhje
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/dbfiekgrupi2","root","toor");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
			return null;
		}
	}
}
