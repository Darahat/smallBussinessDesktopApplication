package inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Component;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;

 

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class ssrmAdmin extends JFrame {

	private JPanel contentPane;
	private JTable DailySelltable;
	private JTable Monthlyselltable;
	private JTextField date;
	Connection con=null;
    Connection connectoin=null;
	JComboBox comboBoxmonth = new JComboBox();
	private JTextField sell;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ssrmAdmin frame = new ssrmAdmin();
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
	 public void refreshtable()
	 {
		 
		 try{
	     	 	connectoin=Main.dbConnector();
					Object item = comboBoxmonth.getSelectedItem();
					//	String value = ((JComboBox)item).;
						String query = null;
				 
					if (item=="January")
					{
						query="select * from january";
				 	}
					if (item=="February")
					{
						query="select * from february";
				 	}
					if (item=="March")
					{
						query="select * from march";
				 	}
					if (item=="April")
					{
						query="select * from april";
				 	}
					if (item=="May")
					{
						query="select * from may";
				 	}
					if (item=="June")
					{
						query="select * from june";
				 	}
					if (item=="July")
					{
						query="select * from july";
				 	}
					if (item=="August")
					{
						query="select * from august";
				 	}
					if (item=="September")
					{
						query="select * from september";
				 	}
					if (item=="October")
					{
						query="select * from october";
				 	}
					if (item=="November")
					{
						query="select * from november";
				 	}
					if (item=="December")
					{
						query="select * from december";
				 	}
					
				
				 PreparedStatement pst=connectoin.prepareStatement(query);
			     ResultSet rs=pst.executeQuery();
			     DailySelltable.setModel(DbUtils.resultSetToTableModel(rs));
			     
			}
				catch(Exception e1){
					e1.printStackTrace();
					 JOptionPane.showMessageDialog(null,"can't");
					 }
      try{
   	   String query="select * from year";
			PreparedStatement pst=connectoin.prepareStatement(query);
		     ResultSet rs=pst.executeQuery();
		     Monthlyselltable.setModel(DbUtils.resultSetToTableModel(rs));
		}
			catch(Exception e1){
				e1.printStackTrace();
				 JOptionPane.showMessageDialog(null,"can't");
				 }
		} 
	 

	public ssrmAdmin() {
	 
		try {
			con=Main.dbConnector();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} 
		setBackground(new Color(255, 255, 204));
		setTitle("S.R.R.M COFFEE HOUSE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-108, -60, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 250, 205));
		setJMenuBar(menuBar);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmAdministration = new JMenuItem("Administration");
		mntmAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
			}
		});
		mnView.add(mntmAdministration);
		
		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ssrmAdmin.DISPOSE_ON_CLOSE();
			inventory invnt=new inventory();
			invnt.setVisible(true);
			}
		});
		mnView.add(mntmEmployee);
		
		JMenuItem mntmGraphView = new JMenuItem("Graph View");
		mntmGraphView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Chart ch=new Chart();
			ch.setVisible(true);
			ch.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		mnView.add(mntmGraphView);
		
		JSeparator separator = new JSeparator();
		mnView.add(separator);
		
		JMenu mnPrintView = new JMenu("Print ");
		mnView.add(mnPrintView);
		
		JMenuItem mntmCustomer = new JMenuItem("Customer Sell Token");
		mnPrintView.add(mntmCustomer);
		
		JMenuItem mntmSuggetion_1 = new JMenuItem("Suggetion");
		mnPrintView.add(mntmSuggetion_1);
		
		JMenuItem mntmGraph = new JMenuItem("Graph view");
		mntmGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame yourComponent = new JFrame();
				PrinterJob pjob = PrinterJob.getPrinterJob();
				PageFormat preformat = pjob.defaultPage();
				preformat.setOrientation(PageFormat.LANDSCAPE);
				PageFormat postformat = pjob.pageDialog(preformat);
				//If user does not hit cancel then print.
				if (preformat != postformat) {
				    //Set print component
				    pjob.setPrintable(new Printer(yourComponent), postformat);
				    if (pjob.printDialog()) {
				        try {
							pjob.print();
						} catch (PrinterException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				    }
				}
			}
		});
		mnPrintView.add(mntmGraph);
		
		JSeparator separator_3 = new JSeparator();
		mnView.add(separator_3);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnView.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmReadme = new JMenuItem("Readme");
		mnHelp.add(mntmReadme);
		
		JMenu mnTraining = new JMenu("Training");
		mnHelp.add(mnTraining);
		
		JMenuItem mntmEmployeeTraining = new JMenuItem("Employee training");
		mnTraining.add(mntmEmployeeTraining);
		
		JMenuItem mntmAdministrativeTraining = new JMenuItem("Administrative training");
		mnTraining.add(mntmAdministrativeTraining);
		
		JMenuItem mntmTutorial = new JMenuItem("Tutorial");
		mnHelp.add(mntmTutorial);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmContact = new JMenuItem("Contact");
		mnAbout.add(mntmContact);
		
		JMenuItem mntmBlog = new JMenuItem("Blog");
		mnAbout.add(mntmBlog);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(798, 164, 243, 479);
		contentPane.add(scrollPane_2);
		
		Monthlyselltable = new JTable();
		Monthlyselltable.setForeground(Color.WHITE);
		Monthlyselltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int row=Monthlyselltable.getSelectedRow();
					String getrow=(Monthlyselltable.getModel().getValueAt(row, 0).toString()); 
				    String query="select * from year where Month='"+getrow+"'";
				    PreparedStatement pst=connectoin.prepareStatement(query);
				    ResultSet rs=pst.executeQuery();
				    while(rs.next())
				    {
				    	date.setText(rs.getString("Month"));
				    	sell.setText(rs.getString("Sell"));
				    }
				   pst.close();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		scrollPane_2.setViewportView(Monthlyselltable);
		Monthlyselltable.setBackground(Color.BLACK);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(526, 161, 243, 479);
		contentPane.add(scrollPane_1);
		
		DailySelltable = new JTable();
		DailySelltable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try{
				int row=DailySelltable.getSelectedRow();
				String getrow=(DailySelltable.getModel().getValueAt(row, 0).toString()); 
			    String query="select * from january where date='"+getrow+"'";
			    PreparedStatement pst=connectoin.prepareStatement(query);
			    ResultSet rs=pst.executeQuery();
			    while(rs.next())
			    {
			    	date.setText(rs.getString("date"));
			    	sell.setText(rs.getString("sell"));
			    }
			   pst.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			}
		});
		scrollPane_1.setViewportView(DailySelltable);
		DailySelltable.setForeground(Color.WHITE);
		DailySelltable.setBackground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rahat\\workspace\\inventory\\Image\\iconic.jpg"));
		lblNewLabel.setBounds(1264, 615, 88, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnEditday = new JButton("Save Editing");
		btnEditday.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnEditday.setBackground(new Color(253, 245, 230));
		btnEditday.setForeground(Color.LIGHT_GRAY);
		btnEditday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
//		 String query="Update january set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
//		 	
//			try {
//				PreparedStatement pst=connectoin.prepareStatement(query);
//			    pst.executeUpdate();
//			    JOptionPane.showMessageDialog(null, "Data Updated");
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			 try{
         	 	connectoin=Main.dbConnector();
					Object item = comboBoxmonth.getSelectedItem();
					//	String value = ((JComboBox)item).;
						String query = null;
					 
						if (item=="January")
						{
							query="Update january set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="February")
						{
							query="Update february set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="March")
						{
							query="Update march set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="April")
						{
							query="Update april set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="May")
						{
							query="Update may set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="June")
						{
							query="Update june set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="July")
						{
							query="Update july set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="August")
						{
							query="Update august set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="September")
						{
							query="Update september set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="October")
						{
							query="Update october set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="November")
						{
							query="Update novermber set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
						if (item=="December")
						{
							query="Update december set date='"+date.getText()+"',sell='"+sell.getText()+"' where date='"+date.getText()+"'";
					 	}
			            if(date.getText()=="January")
			            {
			               query="Update year set Sell='"+sell.getText()+"'where Month='"+date.getText()+"'";	
			            }
			            if(date.getText()=="February")
			            {
			               query="Update year set Sell='"+sell.getText()+"'where Month='"+date.getText()+"'";	
			            }
			            if(date.getText()=="March")
			            {
			               query="Update year set Sell='"+sell.getText()+"'where Month='"+date.getText()+"'";	
			            }
			            if(date.getText()=="April")
			            {
//			               query="Update year set Sell='"+sell.getText()+"'where Month='"+date.getText()+"'";
			            	System.out.println(sell.getText());
			            }
					
					 PreparedStatement pst=connectoin.prepareStatement(query);
				     pst.executeUpdate();
				 //    DailySelltable.setModel(DbUtils.resultSetToTableModel(rs));
				     refreshtable();
				     JOptionPane.showMessageDialog(null, "Data Updated");
				}
					catch(Exception e1){
						e1.printStackTrace();
						 JOptionPane.showMessageDialog(null,"can't");
						 }
         
			}
		});
		btnEditday.setBounds(262, 231, 167, 30);
		contentPane.add(btnEditday);
		
		JButton btnDeleteDayEntry = new JButton("Delete");
		btnDeleteDayEntry.setFont(new Font("Tempus Sans ITC", Font.BOLD, 13));
		btnDeleteDayEntry.setForeground(Color.LIGHT_GRAY);
		btnDeleteDayEntry.setBackground(new Color(253, 245, 230));
		btnDeleteDayEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String query="delete from january where date='"+date.getText()+"'";
			  try {
				PreparedStatement pst=connectoin.prepareStatement(query);	   
				pst.execute();
				refreshtable();
				JOptionPane.showMessageDialog(null, "Data Deleted");
			
			   pst.close();
			   
			  } catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}); 
		btnDeleteDayEntry.setBounds(57, 231, 171, 30);
		contentPane.add(btnDeleteDayEntry);
		
		//JComboBox comboBox = new JComboBox();
		//refreshtable();
		comboBoxmonth.setForeground(new Color(210, 180, 140));
		comboBoxmonth.addItem("January");
		comboBoxmonth.addItem("February");
		comboBoxmonth.addItem("March");
		comboBoxmonth.addItem("April");
		comboBoxmonth.addItem("May");
		comboBoxmonth.addItem("June");
		comboBoxmonth.addItem("July");
		comboBoxmonth.addItem("August");
		comboBoxmonth.addItem("September");
		comboBoxmonth.addItem("October");
		comboBoxmonth.addItem("November");
		comboBoxmonth.addItem("December");
		comboBoxmonth.setBackground(new Color(255, 255, 224));
		comboBoxmonth.setBounds(57, 90, 171, 30);
		contentPane.add(comboBoxmonth);
		
		date = new JTextField();
		date.setBounds(57, 164, 167, 30);
		contentPane.add(date);
		date.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(473, 255, 2, 305);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edit Day Entry");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(72, 130, 195, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(57, 155, 237, -6);
		contentPane.add(separator_2);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(255, 245, 238));
		toolBar.setBounds(0, 0, 1362, 30);
		contentPane.add(toolBar);
		toolBar.addSeparator();
		
		
		JButton re_new_d = new JButton("");
		re_new_d.setToolTipText("Delete Database");
 
		re_new_d.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String query="DROP DATABASE teastall";
				try {
					PreparedStatement pst=con.prepareStatement(query);
					 int reply = JOptionPane.showConfirmDialog(null, "Are You Sure to Delete all data of your database?", "Destroy Database", JOptionPane.YES_NO_OPTION);
				     
					    if (reply == JOptionPane.YES_OPTION) {
				             	 
				    pst.executeUpdate();
				             	 }
					    else{
					    	  JOptionPane.showMessageDialog(null, "Contact About your problem with developer");
						        
					    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Database Already Destroyed");
					e.printStackTrace();
				}
			}
		});
		re_new_d.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\Renewdatabase1.jpg"));
		toolBar.add(re_new_d);
		
		JButton CreateDb = new JButton(" ");
		 
		CreateDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 String query="CREATE DATABASE teastall";

 			 String[] query2={
 			 "CREATE TABLE january(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE february(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE march(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE april(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE may(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE june(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE july(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE august(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE september(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE octobar(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",			 				 
			 "CREATE TABLE novebmer(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
			 "CREATE TABLE december(date INT(3) unsigned NOT NULL auto_increment,sell INT(10) NOT NULL,PRIMARY KEY (date))",
		     "CREATE TABLE login(Username VARCHAR(50) NOT NULL ,Password VARCHAR(50) NOT NULL,PRIMARY KEY (Username))",
			 "CREATE TABLE year(Month VARCHAR(15) NOT NULL,Sell INT(10) NOT NULL,PRIMARY KEY (Month))",
 			"CREATE TABLE itemlavel(itemname VARCHAR(15) NOT NULL,amount INT(10) NOT NULL,PRIMARY KEY (itemname))"};
			 // try {
				 
				     
				    int reply = JOptionPane.showConfirmDialog(null, "Are you want to create all table with database?", "make a table", JOptionPane.YES_NO_OPTION);
			     
				    if (reply == JOptionPane.YES_OPTION) {
			             	 
			     	    try {
			     	   	PreparedStatement pst=con.prepareStatement(query);
					    pst.executeUpdate(query);
					    JOptionPane.showMessageDialog(null,"Database created successfully");
			     	   	connectoin=Main.dbConnector(); 
			     		   
			     		   try {
//			     			  
			     			  for (int i=0;i<=14;i++)
			     			 {   PreparedStatement ps=connectoin.prepareStatement(query2[i]);
			     			   
			     			   ps.executeUpdate(query2[i]); 
			     			   
			     			   ps.close();
			     			 }
			     			 }
			     		   
			     		  catch (Exception e) {
			     		    	JOptionPane.showMessageDialog(null,"Sorry Can't Create table");
			     		      e.printStackTrace();
			     		    }
			     	    }
			     		    catch (Exception e) {
			     		    	JOptionPane.showMessageDialog(null, e);
			     		    	//JOptionPane.showMessageDialog(null,"Your Database Is Already Exist Or Can't Connect to database");
			     		   
								
			     		    	e.printStackTrace();
			     		    
			     		    }}
			     	 
			        //}
			        else {
			       
			              
			        }
			 
//			 	} catch (SQLException e) {
//					// TODO Auto-generated catch block
//			 		 JOptionPane.showMessageDialog(null, "Your Database Is Already Exist");
//					e.printStackTrace();
//				}
			  }
		});
		CreateDb.setToolTipText("Create Database");
		CreateDb.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\Free-Database-Add-icon.jpg"));
		toolBar.add(CreateDb);
		
		 
		JButton ref_data = new JButton("");
		ref_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			refreshtable();
			}
		});
		ref_data.setBackground(Color.WHITE);
		ref_data.setToolTipText("Refresh Data Tables");
		ref_data.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\Renew1.jpg"));
		toolBar.add(ref_data);
		
		JButton item_level = new JButton("");
		item_level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Chart ch=new Chart();
			ch.setVisible(true);
			}
		});
		item_level.setBackground(Color.WHITE);
		item_level.setToolTipText("Item Level");
		item_level.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\equalizer_graph_moving_up_down_500_clr_3703.gif"));
		toolBar.add(item_level);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(526, 133, 241, 2);
		contentPane.add(separator_4);
		
		JLabel label = new JLabel("Daily Sell Table");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(526, 90, 216, 29);
		contentPane.add(label);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(786, 133, 241, 2);
		contentPane.add(separator_5);
		
		JLabel lblMonthlySellTable = new JLabel("Monthly Sell Table");
		lblMonthlySellTable.setForeground(SystemColor.textHighlight);
		lblMonthlySellTable.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonthlySellTable.setBounds(786, 90, 216, 29);
		contentPane.add(lblMonthlySellTable);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\1a773c56fd32adb4be904896.gif"));
		lblNewLabel_1.setBounds(57, 300, 361, 343);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1070, 164, 243, 479);
		contentPane.add(scrollPane);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(1058, 133, 241, 2);
		contentPane.add(separator_6);
		
		JLabel lblEmployeeWorkingTime = new JLabel("Employee working time");
		lblEmployeeWorkingTime.setForeground(SystemColor.textHighlight);
		lblEmployeeWorkingTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmployeeWorkingTime.setBounds(1058, 90, 216, 29);
		contentPane.add(lblEmployeeWorkingTime);
		
		sell = new JTextField();
		sell.setColumns(10);
		sell.setBounds(262, 162, 167, 30);
		contentPane.add(sell);
		//make jframe center on the screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setSize(1400,730);
		setLocationRelativeTo(null);
		
	}

	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
class Printer implements Printable {
    final Component comp;

    public Printer(Component comp){
        this.comp = comp;
    }

    @Override
    public int print(Graphics g, PageFormat format, int page_index) 
            throws PrinterException {
        if (page_index > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component
        Dimension dim = comp.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // get the bounds of the printable area
        double pHeight = format.getImageableHeight();
        double pWidth = format.getImageableWidth();

        double pXStart = format.getImageableX();
        double pYStart = format.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;


        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        comp.paint(g2);

        return Printable.PAGE_EXISTS;

}}