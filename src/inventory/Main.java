package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Main {
       Connection conn=null;
	public static Connection dbConnector()
	{
		try{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/teastall","root","");
	  
		return conn;
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Sorry. can't connect to database");
			return null;
			
		}
}}