package utility.concept;

public class Test {

	
	 /**
	 * @param args
	 */
	
	public void stringTest()
	{
		 String str1 = "ABC" ;
		 String str2 ="ABC" ;
		 if(str2==str1)
		 {
			 System.out.println("we both have same address");
			 System.identityHashCode(str1);
		 }
		 else
		 {
			 System.out.println("No its not like that");
		 }
	}
	
	public static void main(String[] args) {
		
		 A a1 = new A();
		 A a2 = new B() ;
	
	    a1.add(3, 7);
	    a2.add(3, 7);
	
	}
}
