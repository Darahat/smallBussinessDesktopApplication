package inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.*;
import javax.swing.*;
 

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
public class inventory extends JFrame {

	/*
	Author:Diarul Alam rahat
	Project Intro:It's a project of L3 T-3 
	Sub :OOSD
	Email:darahat42@gmail.com
	*/
	private JPanel contentPane;
	private JTextField cupoftea;
	private JTextField numberofbiscuit;
	private JTextField numberofruti;
	private JTextField amount;
	private JLabel lblTodayTotal;
	private JTextField todaytotal;
    public int total;
    public int monthlyselltotal;
    
//    int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    int te=0,teaval=6,biscuitval=3,rutival=8,coffeeval=10,cignum5val=5,cignum8val=8,cignum11val=11,coltnum25val=16,coltnum5val=30,coltnum1val=55,amountvar=0;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
					
					try{
					
					inventory frame = new inventory();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

					}
				  catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static XYDataset createDataset()
	{
		DefaultXYDataset ds=new DefaultXYDataset();
		double[][]data={{2,4,6,8,10,12,14,16,18,20},{210,125,451,360,855,133,240,325,452,732}};
		ds.addSeries("sellinrate", data);
	    return ds;
	}
	JPanel itemlevel = new JPanel();
	JPanel panel_1 = new JPanel();
	public void itemlv(){
	 
		con=Main.dbConnector();
		try{
//			 
				 String query1="Select amount FROM itemlavel where itemname='tea'";
				 String query2="Select amount FROM itemlavel where itemname='coffee'";
				 String query3="Select amount FROM itemlavel where itemname='Biscuit'";
				 String query4="Select amount FROM itemlavel where itemname='Ruti_Cake'";
		         String query5="Select amount FROM itemlavel where itemname='cig_5'";
				 String query6="Select amount FROM itemlavel where itemname='cig_8'";
				 String query7="Select amount FROM itemlavel where itemname='cig_10'";
				 String query8="Select amount FROM itemlavel where itemname='cold_25'";
				 String query9="Select amount FROM itemlavel where itemname='cold_5'";
				 String query10="Select amount FROM itemlavel where itemname='cold_1'"; 
				 PreparedStatement pst1=con.prepareStatement(query1);
				 PreparedStatement pst2=con.prepareStatement(query2);
				 PreparedStatement pst3=con.prepareStatement(query3);
				 PreparedStatement pst4=con.prepareStatement(query4);
				 PreparedStatement pst5=con.prepareStatement(query5);
				 PreparedStatement pst6=con.prepareStatement(query6);
				 PreparedStatement pst7=con.prepareStatement(query7);
				 PreparedStatement pst8=con.prepareStatement(query8);
				 PreparedStatement pst9=con.prepareStatement(query9);
				 PreparedStatement pst10=con.prepareStatement(query10);
				 ResultSet rs1=pst1.executeQuery();
				 ResultSet rs2=pst2.executeQuery();
				 ResultSet rs3=pst3.executeQuery();
				 ResultSet rs4=pst4.executeQuery();
				 ResultSet rs5=pst5.executeQuery();
				 ResultSet rs6=pst6.executeQuery();
				 ResultSet rs7=pst7.executeQuery();
				 ResultSet rs8=pst8.executeQuery();
				 ResultSet rs9=pst9.executeQuery();
				 ResultSet rs10=pst10.executeQuery();
				   int s1=0,s2=0,s3=0,s4=0,s5=0,s6=0,s7=0,s8=0,s9=0,s10=0;			 
				 /*
					Author:Diarul Alam rahat
					Project Intro:It's a project of L3 T-3 
					Sub :OOSD
					Email:darahat42@gmail.com
					*/
	 while(rs1.next())
	 
		        s1=rs1.getInt("amount");
	 while(rs2.next())
			
	 s2=rs2.getInt("amount");
	 while(rs3.next())
			       
	 s3=rs3.getInt("amount");
	 while(rs4.next())
			       
	 s4=rs4.getInt("amount");
	 while(rs5.next())
			       
	 s5=rs5.getInt("amount");
	 while(rs6.next())
			       
	 s6=rs6.getInt("amount");
	 while(rs7.next())
			       
	 s7=rs7.getInt("amount");
	 while(rs8.next())
			       
	 s8=rs8.getInt("amount");
	 while(rs9.next())
			       
	 s9=rs9.getInt("amount");
	 while(rs10.next())
			       
	 s10=rs10.getInt("amount");
        
//	       	 System.out.println(s1);      
//	    				   
		 	 
			DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
			dataset.setValue(s1, "1", "Tea");
		    dataset.setValue(s2, "2", "Coffee");
		    dataset.setValue(s3, "3", "Biscuit");
		    dataset.setValue(s4, "4", "Ruti/Cake");
		    dataset.setValue(s5, "5", "Cig_5");
		    dataset.setValue(s6, "6", "Cig_8");
		    dataset.setValue(s7, "7", "Cig_12");
		    dataset.setValue(s8, "8", "Cold_25");
		    dataset.setValue(s9, "9", "Cold_5");
		    dataset.setValue(s10,"10","Cold_1");
		    
	     
		    JFreeChart chart=ChartFactory.createBarChart("Item Level", "Item", "Quantity", dataset, PlotOrientation.VERTICAL, false, true, false);
		
//		    CategoryPlot catplot=chart.getCategoryPlot();
//			catplot.setRangeGridlinePaint(Color.white);
//			
			ChartPanel chartPanel=new ChartPanel(chart);
			
			itemlevel.removeAll();
			itemlevel.add(chartPanel, BorderLayout.CENTER);
			itemlevel.validate();
//			
	 
		}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}	
		  
	
	}
	public void dupdown()
	{

//		XYDataset dataset2=createDataset();
//		JFreeChart chart2=ChartFactory.createXYLineChart("Sell Every Two Hour", "Hour", "Sell", dataset2, PlotOrientation.VERTICAL, true, true, false);
////		CategoryPlot catplot2=chart2.getCategoryPlot();
////		catplot2.setRangeGridlinePaint(Color.WHITE);
////		
//		ChartPanel chartPanel2=new ChartPanel(chart2);
//		
//		panel_1.removeAll();
//		panel_1.add(chartPanel2, BorderLayout.CENTER);
//		panel_1.validate();
	}
    Connection con=null;
    private JTextField monthlyholsell;
	/**
	 * Create the frame.
	 */
	JCheckBox cigcb5 = new JCheckBox("5tk");
	JCheckBox cigcb11 = new JCheckBox("11tk");
	JCheckBox cigcb8 = new JCheckBox("8tk");
    JComboBox<String> comboBoxmonth = new JComboBox<String>();
    JCheckBox coldcb1 = new JCheckBox("1L");
	JCheckBox coldcb5 = new JCheckBox(".5L");
	JCheckBox coldcb25 = new JCheckBox(".25L");
	private JTextField cupofcoffee;
	private JTextField cigqun11;
	private JTextField cigqun8;
	private JTextField cigqun5;
	private JTextField colt25;
	private JTextField colt5;
	private JTextField colt1;
	private JTextField moneygiven;
	private JTextField mback;
	public inventory() {
		setResizable(false);
		con=Main.dbConnector();
		setTitle("S.R.R.M COFFEE HOUSE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -20, 1105, 737);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmAdministration = new JMenuItem("Administration");
		mntmAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Login log=new Login();
			log.setVisible(true);
			}
		});
		mnView.add(mntmAdministration);
		
		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mnView.add(mntmEmployee);
		
		JSeparator separator_5 = new JSeparator();
		mnView.add(separator_5);
		
		JMenu mnPrintView = new JMenu("Print ");
		mnView.add(mnPrintView);
		
		JMenuItem mntmCustomer = new JMenuItem("Customer Sell Token");
		mnPrintView.add(mntmCustomer);
		
		JMenuItem mntmEmployeeSallaryInfo = new JMenuItem("Employee Sallary info");
		mnPrintView.add(mntmEmployeeSallaryInfo);
		
		JSeparator separator_6 = new JSeparator();
		mnView.add(separator_6);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnView.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmReadme = new JMenuItem("Readme");
		mntmReadme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try
				    {
				        Desktop.getDesktop().open(new File("text.txt"));
				    }
				    catch(java.io.IOException e1)
				    {
				        System.out.println("IOError");
				    }
			}
		});
		mnHelp.add(mntmReadme);
		
		JSeparator separator_3 = new JSeparator();
		mnHelp.add(separator_3);
		
		JMenu mnTraining = new JMenu("Training");
		mnHelp.add(mnTraining);
		
		JMenuItem mntmEmployeeTraining = new JMenuItem("Employee training");
		mntmEmployeeTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   try {         
					     java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://info-technology-tutorial.blogspot.com/2015/02/hacking.html"));
					   }
					   catch (java.io.IOException e) {
					      JOptionPane.showMessageDialog(null, "Can not Connect to server");
					   }
					}
			
		});
		mnTraining.add(mntmEmployeeTraining);
		
		JMenuItem mntmAdministrativeTraining = new JMenuItem("Administrative training");
		mntmAdministrativeTraining.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   try {         
					     java.awt.Desktop.getDesktop().browse(java.net.URI.create("http://info-technology-tutorial.blogspot.com/2015/02/hacking.html"));
					   }
					   catch (java.io.IOException e1) {
					      JOptionPane.showMessageDialog(null, "Can not Connect to server");
					   }
			}
		});
		mnTraining.add(mntmAdministrativeTraining);
		
		JMenuItem mntmTutorial = new JMenuItem("Tutorial");
		mntmTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {         
				     java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.youtube.com/channel/UCZBH5xGH8-oeF5KRK_AQ6zg"));
				   }
				   catch (java.io.IOException e1) {
				      JOptionPane.showMessageDialog(null, "Can not Connect to server");
				   }
			}
		});
		mnHelp.add(mntmTutorial);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmContact = new JMenuItem("Contact");
		mntmContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
				    {
				        Desktop.getDesktop().open(new File("Contact_me.txt"));
				    }
				    catch(java.io.IOException e1)
				    {
				    	JOptionPane.showMessageDialog(null, "File Cannot Found");
				    }
			}
		});
		mnAbout.add(mntmContact);
		
		JMenuItem mntmBlog = new JMenuItem("About Developer");
		mntmBlog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
				    {
				        Desktop.getDesktop().open(new File("About_me.txt"));
				    }
				    catch(java.io.IOException e1)
				    {
				    	JOptionPane.showMessageDialog(null, "File Cannot Found");
				    }
			}
		});
	 
		JSeparator separator_7 = new JSeparator();
		mnAbout.add(separator_7);
		mnAbout.add(mntmBlog);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBackground(Color.YELLOW);
		//make jframe center on the screen
	 
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setSize(1400,730);
		setLocationRelativeTo(null);
		
		JLabel lblCupOfTea = new JLabel("CUP OF TEA");
		lblCupOfTea.setForeground(new Color(218, 165, 32));
		lblCupOfTea.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCupOfTea.setBounds(10, 197, 139, 29);
		contentPane.add(lblCupOfTea);
		
		JLabel lblNumberOfRuti = new JLabel("NUMBER OF BISCUIT");
		lblNumberOfRuti.setForeground(new Color(218, 165, 32));
		lblNumberOfRuti.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfRuti.setBounds(10, 280, 168, 29);
		contentPane.add(lblNumberOfRuti);
		
		JLabel lblNumberOfRuticake = new JLabel("NUMBER OF RUTI/CAKE");
		lblNumberOfRuticake.setForeground(new Color(218, 165, 32));
		lblNumberOfRuticake.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfRuticake.setBounds(10, 327, 182, 29);
		contentPane.add(lblNumberOfRuticake);
		
		lblTodayTotal = new JLabel("Today Total");
		lblTodayTotal.setForeground(new Color(0, 0, 0));
		lblTodayTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTodayTotal.setBounds(471, 373, 121, 22);
		contentPane.add(lblTodayTotal);
		
		cupoftea = new JTextField();
		cupoftea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent tab) {
				 
					cupoftea.setText("");
		 
			}
		});
		cupoftea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cupoftea.setText("0");
		cupoftea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			cupoftea.setText("");
			}
		});
		cupoftea.setBounds(188, 196, 151, 22);
		contentPane.add(cupoftea);
		cupoftea.setColumns(5);
		
  
	XYDataset dataset1=createDataset();
	JFreeChart chart1=ChartFactory.createXYLineChart("SELL Up and Down", "Time", "Sell Rate", dataset1, PlotOrientation.VERTICAL, true, true, false);
 	
	ChartPanel chartPanel1=new ChartPanel(chart1);
	
	panel_1.removeAll();
	panel_1.add(chartPanel1, BorderLayout.CENTER);
	panel_1.validate(); 
		
		numberofbiscuit = new JTextField();
		numberofbiscuit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numberofbiscuit.setText("0");
		numberofbiscuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			numberofbiscuit.setText("");
			}
		});
		numberofbiscuit.setColumns(5);
		numberofbiscuit.setBounds(188, 280, 151, 22);
		contentPane.add(numberofbiscuit);
		
		numberofruti = new JTextField();
		numberofruti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		numberofruti.setText("0");
		numberofruti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			numberofruti.setText("");
			}
		});
		numberofruti.setColumns(5);
		numberofruti.setBounds(188, 327, 151, 22);
		contentPane.add(numberofruti);
		
		amount = new JTextField();
		amount.setFont(new Font("Tahoma", Font.PLAIN, 30));
		amount.setEditable(false);
		amount.setColumns(5);
		amount.setBounds(188, 598, 139, 29);
		contentPane.add(amount);
		
		todaytotal = new JTextField(0);
		todaytotal.setFont(new Font("Tahoma", Font.PLAIN, 30));
		todaytotal.setEditable(false);
		todaytotal.setBounds(559, 373, 136, 29);
		contentPane.add(todaytotal);
		todaytotal.setColumns(5);
		
		JButton btnAmount = new JButton("Amount");
		btnAmount.setIcon(null);
		btnAmount.setBackground(Color.BLACK);
		btnAmount.setForeground(Color.LIGHT_GRAY);
		//btnAmount.setBackground(Color.black);
		btnAmount.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		btnAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  //int teaval=6,biscuitval=3,rutival=8,coffeeval=10,cignum5val=5,cignum8val=8,cignum11val=11,coltnum25val=16,coltnum5val=30,coltnum1val=55;
				int tea,biscuit,ruti,total1,coffee,cignum5,cignum8,cignum11,coltnum25,coltnum5,coltnum1;
			 try{
				 tea=Integer.parseInt(cupoftea.getText());
				 biscuit=Integer.parseInt(numberofbiscuit.getText());
				 ruti=Integer.parseInt(numberofruti.getText());
				coffee=Integer.parseInt(cupofcoffee.getText());
				cignum5=Integer.parseInt(cigqun5.getText());  
				cignum8=Integer.parseInt(cigqun8.getText());
				cignum11=Integer.parseInt(cigqun11.getText());
				coltnum25=Integer.parseInt(colt25.getText());  
				coltnum5=Integer.parseInt(colt5.getText());
				coltnum1=Integer.parseInt(colt1.getText());
				
				 amountvar=tea*teaval+biscuit*biscuitval+ruti*rutival+coffee*coffeeval+cignum5*cignum5val+cignum8*cignum8val+cignum11*cignum11val+coltnum25val*coltnum25+coltnum5val*coltnum5+coltnum1val*coltnum1;	
			 
			 
				 amount.setText(Integer.toString(amountvar));
				 
				 total1=Integer.parseInt(amount.getText());
				 total+=total1;
				 todaytotal.setText(Integer.toString(total));
				 cupoftea.setText("0");
				 numberofbiscuit.setText("0");
				 numberofruti.setText("0");
				 cupofcoffee.setText("0");
				 cigqun5.setText("0");
				 cigqun8.setText("0");
				 cigqun11.setText("0");
				 colt25.setText("0");
				 colt5.setText("0");
				 colt1.setText("0");	
				 //todaytotal.setText("0");
				 //amount.setText("0");
				 cigcb8.setSelected(false);
			     cigcb11.setSelected(false);
				 cigcb5.setSelected(false);
				 coldcb25.setSelected(false);
				 coldcb5.setSelected(false);
				 coldcb1.setSelected(false);
				  
				 
			 }
			 
			 catch(Exception e1){
				 JOptionPane.showMessageDialog(null,"Please Enter Valid Number");
			 }
			
			}
		});
		btnAmount.setBounds(12, 598, 137, 29);
		contentPane.add(btnAmount);
		//dtm.setRowCount(3);
		
		JButton btnNewButton_1 = new JButton("DAY END");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					
					
					 //String query="INSERT INTO january (Sell) values(?)";
					 Object item = comboBoxmonth.getSelectedItem();
						//	String value = ((JComboBox)item).;
							String query = null;
							 
							if (item=="January")
							{
								query="INSERT INTO january (Sell) values(?)";
						 	}
							if (item=="February")
							{
								query="INSERT INTO february (Sell) values(?)";
						 	}
							if (item=="March")
							{
								query="INSERT INTO march (Sell) values(?)";
									 	}
							if (item=="April")
							{
								query="INSERT INTO april (Sell) values(?)";
						 	}
							if (item=="May")
							{
								query="INSERT INTO may (Sell) values(?)";
						 	}
							if (item=="June")
							{
								query="INSERT INTO june (Sell) values(?)";
						 	}
							if (item=="July")
							{
								query="INSERT INTO july (Sell) values(?)";
						 	}
							if (item=="August")
							{
								query="INSERT INTO august (Sell) values(?)";
						 	}
							if (item=="September")
							{
								query="INSERT INTO september (Sell) values(?)";
						 	}
							if (item=="October")
							{
								query="INSERT INTO october (Sell) values(?)";
						 	}
							if (item=="November")
							{
								query="INSERT INTO november (Sell) values(?)";
						 	}
							if (item=="December")
							{
								query="INSERT INTO december (Sell) values(?)";
						 	}
							
					 PreparedStatement pst=con.prepareStatement(query);
					
					 te=Integer.parseInt(todaytotal.getText());
					 pst.setInt(1,te);
					 pst.execute();
					// JOptionPane.showMessageDialog(null,"Data Saved"); 
					 te=0;
					 todaytotal.setText("0"); 
					  
				}
					catch(Exception e){
						 JOptionPane.showMessageDialog(null,"can't");
						 }
			}
		});
		btnNewButton_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnNewButton_1.setBounds(471, 434, 139, 29);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnEndOfThe = new JButton("MONTH END");
		btnEndOfThe.setBackground(Color.BLACK);
		btnEndOfThe.setForeground(new Color(255, 0, 0));
		btnEndOfThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
