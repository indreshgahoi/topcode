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
			Socket s1=s.accept();
			OutputStream out=s1.getOutputStream();
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));
			bw.write("Hello Students\n");
			bw.close();
			s1.close();
		}
		}catch(Exception e){}
	}
}
