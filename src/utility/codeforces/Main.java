package utility.codeforces;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class Main {
	
	public static void main(String[] args) {
	    InputStream inputstream=System.in;
	    OutputStream outputstraem=System.out;
	    InputReader in = InputReader.getInputReader(inputstream);
	    PrintWriter out= new PrintWriter(outputstraem); 
	
	    Task task= new Task();
	    task.solver(1, in, out);
	    out.close();
	}
}


class Task {
	
	void  solver(int testCase ,InputReader in,PrintWriter out){
		 
		 String s=in.next();
         Integer x=0,y=0;
		 for(int i=0;i<s.length();i++)
		 
			 if(s.charAt(i)=='x'){x++;}else y++;
		     char ch;int times;
		     if((x>y)){
		    	 times=x-y;ch='x';}
		     else{
		    	 times=y-x;ch='y';  
		     }
		     
	
			for (int i = 0; i < times; i++) 
				System.out.println(""+ch);
		  
         
		    
	   
		
	}
	
}




class InputReader {
	
	BufferedReader br;
	StringTokenizer st;
	private static InputReader input;
	
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



