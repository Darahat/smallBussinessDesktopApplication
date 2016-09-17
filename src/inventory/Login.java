package inventory;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con=null;
	public Login() {
		setTitle("S.S.R.M COFFEE HOUSE");
		con=Main.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\photo.jpg.png"));
		lblNewLabel.setBounds(10, 11, 331, 370);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(510, 67, 165, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setForeground(new Color(160, 82, 45));
		lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		lblNewLabel_1.setBounds(391, 69, 114, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(160, 82, 45));
		lblPassword.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
		lblPassword.setBounds(391, 159, 114, 31);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(510, 157, 165, 36);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String query="SELECT * FROM login WHERE Username=? and Password=? ";		
				 
			    
				
				try {
				PreparedStatement pst=con.prepareStatement(query);
			 	pst.setString(1, textField.getText());
			    pst.setString(2, passwordField.getText());
			    ResultSet rs=pst.executeQuery();
			    int count=0;
			    while(rs.next())
			    {
			    	count=count+1;
			    }
			    if(count==1){
			    	
			    	ssrmAdmin ssad=new ssrmAdmin();
			    	ssad.setVisible(true);
			    	 dispose();
			    }
			    else
			    {
			    	JOptionPane.showMessageDialog(null, "Username and Password is not correct try again");
			    	
			    }
			    rs.close();
			    pst.close();
			    
			 		} catch (SQLException e) {
				// TODO Auto-generated catch block
		        JOptionPane.showMessageDialog(null, "Wrong password or user name.Please Stop trying and Contact to Develper to get your username and password");
		        e.printStackTrace();
			 		}
			 		 finally{
					    	try{
					    		
					    	}
					    	catch(Exception e)
					    	{
					    		JOptionPane.showMessageDialog(null, e);
					    	}
					    }
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Script MT Bold", Font.BOLD, 23));
		btnNewButton.setBounds(511, 273, 164, 36);
		contentPane.add(btnNewButton);
	}
}
