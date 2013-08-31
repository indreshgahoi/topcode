package utility.dynamicprogramming.RMQandLCA;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;


import utility.ArrayUtility;
import utility.DebugUtility;
import utility.input.NextInteger;
import utility.input.InputReader;
import utility.input.NextInput;

public class RMQDataStructure   {
	
	
	
	
	/*    Trival Algorithm For RMQ
	 *     (Range Mininmum Query)
	 *      RMQ(i,j)= indices of the Minimum element of A between(i...j)
	 *       
	 *       RMQ(i,j)= indices of Min(Ai,Ai+1,....Aj-1,Aj) 
	 *   This Algorithm 
	 *   ProcessingTime=O(n^2)
	 *   QueryTime=O(1)
	 *   Space Complexity=O(n^2)
	 *   
	 *   it won't work large cases because N^2 space complexity
	 */
	
	void RMQPreprocess(int M[][],int A[],int N)
	{
	    int i,j;
	    for(i=0;i<N;i++)
	    	M[i][i]=0;
	    
	    for(i=0;i<N;i++)
           for(j=i+1;j<N;j++)
        	   M[i][j]=(A[M[i][j-1]]<A[j])? M[i][j-1]:j;
        	   /*
        	    * yadi i se lekar j-1 tak ka miminmum A[j] se kam hai to
        	    * M[i][j] me j dal do kyo ki for i to j  minimum is A[j] 
        	    * 
        	    */
           
	}
	
	/*
	           ProcessingTime=O(NlogN)
			   QueryTime=O(N)
			   Space Complexity=O(N)
			 
			   it won't work large cases because N^2 space complexity
	 */
	
        void RMQPreProcess(Integer B[],Integer A[],int N){
        	
        	
        	Integer block=(int)((N/Math.sqrt(N+.0))+1);
        	Integer size=(int)((Math.sqrt(N+.0))+1);
        	
            for(int i=0;i<N;i++){
        		if(B[i/size]==null)
        			B[i/size]=i;
        		if(A[B[i/size]]>=A[i]){
        			B[i/size]=i;
        		}
        		
        	}
        	
        	String row1="",row2="";
        	for(int i=0;i*size<=N;i++){
        		row1+=" i="+i+" ";
        		row2+=" ["+B[i]+"] ";
        	}
        	System.out.println(""+row1+"\n"+row2);	
        	
	
         }
        public int SqrtNQuery(Integer B[],Integer A[],Integer l,Integer r,Integer N){
        	
        	int size=(int)(Math.sqrt(N+.0))+1;
        	 int res=l;
        	for(int i=l;i<=r ;)
        	{
        		if(i%size==0 && i+size-1<r){
        			res=A[B[i/size]];i+=size;
        		}
        		else{
        			if(A[i]<A[res]){
        				res=i;
        				
        			}
        		i++;}
        			
        	}
        	return res;
        }
        
        
        /*
           Sparse Table implementation
           ProcessingTime=O(NlogN)
		   QueryTime=O(1)
		   Space Complexity=O(N)
		 
		   it won't work large cases because N^2 space complexity
        */
        
        
        
        public void SparseRMQBuild(Integer[][] M,Integer A[],Integer N){
        	
        	  
        	  for(int i=0;i<N;i++)
        		  M[0][i]=i;
        	  for(int i=1;(1<<i)<N;i++){
        		  for(int j=0;(j+(1<<i))<N;j++){
        			  
        			  if(A[M[i-1][j]]<A[M[i-1][j+(1<<(i-1))]])
        			  M[i][j]=M[i-1][j];
        			  else
        				  M[i][j]=M[i-1][j+(1<<(i-1))];
        			 
        		  }
        		  
        	  }
        }
        
        public int SparseRMQQuery(Integer[][]M,Integer A[],Integer l,Integer r)
        {
        	int res=l;
        	int log;
        	for( log=0;(1<<log)<=(r-l+1);log++);
        	  log--;
        	 if(A[M[log][l]]<A[M[log][r-(1<<log)]])
        		 res=M[log][l];
        	 else 
        		 res=M[log][r-(1<<log)];
        	 return res;
        }
        public static void main(String[] args) {
    		InputStream inputstream=System.in;
    		OutputStream outputstraem=System.out;
    		InputReader in = InputReader.getInputReader(inputstream);
    		PrintWriter out= new PrintWriter(outputstraem);
    		int size=in.nextInt();
    		
    		NextInput<Integer> u=new NextInteger();
    		Integer[] A=new Integer[size];
    		
    		
    		ArrayUtility<Integer,NextInput<Integer>> arr= new ArrayUtility<Integer,NextInput<Integer>>(size,A,u);
    		arr.fillByUser();
    		RMQDataStructure rt=new RMQDataStructure();
    		Integer[] B=new Integer[size];
    		int log=0;
    		for(log=0;1<<log<size;log++);
    		
    		Integer [][] M=new Integer[log][size];
    		for(int i=0;i<log;i++)
    			for(int j=0;j<size;j++)
    				M[i][j]=0;
    		long start,end;
    		int result;
    		
    		start=System.currentTimeMillis();
    	    rt.RMQPreProcess(B, A, size);
    	    result=rt.SqrtNQuery(B, A, 2, 7, size);
    	    end=System.currentTimeMillis();
    	    
    	    System.out.println("Sqrtn method return="+result+" Time:"+(end-start)+" Miliseconds");
    	    
    	    start=System.currentTimeMillis();
    	    rt.SparseRMQBuild(M, A, size);
    	    result=rt.SparseRMQQuery(M, A, 2, 7);
    	    end=System.currentTimeMillis();
    	   
    	    System.out.println("Spars Algorithm return="+result+" Time:"+(end-start)+" Miliseconds");
    	    
    	    DebugUtility.print(A);
    	    DebugUtility.print(M);
    	    DebugUtility.print(B);
    	    
    	    
    	    
    		
    		
    		
    		out.close();
    		}
       
        
			public Integer next()
			{
				Integer i=InputReader.getInputReader().nextInt();
				return i;
			}
		
    
			
}
