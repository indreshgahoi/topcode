package utility.dynamicprogramming;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZigZagSequence {

	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	
public static void main(String[] args) throws IOException {
	BufferedReader in;
	ZigZagSequence input=new ZigZagSequence();
   
	in=input.in=new BufferedReader(new InputStreamReader(System.in));
	String line=null;
	while((line=in.readLine())!=null){
	
	input.st=new StringTokenizer(line," ,\\{\\}");
	int[] a=new int[input.st.countTokens()];
	int i=0;
	 while(input.st.hasMoreTokens())
	 {
		  a[i]=Integer.parseInt(input.st.nextToken());
		  System.out.println("a["+i+"]= "+a[i]);
	      i++;
	     
	      
	 }
	 System.out.println("result= "+input.solve(a));
	}
	
}

public int solve(int[] a)
{
 int not_define=0;
 int positive=1;
 int negative=2;
 int [] len=new int[a.length];	
 int [] sign=new int[a.length];
 
 for(int i=0;i<a.length;i++)
	 len[i]=1;
 for(int i=0;i<a.length;i++)
	 sign[i]=not_define;
 
 for(int i=1;i<a.length;i++)
 { 
	 System.out.print("i="+i);
	 for(int j=0;j<i;j++)
	 {
		 if(sign[j]==not_define)
		 {  
			    if(a[i]<a[j] && len[j]+1>len[i])
			    {  
				    sign[i]=negative;
				    len[i]=len[j]+1;
			    }
			    else if(a[i]>a[j] && len[j]+1>len[i])
			    { 
				     sign[i]=positive;
				     len[i]=len[j]+1;
				     
			    }
		 }
		 else if (sign[j]==negative)
		 {
			 if(a[i]>a[j] && len[j]+1>len[i])
		     {
				 
			  sign[i]=positive;
			  len[i]=len[j]+1;
			 
		     }
			 
		 }
		else if(sign[j]==positive)
		{
			if(a[i]<a[j] && len[j]+1>len[i])
			{   
				sign[i]=negative;
				len[i]=len[j]+1;
				
			}
			
		}
		
	 }
	 
 }
 
 
 int max=Integer.MIN_VALUE;
 for(int i=0;i<a.length;i++)
	 if(len[i]>max)
		  max=len[i];
 return max;
 
 
}


}
