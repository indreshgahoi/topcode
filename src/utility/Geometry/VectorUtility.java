package utility.Geometry;


class CustomPoint implements Cloneable
{
	double X;
	double Y;
	
	public CustomPoint(double X,double Y)
	{
		this.X=X;
		this.Y=Y;
	}

	/* If Object has primitive type or immutable object then it create clone
	 * of object (memory copy) by super clone methods  
	 * @see java.lang.Object#clone()
	 */
	
	@Override
	protected CustomPoint clone() throws CloneNotSupportedException {

		return (CustomPoint) super.clone();
	}
}

class Circle
{
	CustomPoint center;
	double radius;
	
	public Circle(CustomPoint center,double radius) 
	{
		try
		{
		this.center=center.clone();
		}
		catch(CloneNotSupportedException ex)
		{
			System.out.println("clonre is not supported by center object");
		}
		this.radius=radius;
	}
}


class Vector2D 
{
	 /*  vec OP1   and vec OP2
	  *  vec P1P2=OP2-OP1;
	  */
	public Vector2D(CustomPoint p1,CustomPoint p2)
	{
		this.X=p2.X-p1.X;
		this.Y=p2.Y-p1.Y;
	}
	
	public Vector2D(double X,double Y)
	{
	  this.X=X;
	  this.Y=Y;
	}
	
	public Vector2D(CustomPoint P)
	{
		this.X=P.X;
		this.Y=P.Y;
	}
	public Vector2D add(Vector2D V1)
	{
		
		return new Vector2D(this.X+V1.X,this.Y+V1.Y);
	}
	public Vector2D sub(Vector2D V1)
	{
		
		return new Vector2D(this.X-V1.X,this.Y-V1.Y);
	}
	
	
	double mod()
	  {
		return Math.sqrt(this.X*this.X+this.Y*this.Y); 
	  }
	
	 double X;
	 double Y;
}


public class VectorUtility
{
	
  /*                A /
   *                 /
   *                /  theta
   *  (Ref Point) O/_)____________ B 
   *    (Origin)   
   *       --> -->
   *        A . B   =|A|*|B|cos(theta)
   *        
   *                        --> -->    
   *                        A  . B
   *       cos(theta)=  --------------
   *                        |A|*|B|
   */
	

 
	
 static double dot(Vector2D OA,Vector2D OB)
 {
	
	 /*
	  *   OA= xa i+ ya j 
	  *   OB= xb i+ yb j
	  * 
	  *   a,b= (xa i+ ya j ).(xb i+ yb j)
	  *      =(xa*xb) + (ya*yb)
	  * 
	  */
	 return (OA.X*OB.X)+(OB.X*OB.Y);
  }


  static void inversePoint(CustomPoint p)
  {
	  p.Y*=-1;
  }
 
  
  static void transalatePointToPoint(CustomPoint point,CustomPoint to)
  {
	  point.X-=to.X;
	  point.Y-=to.Y;
  }

}



































 