package utility.applet;

import java.awt.*;
import java.applet.*;
/*<applet  code ="MyApplet"height=200 width=200>
</applet>*/

public class MyApplet extends Applet implements Runnable{
       Thread t =null;   
	String msg;
	  boolean stopFlage;
      public void paint(Graphics g){
	  g.drawString("I Like Applet Program",50,40);
	 
     }
	 public void init(){
	 
	setBackground(Color.cyan);
	setForeground(Color.red);
	
	 }
	 public void start(){
	 t = new Thread(this);
	 stopFlage = false;
	 t.start();
}
public void run(){
  char ch;
  for( ; ; ){
  try{
  
     repaint();
	 Thread.sleep(250);
	 ch =msg.charAt(0);
	 msg =msg.substring(1,msg.length());
	 msg +=ch;
	 if(stopFlage)
	 break;
  }catch(InterruptedException e) {}
  }
  
}
public void stop(){

  stopFlage= true;
  t=null;

}
}