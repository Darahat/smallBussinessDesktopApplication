package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Main {
       Connection conn=null;
       public static Connection dbConnector()
	{
		try{
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

		Connection conn=DriverManager.getConnection("jdbc:derby:teastall;create=true");
		return conn;
		}
		catch(Exception e){
	//	Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
				JOptionPane.showMessageDialog(null,"Sorry. can't connect to database");
			return null;
			
		}
}}