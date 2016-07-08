package utility.leetcode.array;

class EquilibriumSum {
	
	
	
	public static  int solution(int[] A) {
	   long sum = 0 ;
	   for(int i = 0 ; i < A.length ; ++i){
		   sum+=A[i] ;
	   }
	   
	   long lSum = 0 ;
	   for(int i = 0 ; i < A.length ; ++i){
		   
		   sum -=A[i] ;
		   
		   if(lSum==sum) return i ;
		   lSum += A[i] ;
	   }
	   return -1;
	}
	
	public static void main(String[] args) {
		
		System.out.println( solution(new int []  {-1, 3, -4, 5, 1, -6, 2, 1} ));

	}

}
