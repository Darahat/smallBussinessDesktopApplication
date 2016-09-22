package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

 

public class Maintemp {
  // Connection connection=null;
   public static Connection dbConnector()
   {
	    
	 
	    try {
		      Class.forName("org.sqlite.JDBC");
		     Connection conn=DriverManager.getConnection("jdbc:sqlite:C:/Users/Didarul Alam Rahat/workspace1/inventory/teastall.sqlite");
		    //  connection = DriverManager.getConnection(url, "root", "");
		      JOptionPane.showMessageDialog(null,"Successfull");
	 return conn;
	   } catch (Exception e) {
	//	    	JOptionPane.showMessageDialog(null,"Sorry Can't Connect to database");
		      e.printStackTrace();
	    return null;
	   }
	
}}