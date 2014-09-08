package utility.thread;

/* Condition For DeadLock
 *  1 => Mutual Exclusion
 *  2 => Non - premption
 *  3 => Acquire and Wait
 *  4 => Circular Lock Acquire
 * 
 * 
 * 
 * 
 */

public class DeadLoack {

	Object r1 = "Resource 1";
	Object r2 = "Resource 2";

	Thread thrd1 = new Thread() {
		public void run() {
		  synchronized (r1) {
		    System.out.println("Thread is Aquired Resource 1");        	
		  }	
		}
	};

}
