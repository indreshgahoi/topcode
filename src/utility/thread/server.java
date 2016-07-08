package utility.thread;

import java.net.*;
import java.io.*;

class server
{
	public static void main(String[] str)
	{
		try{
		ServerSocket s=new ServerSocket(8009);
		while(true)
		{
			Socket clientConn = s.accept();
			
			OutputStream out = clientConn.getOutputStream();
			InputStream  in = clientConn.getInputStream(); 
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			bw.write("Hello Students\n");
			bw.close();
			clientConn.close();
		}
		}catch(Exception e){}
	}
}


class Handler{
	
	public Handler(Socket conn, BufferedReader br, BufferedWriter bw){
		
	}
	
	
	
}

class Reader implements Runnable {
	
	
	public Reader(Handler handler){
		
	}
	
		public void run() {
			
		}
	
}
