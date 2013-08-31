package utility.codechef.FEB2013;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;






public class MagicBoardMain {
	
	public static void main(String[] args) {
	    InputStream inputstream=null;
	    Task task= new Task();
	 
	    	inputstream=System.in;
	
	    OutputStream outputstraem=System.out;
	    InputReader in = InputReader.getInputReader(inputstream);
	    PrintWriter out= new PrintWriter(outputstraem);
	    task.solver( in, out);
	    out.close();
	    
	}

}

class Task {
	BinaryIndexTree r0,r1,c0,c1;
	int [] row,col;
	boolean[] r,c;
	int M,N,t;
	public Task(){
		
		
	    t=0;
	}
	void  solver(InputReader in,PrintWriter out){
	    M=in.nextInt();
		N=in.nextInt();
		row=new int[M+10];
		r=new boolean[M+10];
		col=new int[M+10];
		c=new boolean[M+10];
		r0=new BinaryIndexTree( N+1000);
	    r1=new BinaryIndexTree(N+1000);
	    c0=new BinaryIndexTree(N+1000);
	    c1=new BinaryIndexTree(N+1000);
		Integer x,i,ca=0;
		for(int q=0;q<N;q++){
		String s=in.next();
		i=in.nextInt();
		ca=(s.equals("RowQuery"))?1:ca;
		ca=(s.equals("ColQuery"))?2:ca;
		ca=(s.equals("RowSet"))?3:ca;
		ca=(s.equals("ColSet"))?4:ca;
		switch(ca){
		case 1:System.out.println(""+rrq(i));
		break;
		case 2:out.println(""+rcq(i));
		break;
		case 3:x=in.nextInt();urq(i, x);break;
		case 4:x=in.nextInt();ucq(i, x);break;
		}
		
		}
         
 }
	void urq(int i,int x){
		int lasttime=row[i];
		t++;
		row[i]=t;
		if(r[i]){
			if(lasttime>0)
			r1.updateAt(lasttime,-1);//printtreee();

			if(x==1)
			{   
				r1.updateAt(t,1);//printtreee();
				r[i]=true;
			}
			else
			{

				r0.updateAt(t,1);//printtreee();
				r[i]=false;
			}
		}
		else{
			if(lasttime>0)
			r0.updateAt(lasttime,-1);
			if(x==1){
				r1.updateAt(t,1);//printtreee();
				r[i]=true;
			}
			else{
				r0.updateAt(t,1);//printtreee();
				r[i]=false;
			}
		}


	}
	void ucq(int i,int x){
		int lasttime=col[i];
			t++;

			col[i]=t;
			if(c[i]){
				if(lasttime>0)
				c1.updateAt(lasttime,-1);//printtreee();
				if(x==1)
				{
					c1.updateAt(t,1);//printtreee();
					c[i]=true;
				}
				else
				{
					c0.updateAt(t,1);//printtreee();
					c[i]=false;
				}
			}
			else
			{
				if(lasttime>0)
				c0.updateAt(lasttime,-1);//printtreee();
				if(x==1){
					c1.updateAt(t,1);//printtreee();
					
					c[i]=true;
				}
				else{
					c0.updateAt(t,1);//printtreee();
					c[i]=false;
				}
			}

	}

	int rrq(int i){
		t++;
		 if(r[i])
		 {
		   return	 c0.rangeQuery(row[i], t);
		 }
		 else 
		 {
		 //System.out.println("Ans");	 
		 return	 (M-c1.rangeQuery(row[i], t) );
		 }
		 }
	
	int rcq(int i)
	{
		t++;
		
		return (c[i])?r0.rangeQuery(col[i], t) :(M-r1.rangeQuery(col[i], t) );
	}
 void printtreee(){
	 System.out.println();
	 System.out.print("For tree r0 ");
	 for(int i=0;i<N+10;i++)
		 System.out.print(" "+r0.ftree[i]);
	 System.out.println();
	 System.out.print("For tree r1 ");
	 for(int i=0;i<N+10;i++)
		 System.out.print(" "+r1.ftree[i]);
	 System.out.println();
	 System.out.print("For tree c0 ");
	 for(int i=0;i<N+10;i++)
		 System.out.print(" "+c0.ftree[i]);
	 System.out.println();
	 System.out.print("For tree c1 ");
	 for(int i=0;i<N+10;i++)
		 System.out.print(" "+c1.ftree[i]);
	 
	 System.out.println("");
	 
 }

}


class BinaryIndexTree{
	int[] ftree;
	
	public BinaryIndexTree(Integer size){
		
		ftree=new int[size];
		
	}
	
	
	
	
	public void updateAt(Integer idx,Integer newValue){
		Integer maxValue=ftree.length;
		
		while(idx<maxValue){
			ftree[idx]+=newValue;
		   idx|=(idx +1);
		}
	}
	
	public Integer sum(Integer idx){
		Integer sum=0;
		while(idx>=0){
			sum+=ftree[idx];
			idx=(idx&(idx+1))-1;	
		}
		return sum;
	}
	  public Integer rangeQuery(Integer a,Integer b) {
		return sum(b)-sum(a-1);
		}
	public Integer readAt(int idx){
		Integer value=ftree[idx];
		//find predecessor of idx
		Integer z=idx-(idx & -idx);
		idx--;
		while(z!=idx){
			value-=ftree[idx];
			idx-=(idx & -idx);
		}
		return value;
	}
	
	public Integer findFrequencySum(Integer target){
		Integer idx=0,currentIdx=0;
		Integer bitmask=ftree.length-1;
		
		while(bitmask!=0 && idx<(ftree.length-1)){
			currentIdx=idx+bitmask;
			if(target==ftree[currentIdx])
				return currentIdx;
			if(target>ftree[currentIdx]){
				target-=ftree[currentIdx];
				idx=currentIdx;
			}
			bitmask>>=1;
		}
		if(target!=0)
			return -1;
		else
			return idx;
		
	}
	
}
class InputReader {
	
	BufferedReader br;
	StringTokenizer st;
	static InputReader input;
	
	private InputReader(InputStream stream){
		br=new BufferedReader(new InputStreamReader(stream));
		input=this;
		st=null;
	}
	
	public static InputReader getInputReader(InputStream stream)
	{  if(input==null)
		input= new InputReader(stream);
		return input;
	}
	
	public static InputReader getInputReader() {
	 return input;
	}
	
	
	public String next(){
		
		String line="";
		while((st==null || !st.hasMoreElements()) && line!=null)
		{
			try {
				line=br.readLine();
				//System.out.println(line);
				if(line!=null)
				st=new StringTokenizer(line);
			 } 
			  catch (IOException e) {
				
				e.printStackTrace();
				throw new RuntimeException(e);
			   }
			
		 }
		return st.hasMoreElements()?st.nextToken():null;
		
	}
	
	
	public long nextLong() {
		return Long.parseLong(next());
	}
	
	public int nextInt() {
		return Integer.parseInt(next());
	}
	
	
}
