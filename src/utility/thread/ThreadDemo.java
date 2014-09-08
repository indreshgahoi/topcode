package utility.thread;

/*
 * 
 * 
 * 
 */

public class ThreadDemo {
	public  boolean call ;	
	private int aResult ;
	
   int A()
   {
	   for(int i = 0 ; i < 100000;++i)
	   {
		   System.out.println("Hi in m A ==>"+i);
	   }
	   return 1 ;
   }
   
   void B()
   {
	   for(int i = 0 ; i < 100000;++i)
	   {
		   System.out.println("##############Hi in m B =>"+i);
	   }
   }
   
   
   
  
   void setResult(int x)
   {
	   aResult = x ;
   }
   
   
   public static void main(String[] args) throws InterruptedException {
	   ThreadDemo t = new ThreadDemo() ;
	   
	   
	  
	    
	    Entity1 r1 = new Entity1(t);
	    Entity r2 = new Entity(t) ;
	    Thread t1 = new Thread(r1) ;
	    Thread t2 = new Thread(r2) ;
	    t1.start();
	    t2.start();
	    t1.join();
	    t2.join();
	    int ares = (Integer)r2.a; 
	    System.out.println("Before-----------------ished");
	    //Thread.currentThread().join();
	    System.out.println("Hi I am Finished");
	    
	    
	    
   }

}

class Entity implements Runnable
{
  ThreadDemo tDemo ;
  public  Object a ;
	public void run() {
		
	int result=	tDemo.A();
	//tDemo.setResult(result);
		a = result ;	
	}
	public Entity(ThreadDemo t) {
		this.tDemo = t ;
		
	}
}


class Entity1 implements Runnable
{
  ThreadDemo tDemo ;
	public void run() {
		
		tDemo.B();
	}
	public Entity1(ThreadDemo t) {
		this.tDemo = t ;
	}
}
