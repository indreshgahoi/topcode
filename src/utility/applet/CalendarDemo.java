package utility.applet;

import java.util.Calendar;


class CalendarDemo{

    public static void main(String args[]){
	
	String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dev"};
	Calendar cal = Calendar.getInstance();
	System.out.println("Date :");
	System.out.println(months[cal.get(Calendar.MONTH)]);
	System.out.println(" "+ cal.get(Calendar.DATE));
	System.out.println(" "+ cal.get(Calendar.YEAR));
	
	
	}


}