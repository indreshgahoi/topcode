package utility.Geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class VectorTest extends JFrame 
{
 
 public VectorTest(String title)
  {
	  setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	  setTitle(title);
	  setVisible(true);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  mHandler=new MouseHandler();
	  mListener=new MouseMotionListener();
	  mHandler.delegate=this;
	  mListener.delegate=this;
	  addMouseListener(mHandler);
	  addMouseMotionListener(mListener);
	  origin=new CustomPoint(DEFAULT_WIDTH/2+.0,-DEFAULT_HEIGHT/2+.0);
	  CustomPoint circleCenter=new CustomPoint(DEFAULT_WIDTH/2,DEFAULT_HEIGHT/2);
	  circle=new Circle(origin, DEFAULT_WIDTH/8);
   // VectorUtility.transalatePointToPoint(point, to)
 }	
	
	public static void main(String[] args)
	{
	   VectorTest frame=new VectorTest("MY Co-ordinate");	
	   
	   
	}
	
	
	public void touchPoint(Point p)
	{
		
		CustomPoint cp=new CustomPoint(p.x+.0, p.y+.0);
		try{
		circle.center=cp.clone();
		}
		catch (Exception ex)
		{
			
		}
		VectorUtility.inversePoint(cp);
		VectorUtility.transalatePointToPoint(cp, origin);
		System.out.println("x="+cp.X+"y="+cp.Y);
		
		//circle.center=cp;
		this.repaint();
		
	}
	
	
	
	@Override
		public void paint(Graphics g) {
			paintComponents(g);
		}
	
	
	public void paintComponents(java.awt.Graphics g) 
	{
		
		
	 Graphics2D g2=(Graphics2D) g;	
	 float red=155/255;
	 float green=100/255;
	 float blue=80/255;
	 g.setColor(new Color(red,green,blue));
	 
	 g.drawLine(0, DEFAULT_HEIGHT/2, DEFAULT_WIDTH,DEFAULT_HEIGHT/2);
	 g.drawLine(DEFAULT_WIDTH/2, 0, DEFAULT_WIDTH/2,DEFAULT_HEIGHT);
	 
	 g.setColor(Color.green);
	
	 Ellipse2D ecircle=new Ellipse2D.Double();
	 ecircle.setFrame(circle.center.X-circle.radius,circle.center.Y-circle.radius, 2*circle.radius, 2*circle.radius);
	 g2.draw(ecircle);
	 
	};
	
	
	
	
	
	
	Circle circle;
	
	CustomPoint origin;
	MouseHandler mHandler;
	MouseMotionListener mListener;
	
	
	public static final int DEFAULT_WIDTH=500;
	public static final int DEFAULT_HEIGHT=500;
}



class MouseHandler extends MouseAdapter
{
	
	VectorTest delegate;
	 @Override
	public void mousePressed(MouseEvent e)
	{
		
		Point p=e.getPoint();
		delegate.touchPoint(p);
	}
	 
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
		Point p=e.getPoint();
		//delegate.touchPoint(p);
		//delegate.repaint();
	} 
	
}



class DrawComponent extends JComponent
{
	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}
}








class MouseMotionListener implements java.awt.event.MouseMotionListener
{
	
	VectorTest delegate;
	
	public void mouseMoved(MouseEvent e)
	{
		Point p=e.getPoint();
		//delegate.touchPoint(p);
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		Point p=e.getPoint();
		delegate.touchPoint(p);
	}
	

}



 /*
  * 
  * 
  * 
  */



