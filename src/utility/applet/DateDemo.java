package utility.applet;

import java.util.Date;

class DateDemo{
    public static void main(String args[]){
     Date date =new Date(); 
     System.out.println(date);
	 long msec = date.getTime();
	 System.out.println("milliseconds since jan. 1,1970 GMt = " +msec);
    }

}