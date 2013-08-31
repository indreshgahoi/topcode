import java.io.*;
import java.net.*;
class client
{
	public static void main(String[] str)
	{
		try{
		
			Socket s1=new Socket("172.20.2.88",8009);
			InputStream in=s1.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			System.out.println(br.readLine());
			br.close();
			s1.close();
		
		}catch(Exception e){}
	}
}
