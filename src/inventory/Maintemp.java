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
 
	   Connection connection = null;
	    java.sql.Statement statement = null;
	    
	 
	    try {
		      Class.forName("com.apache.derby.jdbc.ClientDriver").newInstance();
		      String url = "jdbc:derby://localhost:1527/teastall;create=true";
		      connection = DriverManager.getConnection(url, "root", "");
		      JOptionPane.showMessageDialog(null,"Successfull");
	 
	   } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null,"Sorry Can't Connect to database");
		      e.printStackTrace();
		    }
	return connection;
  
   }
}
