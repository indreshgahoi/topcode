package utility.concept;

class A {
   A()
   {
	   System.out.println("I m A Constructor");
   }
   
   public int add(int x , int y)
   {
	   System.out.println(" x+ y "+(x+y));
	   return x+ y ;
   }
   public int add(int x , int y , int z)
	{
		   System.out.println(" x+ y +z "+(x + y + z));
		   return x+y+z ;
	}
}

class B extends A
{
	B()
	{
		System.out.println("I B Destuctor");
	}
	
	
	
	public int add(float x , float y)
	{
		System.out.println("x + y + 10 "+(x + y +10));
		 
		return (int)(x + y + 10) ;
	}
}
