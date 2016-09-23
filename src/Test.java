
import java.awt.Color;

import com.thehowtotutorial.splashscreen.JSplash;

import inventory.inventory;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       try{
//		JSplash splash=new JSplash(Test.class.getResource("tea.jpg"), true, true, false, "V1", null, Color.RED, Color.PINK);
		
		
//       splash.splashOn();
//       splash.setProgress(20,"Initialize Resourse File.......");
//       Thread.sleep(900);
//       splash.setProgress(40,"Loading.........");
//       Thread.sleep(1500);
//       splash.setProgress(60,"Loading.........");
//       Thread.sleep(1500);
//       splash.setProgress(70,"Copying Resourse File.........");
//       Thread.sleep(3000);
//       splash.setProgress(80,"Applying configs......");
//       Thread.sleep(1500);
//       splash.setProgress(90,"Starting app....");
//       Thread.sleep(500);
//       splash.setProgress(100,"Load Completed....");
//       Thread.sleep(2000);
//       splash.splashOff();
       inventory invnt=new inventory();
       invnt.setVisible(true);
       }
       catch(Exception e){
    	   
    	   
       }
       }

}
