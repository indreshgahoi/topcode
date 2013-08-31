package utility.thread;

public class SleepMessages {
	/*
	 * Thread.sleep causes the current thread to suspend execution for a
	 * specified period. This is an efficient means of making processor
	 * time available to the other threads of an application 
	 */
	
	/*
	 * InterruptedException. This is an exception that sleep throws when
	 * another thread interrupts the current thread while sleep is active.
	 */
	
    public static void main(String args[]) throws InterruptedException {
       
    	String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}
