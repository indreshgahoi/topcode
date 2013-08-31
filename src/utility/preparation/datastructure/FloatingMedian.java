package utility.preparation.datastructure;

/*
 * SRM 310 Floating Median
 */

public class FloatingMedian
{
 int[] ftree;
 int maxN=1<<16;
   void update(int idx , int newValue){
	      
	      while(idx<=maxN){
	        ftree[idx]+=newValue;
	        if(idx==0)
	        	break;
	        idx+= (idx & -idx);
	        if(idx<0)
	         break;
	       // idx=idx |(idx+1);
	        
	       // System.out.println("update idx="+idx);
	      }
	    }
	    int sum(int idx ){
		      int sum=0;
		      while(idx>=0){
		        sum+=ftree[idx];
		        if(idx==0 )
		        	break;
		        idx-= (idx & -idx);
		       // System.out.println("sum");
		      }
		      return sum;
		    }
	   
	   int find(int target){
	    int hi=maxN,lo=1;
	   
	   int mid=0;
	   while(lo<hi){
		    mid=(lo+hi)>>1;
	   if((lo+1)==hi)
		   break;
	    int t=sum(mid);
	   // if(t==target)
	   // 	return mid;
	  //  System.out.println("hello");
	    if(target>t)
	    	lo=mid;
	    else
	    	hi=mid;
	   // System.out.println("lo="+lo+" hi="+hi);
	   }
	   return hi;     
	  }
	   
		public long sumOfMedians(int seed, int mul, int add, int N, int K)
		{
			int[] temp=new int[N+1];
			ftree=new int[maxN+1];
			temp[1]=seed;
			for(int i=2;i<N+1;i++){
			 temp[i]=(int)((((long)temp[i-1])*mul+add)%65536);
			   
			}
			//for(int k=1;k<=N;k++){
				//System.out.println(" "+temp[k]);
			//}
			long sum=0;
			for(int i=1;i<=N;i++){
			   if(i<K){
			    update(temp[i],1);
			   }
			  
			   else{
				  update(temp[i],1);
			      sum+=find((K+1)/2);
			      
			      update(temp[i-K+1],-1);
			     // System.out.println("sum="+sum);
			      
			   }
			   
			}
			return sum;
		}
	
	
}
//Powered by [KawigiEdit] 2.0!