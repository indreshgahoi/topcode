//package utility.codechef.JAN2014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;




interface Solution
{
	public void solve(InputReader in , PrintWriter out) ;
}

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
	    InputStream inputstream=null;
	    Solution task= new MagicTrick();
	    inputstream=System.in;
	   // inputstream = new FileInputStream("src//utility//codechef//JAN2014//input.txt") ;    
	    OutputStream outputstraem=System.out;
	    InputReader in = InputReader.getInputReader(inputstream);
	    PrintWriter out= new PrintWriter(outputstraem);
	    task.solve( in, out);
	    out.close();
	    
	}
}


class MagicTrick implements Solution
{
	
	long A ,C , B; 
	//BigInteger B ;
	
	public void solve(InputReader in , PrintWriter out)
	{
		int T = in.nextInt() ;
		int max = 1005 , iter ;
		int N ;
		long  [] arr = new long[max] ;
		
		while(T-->0)
		{
			N = in.nextInt() ;
			iter = 0 ;
			while(N-->0)
			{
				arr[iter] = in.nextLong();
				iter++ ;
			}
			
			A =  in.nextLong();
			B =  in.nextLong() ; //new BigInteger(in.next());
			C = in.nextLong(); //new BigInteger(in.next());
			
			String op = in.next() ;
			int charIter = 0 , start , tstart , end , tend;
			boolean isRev = false ;
			
			start = 0 ;
			end = iter-1 ;
			
			while(charIter < iter)
			{
				tstart = start ;
				tend = end ;
				if(!isRev)
				{
					switch (op.charAt(charIter))
					{
					case 'A':
						while(tstart<=tend)
						{
							 arr[tstart]+=A ;
							 arr[tstart]%=C ;
							 tstart++ ;
						}
						break;
					case 'M':
						while(tstart<=tend)
						{
							arr[tstart]= ((arr[tstart]%C)*(B%C))%C ;
							// arr[start]=arr[start].mod(C) ;
							 tstart++ ;
						}
						break;
					case 'R':
						isRev = !isRev ;
						break;
					
					}
					out.print(arr[start]+" ");
					start++ ;
				}
				else
				{
					switch (op.charAt(charIter))
					{
					case 'A':
						while(tstart<=tend)
						{
							 arr[tstart]+=A ;
							 arr[tstart]%=C ;
							 tstart++ ;
						}
						break;
					case 'M':
						while(tstart<=tend)
						{
							// arr[tstart]= new BigInteger(B+"", ) ;
							// arr[start]=arr[start].mod(C) ;
							 tstart++ ;
						}
						break;
					case 'R':
						isRev = !isRev ;
						break;
					
					}
					out.print(arr[end]+" ");
					end-- ;
				}
				charIter++ ;
			}
			out.println("") ;
			
		}
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