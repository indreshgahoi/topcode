package utility.codechef.cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



class TheArmy {

	
	public static void main(String[] args) {
	    InputStream inputstream=null;
	    TaskC task= new TaskC();
	 
	    	inputstream=System.in;
	
	    OutputStream outputstraem=System.out;
	    InputReader in = InputReader.getInputReader(inputstream);
	    PrintWriter out= new PrintWriter(outputstraem);
	    task.solver( in, out);
	    out.close();
	    
	}

}


class TaskC {
	
	public void solver(InputReader in ,PrintWriter out){
		 
		int T = in.nextInt();
		while(T-->0){
			int N = in.nextInt();
			int M = in.nextInt() ;
			int max = -1 ;
			int min = N+1;
			for(int i = 0 ; i < M ; ++i){
				int num = in.nextInt();
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			for(int i = 0 ; i < N ; ++i){
				
				out.print(Math.max(Math.abs(i-min), Math.abs(i-max))+" ");
				
			}
			out.println();
			
		}
			
	}
		
	
}
//class InputReader {
//	
//	BufferedReader br;
//	StringTokenizer st;
//	static InputReader input;
//	
//	private InputReader(InputStream stream){
//		br=new BufferedReader(new InputStreamReader(stream));
//		input=this;
//		st=null;
//	}
//	
//	public static InputReader getInputReader(InputStream stream)
//	{  if(input==null)
//		input= new InputReader(stream);
//		return input;
//	}
//	
//	public static InputReader getInputReader() {
//	 return input;
//	}
//	
//	
//	public String next(){
//		
//		String line="";
//		while((st==null || !st.hasMoreElements()) && line!=null)
//		{
//			try {
//				line=br.readLine();
//				//System.out.println(line);
//				if(line!=null)
//				st=new StringTokenizer(line);
//			 } 
//			  catch (IOException e) {
//				e.printStackTrace();
//				throw new RuntimeException(e);
//			   }
//			
//		 }
//		return st.hasMoreElements()?st.nextToken():null;
//		
//	}
//	
//	
//	public long nextLong() {
//		return Long.parseLong(next());
//	}
//	
//	public int nextInt() {
//		return Integer.parseInt(next());
//	}
//	
//	
//}
