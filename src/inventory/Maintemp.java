package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

 

public class Maintemp {
  // Connection connection=null;
   public static Connection dbConnector()
   {
 
	   
	   Connection connection = null;
	    java.sql.Statement statement = null;
	    
	 
	    try {
	    	String myConnectionString =
			        "jdbc:mysql://localhost:3307?" +
			        "useUnicode=yes&characterEncoding=UTF-8";
		 Connection dbConnection = DriverManager.getConnection(myConnectionString, "root", "");
		 
		      JOptionPane.showMessageDialog(null,"Successfull");
	 
	   } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null,"Sorry Can't Connect to database");
		      e.printStackTrace();
		    }
	return connection;
   }
}