//					 String query="SELECT SUM(Sell) FROM january";
					 				   
				     Object item = comboBoxmonth.getSelectedItem();
						//	String value = ((JComboBox)item).;
							String query = null;
							if (item=="January")
							{
								query="SELECT SUM(Sell) FROM january";
						 	}
							if (item=="February")
							{
								query="SELECT SUM(Sell) FROM february ";
						 	}
							 
							if (item=="March")
							{
								query="SELECT SUM(Sell) FROM march";
						 	}
							if (item=="April")
							{
								query="SELECT SUM(Sell) FROM april";
						 	}
							if (item=="May")
							{
								query="SELECT SUM(Sell) FROM may";
						 	}
							if (item=="June")
							{
								query="SELECT SUM(Sell) FROM june";
						 	}
							if (item=="July")
							{
								query="SELECT SUM(Sell) FROM july";
						 	}
							if (item=="August")
							{
								query="SELECT SUM(Sell) FROM august ";
						 	}
							 
							if (item=="September")
							{
								query="SELECT SUM(Sell) FROM september";
						 	}
							if (item=="October")
							{
								query="SELECT SUM(Sell) FROM october";
						 	}
							if (item=="November")
							{
								query="SELECT SUM(Sell) FROM november";
						 	}
							if (item=="December")
							{
								query="SELECT SUM(Sell) FROM december";
						 	}
						   PreparedStatement pst=con.prepareStatement(query);
							   ResultSet rs=pst.executeQuery(query);
								/*
								Author:Diarul Alam rahat
								Project Intro:It's a project of L3 T-3 
								Sub :OOSD
								Email:darahat42@gmail.com
								*/
							   while(rs.next())
				     {
				       monthlyselltotal=rs.getInt(1);
				       monthlyholsell.setText(Integer.toString(monthlyselltotal));		       
				     }
				    	 try{
				    		
				    		 //query1="INSERT INTO year (Month,Sell)VALUES ('February',?)";		 
				    	 ///////////////////////////////////////////////////////////////////////////////
				    	 
							 Object item1 = comboBoxmonth.getSelectedItem();
								//	String value = ((JComboBox)item).;
									String query1 = null;
									if (item1=="January")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('January',?)";
								 	}
									if (item1=="February")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('February',?)";
								 	}
									 
									if (item1=="March")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('March',?)";
								 	}
									if (item1=="April")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('April',?)";
								 	}
									if (item1=="May")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('May',?)";
								 	}
									if (item1=="June")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('June',?)";
								 	}
									if (item1=="July")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('July',?)";
								 	}
									if (item1=="August")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('August',?)";
								 	}
									 
									if (item1=="September")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('September',?)";
								 	}
									if (item1=="October")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('October',?)";
								 	}
									if (item1=="November")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('November',?)";
								 	}
									if (item1=="December")
									{
										query1="INSERT INTO year (Month,Sell)VALUES ('December',?)";
								 	}
									
				    	// String query1="INSERT INTO year (Sell) values(?)";		
				    		 PreparedStatement pst1=con.prepareStatement(query1);
									 int te=Integer.parseInt(monthlyholsell.getText());
									// pst1.setString(1,monthlyholsell.getText() );
									 pst1.setInt(1,te);
									 pst1.execute();
							         JOptionPane.showMessageDialog(null,"Data Saved"); 
							        // pst1.close(); 
						}
							catch(Exception e1){
								 System.out.println("SQL Exception: " + e1.toString());
								 }
				    	 
				    	 
				    	 
				 	 
				}catch (SQLException e1) {
					
		            System.out.println("SQL Exception: " + e1.toString());
		
		        }  
			}
		});
		
		
		
		
		btnEndOfThe.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnEndOfThe.setBounds(471, 598, 139, 29);
		contentPane.add(btnEndOfThe);
		
		JLabel lblNewLabel_1 = new JLabel("Customer sell Information");
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 134, 266, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Daily Sell Information");
		lblNewLabel_2.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(471, 314, 216, 29);
		contentPane.add(lblNewLabel_2);
		comboBoxmonth.setForeground(Color.WHITE);
		comboBoxmonth.setBackground(new Color(0, 0, 0));
		comboBoxmonth.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//JComboBox comboBox = new JComboBox();
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
		
		//comboBox.setSelectedItem("Month Selection");
		
		 
		comboBoxmonth.setBounds(10, 94, 242, 29);
		contentPane.add(comboBoxmonth);
		
		monthlyholsell = new JTextField();
		monthlyholsell.setEditable(false);
		monthlyholsell.setBounds(559, 546, 136, 29);
		contentPane.add(monthlyholsell);
		monthlyholsell.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Monthly sell");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(471, 544, 114, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("* CAUTION-> SEE MONTH IS SET CORRECTLY");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 58, 284, 25);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblMonthlySellInformation = new JLabel("Monthly Sell Information");
		lblMonthlySellInformation.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		lblMonthlySellInformation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonthlySellInformation.setBounds(471, 483, 233, 29);
		contentPane.add(lblMonthlySellInformation);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 180, 242, 2);
		contentPane.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(772, 210, 0, 49);
		contentPane.add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(471, 354, 241, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Rahat\\workspace\\inventory\\Image\\iconic.jpg"));
		lblNewLabel_5.setBounds(1263, 638, 99, 43);
		contentPane.add(lblNewLabel_5);
		
		cupofcoffee = new JTextField();
		cupofcoffee.addKeyListener(new KeyAdapter() {
			//@Override
//			public void keyPressed(KeyEvent) {
//		 
//					cupoftea.setText("");
//			 
//			}
		});
		cupofcoffee.setText("0");
		cupofcoffee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			cupofcoffee.setText("");
			}
		});
		cupofcoffee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cupofcoffee.setColumns(5);
		cupofcoffee.setBounds(188, 237, 151, 22);
		contentPane.add(cupofcoffee);
		
		JLabel lblCupOfCoffee = new JLabel("CUP OF  COFEE");
		lblCupOfCoffee.setForeground(new Color(218, 165, 32));
		lblCupOfCoffee.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCupOfCoffee.setBounds(10, 238, 139, 29);
		contentPane.add(lblCupOfCoffee);
		
		JLabel lblCiggarate = new JLabel("CIGARATTE TYPE");
		lblCiggarate.setForeground(new Color(218, 165, 32));
		lblCiggarate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCiggarate.setBounds(10, 367, 175, 29);
		contentPane.add(lblCiggarate);
	 
		cigcb8.setBackground(Color.WHITE);
		cigcb8.setBounds(236, 373, 50, 23);
		contentPane.add(cigcb8);
	 
		cigcb11.setBackground(Color.WHITE);
		cigcb11.setBounds(284, 373, 55, 23);
		contentPane.add(cigcb11);
		
		 
		 
		cigcb5.setBackground(Color.WHITE);
		cigcb5.setBounds(188, 373, 50, 23);
		contentPane.add(cigcb5);
		 
		 
		JLabel lblCigaratteQuantity = new JLabel("CIGARATTE QUANTITY");
		lblCigaratteQuantity.setForeground(new Color(218, 165, 32));
		lblCigaratteQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCigaratteQuantity.setBounds(10, 418, 175, 29);
		contentPane.add(lblCigaratteQuantity);
		
		cigqun11 = new JTextField();
		cigqun11.setText("0");
		cigqun11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cigqun11.setText("");
			}
		});
		cigqun11.setColumns(10);
		cigqun11.setBounds(289, 422, 50, 20);
		contentPane.add(cigqun11);
		
		JLabel lblColdDrinksType = new JLabel("COLD DRINKS TYPE");
		lblColdDrinksType.setForeground(new Color(218, 165, 32));
		lblColdDrinksType.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColdDrinksType.setBounds(10, 470, 175, 29);
		contentPane.add(lblColdDrinksType);
		
		JLabel lblColdDrinksQuantity = new JLabel("COLD DRINKS QUANTITY");
		lblColdDrinksQuantity.setForeground(new Color(218, 165, 32));
		lblColdDrinksQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblColdDrinksQuantity.setBounds(10, 522, 175, 29);
		contentPane.add(lblColdDrinksQuantity);
		 
		coldcb25.setBackground(Color.WHITE);
		coldcb25.setBounds(188, 470, 50, 23);
		contentPane.add(coldcb25);
	 
		coldcb5.setBackground(Color.WHITE);
		coldcb5.setBounds(240, 470, 55, 23);
		contentPane.add(coldcb5);
		
	 
		coldcb1.setBackground(Color.WHITE);
		coldcb1.setBounds(297, 470, 42, 23);
		contentPane.add(coldcb1);
		
		cigqun8 = new JTextField();
		cigqun8.setText("0");
		cigqun8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cigqun8.setText("");
			}
		});
		cigqun8.setColumns(10);
		cigqun8.setBounds(237, 422, 55, 20);
		contentPane.add(cigqun8);
		
		cigqun5 = new JTextField();
		cigqun5.setText("0");
		cigqun5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cigqun5.setText("");
			}
		});
		cigqun5.setColumns(10);
		cigqun5.setBounds(188, 422, 50, 20);
		contentPane.add(cigqun5);
		
		colt25 = new JTextField();
		colt25.setText("0");
		colt25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				colt25.setText("");
			}
		});
		colt25.setColumns(10);
		colt25.setBounds(188, 530, 50, 20);
		contentPane.add(colt25);
		
		colt5 = new JTextField();
		colt5.setText("0");
		colt5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				colt5.setText("");
			}
		});
		colt5.setColumns(10);
	 
		colt5.setBounds(236, 530, 55, 20);
		contentPane.add(colt5);
		
		colt1 = new JTextField();
		colt1.setText("0");
		colt1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				colt1.setText("");
			}
		});
		colt1.setColumns(10);
		colt1.setBounds(289, 530, 50, 20);
		contentPane.add(colt1);
		
		JLabel lblMoneyBack = new JLabel("Money Back");
		lblMoneyBack.setForeground(SystemColor.textHighlight);
		lblMoneyBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMoneyBack.setBounds(471, 134, 216, 29);
		contentPane.add(lblMoneyBack);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(471, 177, 241, 2);
		contentPane.add(separator_4);
		
		JLabel lblMoneyGiven = new JLabel("Money Given");
		lblMoneyGiven.setForeground(Color.BLACK);
		lblMoneyGiven.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMoneyGiven.setBounds(471, 203, 121, 22);
		contentPane.add(lblMoneyGiven);
		
		moneygiven = new JTextField(5);
		moneygiven.setToolTipText("");
		moneygiven.setFont(new Font("Tahoma", Font.PLAIN, 15));
		moneygiven.setBounds(559, 203, 136, 22);
		contentPane.add(moneygiven);
		
		mback = new JTextField(5);
		mback.setFont(new Font("Tahoma", Font.PLAIN, 23));
		mback.setEditable(false);
		mback.setBounds(559, 256, 136, 29);
		contentPane.add(mback);
		
