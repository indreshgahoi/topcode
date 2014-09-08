package SocketProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.imageio.stream.FileImageInputStream;

public class EchoClient {

	PrintWriter out ;
	BufferedReader in ;
	BufferedReader stdIn ;
	Socket echoClient ;
	
	public boolean createConnection(String hostName ,int portNumber)
	{
		try {
			echoClient = new Socket(hostName, portNumber);
			out = new PrintWriter(echoClient.getOutputStream()) ;
			in = new BufferedReader(new InputStreamReader(echoClient.getInputStream()));
			stdIn = new BufferedReader(new InputStreamReader(System.in));
		}
		catch(IOException ex){
			
		}
		return true ;
	}
	
	public void send(String str)
	{
		out.println(str);
		System.out.println("sended Data ***** "+str+"*****");
	}
	public String received()
	{
		String result="" ;
		try {
			while((result=in.readLine()) != null)
			{
			          System.out.println("Server Data ******* "+result+"  ");	
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 return result ;
	}
	
	@Override
	protected void finalize() throws Throwable {
		echoClient.close() ;
		super.finalize();
		
	}
	
	public static void main(String[] args) {
		
		String hostName = args[0] ;
		int portNumber = Integer.parseInt(args[1]);
		EchoClient echoClient = new EchoClient() ;
		echoClient.createConnection(hostName, portNumber) ;
		//BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"))) ;
	}
}
