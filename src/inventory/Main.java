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
		
			Class.forName("org.sqlite.JDBC");

		Connection conn=DriverManager.getConnection("jdbc:sqlite:C:/Users/Didarul Alam Rahat/workspace1/inventory/teastall.sqlite");
	//	Connection conn=DriverManager.getConnection("jdbc:sqlite:teastall.sqlite"); 
	//	JOptionPane.showMessageDialog(null,"connected to database");
		return conn;
		}
		catch(Exception e){
	//	Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,e);
				JOptionPane.showMessageDialog(null,"Sorry. can't connect to database");
			return null;
			
		}
}}