//		JPanel panel = new JPanel();
		itemlevel.setBounds(749, 58, 593, 280);
		contentPane.add(itemlevel);
		itemlevel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 0, 51), new Color(0, 51, 51), Color.LIGHT_GRAY, Color.GRAY));
		itemlevel.setForeground(new Color(204, 204, 51));
		itemlevel.setBackground(new Color(255, 255, 204));
		itemlevel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel sellafttwolvl = new JPanel();
		sellafttwolvl.setBounds(748, 358, 593, 280);
		contentPane.add(sellafttwolvl);
		sellafttwolvl.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 51, 51), new Color(0, 51, 102), Color.LIGHT_GRAY, Color.GRAY));
		sellafttwolvl.setForeground(new Color(204, 51, 0));
		sellafttwolvl.setBackground(new Color(255, 255, 204));
		sellafttwolvl.setLayout(new GridLayout(1, 0, 0, 0));
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			  int value=Integer.parseInt(moneygiven.getText());
			 int back=value-amountvar;
			 mback.setText(Integer.toString(back));
			 
			}
		});
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		btnBack.setBackground(Color.BLACK);
		btnBack.setBounds(471, 256, 82, 29);
		contentPane.add(btnBack);
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(255, 245, 238));
		toolBar.setBounds(0, 0, 1362, 30);
		contentPane.add(toolBar);
		
		 
		JButton ref_data = new JButton("");
		ref_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				
				 cupoftea.setText("0");
				 numberofbiscuit.setText("0");
				 numberofruti.setText("0");
				 cupofcoffee.setText("0");
				 cigqun5.setText("0");
				 cigqun8.setText("0");
				 cigqun11.setText("0");
				 colt25.setText("0");
				 colt5.setText("0");
				 colt1.setText("0");				
				 //amount.setText("0");
				 cigcb8.setSelected(false);
			     cigcb11.setSelected(false);
				 cigcb5.setSelected(false);
				 coldcb25.setSelected(false);
				 coldcb5.setSelected(false);
				 coldcb1.setSelected(false);
				 amount.setText("0"); 
			
			     itemlv();
			     
			        XYDataset dataset2=createDataset();
					JFreeChart chart2=ChartFactory.createXYLineChart("Sell Every Two Hour", "Hour", "Sell", dataset2, PlotOrientation.VERTICAL, true, true, false);
//					CategoryPlot catplot2=chart2.getCategoryPlot();
//					catplot2.setRangeGridlinePaint(Color.WHITE);
//					
					ChartPanel chartPanel2=new ChartPanel(chart2);
					
					sellafttwolvl.removeAll();
					sellafttwolvl.add(chartPanel2, BorderLayout.CENTER);
					sellafttwolvl.validate();
			}				
		});
		 
		ref_data.setBackground(Color.WHITE);
		ref_data.setToolTipText("Refresh Data Tables");
		ref_data.setIcon(new ImageIcon("C:\\Users\\Didarul Alam Rahat\\workspace1\\inventory\\Image\\Renew1.jpg"));
		toolBar.add(ref_data);
		
		JSeparator separator_10 = new JSeparator();
		separator_10.setBounds(471, 523, 210, 2);
		contentPane.add(separator_10);
 
	}	
	}
		 
		//make jframe center on the screen
		 	
		/*
		Author:Diarul Alam rahat
		Project Intro:It's a project of L3 T-3 
		Sub :OOSD
		Email:darahat42@gmail.com
		*/
		 
		
		 
	

