/*
 * Name =Indresh
 */
package utility.preparation.graph.dfs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;





class node {
	int x,y;
	public node(int x,int y) {
		this.x=x;
		this.y=y;
	}
}



public class GrafixMask {
	
	boolean [][]fill;
	
	void fill(int x1,int x2,int y1,int y2){
		for(int i=x1;i<=x2;i++)
			for(int j=y1;j<=y2;j++)
				fill[i][j]=true;
	}
	
	int dofill(int x,int y){
		Stack<node> stack=new Stack<node>();
		stack.push(new node(x,y));
		
		int result=0;
		while(!stack.empty()){
			node top=stack.pop();
			if(top.x<0 || top.x>=400)
				continue;
			if(top.y<0 || top.y>=600)
				continue;
			if(fill[top.x][top.y])continue;
			fill[top.x][top.y]=true;
			result++;
			stack.push(new node(top.x,top.y+1));
			stack.push(new node(top.x,top.y-1));
			stack.push(new node(top.x+1,top.y));
			stack.push(new node(top.x-1,top.y));
		}
		return result;
	}
	
	public int[] sortedAreas(String[] rectangles)
	{   
		List<Integer> result=new ArrayList<Integer>();
	  	fill=new boolean[400][600];
	  	
	  	for(int i=0;i<rectangles.length;i++)
	  	{
	  		String[] st=rectangles[i].split(" ");
	  		//System.out.println(""+st[0]+" "+st[1]+" "+st[2]+""+" "+st[3]);
	  		fill(Integer.parseInt(st[0]),Integer.parseInt(st[2]),Integer.parseInt(st[1]),Integer.parseInt(st[3]));
	  	}
	  	for(int x=0;x<400;x++)
	  		for(int y=0;y<600;y++){
	  			if(fill[x][y]==false)
	  				result.add(dofill(x, y));
	  		}
	  	Collections.sort(result);
	  	int []a=new int[result.size()];
	  	for(int i=0;i<result.size();i++)
	  		a[i]=result.get(i);
      return  a;
	}
   
	
	
	

}
