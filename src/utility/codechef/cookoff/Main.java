package utility.codechef.cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;





public class Main {

	
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
	
	
	public int gcd(int a , int b){
		
		return (b==0) ? a : gcd(b,a%b);
	}
	
	
	public void solver(InputReader in ,PrintWriter out){
		
		int T = in.nextInt() ;
		while(T-->0){
			int N = in.nextInt();
			int a[] = new int[N];
			for(int i = 0 ; i < a.length ; ++i)
				a[i] = in.nextInt();
			int len = 1 , g = a[0] ;
			int maxLen = 1 ;
			for(int i = 1 ; i < a.length ; ++i){
				g = gcd(g,a[i]) ;
				if(g ==1){
					len++;
				}else {
					maxLen = Math.max(len, maxLen);
					len = 1 ;
					g = a[i] ;
				}
			}
			maxLen = Math.max(len, maxLen);
			if(maxLen==1){
				out.println("-1");
			}else{
				out.println(a.length);
			}
			
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
