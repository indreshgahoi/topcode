package utility.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class InputReader {
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
				if(line!=null)
				st=new StringTokenizer(line);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
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
	
	
	
/*	public static void main(String[] args) {
		InputStream inputstream=System.in;
		OutputStream outputstraem=System.out;
		InputReader input = InputReader.getInputReader(inputstream);
		PrintWriter output= new PrintWriter(outputstraem); 
		
      
		
		output.close();
		}
   */
}


