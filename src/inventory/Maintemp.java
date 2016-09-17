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
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      String url = "jdbc:mysql://localhost:3306";
		      connection = DriverManager.getConnection(url, "root", "");
		      JOptionPane.showMessageDialog(null,"Successfull");
	 
	   } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null,"Sorry Can't Connect to database");
		      e.printStackTrace();
		    }
	return connection;
  
   }
}
