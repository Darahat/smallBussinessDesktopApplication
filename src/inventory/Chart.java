package inventory;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.ApplicationFrame;
import java.awt.GridLayout;

import java.sql.*;
import javax.swing.*;
 
public class Chart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart frame = new Chart();
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
	 JPanel panel_1 = new JPanel();
		
	 private static XYDataset createDataset2()
	{
		DefaultXYDataset ds=new DefaultXYDataset();
		double[][]data={{1,2,3,4,4,12,14,16,18,20},{22210,332125,11451,12360,4855,10133,44240,65325,33452,11732}};
		ds.addSeries("selling rate", data);
	    return ds;
	}
	private static XYDataset createDataset()
	{
		DefaultXYDataset ds=new DefaultXYDataset();
		double[][]data={{2,4,6,8,10,12,14,16,18,20},{210,125,451,360,855,133,240,325,452,732}};
		ds.addSeries("sellinrate", data);
	    return ds;
	}
	public void line(){
		DefaultXYDataset ds=new DefaultXYDataset();
		double[][]data={{2,4,6,8,10,12,14,16,18,20},{210,125,451,360,855,133,240,325,452,732}};
		ds.addSeries("selling rate every hour", data);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
	      dataset.addValue( 15 , "schools" , "1970" );
	      dataset.addValue( 30 , "schools" , "1980" );
	      dataset.addValue( 60 , "schools" ,  "1990" );
	      dataset.addValue( 120 , "schools" , "2000" );
	      dataset.addValue( 240 , "schools" , "2010" );
	      dataset.addValue( 300 , "schools" , "2014" );
	      XYDataset dataset2=createDataset2();
		  JFreeChart chart=ChartFactory.createXYLineChart("Business Progress", "Month", "Sell Rate", dataset2, PlotOrientation.VERTICAL, true, true, false);
//		  CategoryPlot catplot2=chart.getCategoryPlot();
//		  catplot2.setRangeGridlinePaint(Color.WHITE);
	      ChartPanel chartPanel=new ChartPanel(chart);
			
			panel_1.removeAll();
			panel_1.add(chartPanel, BorderLayout.CENTER);
			panel_1.validate();
	   
	}
	   	public Chart() {
		con=Main.dbConnector();
		setTitle("S.S.R.M COFFEE HOUSE CHARTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 658, 325);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(678, 11, 658, 325);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 347, 658, 325);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(678, 347, 658, 325);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setSize(1400,730);
		setLocationRelativeTo(null);
		 
		 
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.setValue(10, "1", "Tea");
	    dataset.setValue(23, "2", "Coffee");
	    dataset.setValue(23, "3", "Biscuit");
	    dataset.setValue(14, "4", "Ruti/Cake");
	    dataset.setValue(60, "5", "Cig_5");
	    dataset.setValue(60, "6", "Cig_8");
	    dataset.setValue(56, "7", "Cig_12");
	    dataset.setValue(8, "8", "Cold_25");
	    dataset.setValue(15, "9", "Cold_5");
	    dataset.setValue(3,"10","Cold_1");
	    
	    
	    JFreeChart chart=ChartFactory.createBarChart("Item Level", "Item", "Quantity", dataset, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot catplot=chart.getCategoryPlot();
		catplot.setRangeGridlinePaint(Color.white);
		
		ChartPanel chartPanel=new ChartPanel(chart);
		
		panel.removeAll();
		panel.add(chartPanel, BorderLayout.CENTER);
		panel.validate();
		
		XYDataset dataset2=createDataset();
		JFreeChart chart2=ChartFactory.createXYLineChart("Sell Every Two Hour", "Hour", "Sell", dataset2, PlotOrientation.VERTICAL, true, true, false);
//		CategoryPlot catplot2=chart2.getCategoryPlot();
//		catplot2.setRangeGridlinePaint(Color.WHITE);
//		
		ChartPanel chartPanel2=new ChartPanel(chart2);
		
		panel_1.removeAll();
		panel_1.add(chartPanel2, BorderLayout.CENTER);
		panel_1.validate();
		 
		XYDataset dataset1=createDataset2();
		JFreeChart chart1=ChartFactory.createXYLineChart("Business Progress", "Month", "Sell Rate", dataset1, PlotOrientation.VERTICAL, true, true, false);
//		CategoryPlot catplot1=chart1.getCategoryPlot();
//		catplot1.setRangeGridlinePaint(Color.WHITE);
		
		ChartPanel chartPanel1=new ChartPanel(chart1);
		
		panel_2.removeAll();
		panel_2.add(chartPanel1, BorderLayout.CENTER);
		panel_2.validate();
		 
		
		 
		 
		
		 DefaultPieDataset pieDataset=new DefaultPieDataset();
		 pieDataset.setValue("Buy item", new Integer(50));
		 pieDataset.setValue("Maintanence", new Integer(15));
		 pieDataset.setValue("Employee salary", new Integer(30));
		 pieDataset.setValue("Extra", new Integer(5));
		// JFreeChart chart4=ChartFactory.createPieChart("Budget Distribution", pieDataset, rootPaneCheckingEnabled, rootPaneCheckingEnabled,chart, true, true, true);
		 JFreeChart chart4=ChartFactory.createPieChart("Budget", pieDataset, true, true, true);
	    // PiePlot P=(PiePlot)chart.getPlot();
	     //P.setForegroundAlpha(TOP_ALIGNMENT);
//	     ChartFrame frame=new ChartFrame("Pie Chart",chart);
//	     frame.setVisible(true);
//	     frame.setSize(400,500);
         CategoryPlot catplot3=chart.getCategoryPlot();
         ChartPanel chartPanel13=new ChartPanel(chart4);
         panel_3.removeAll();
         panel_3.add(chartPanel13, BorderLayout.CENTER);
         panel_3.validate();
	}
		
}

 

