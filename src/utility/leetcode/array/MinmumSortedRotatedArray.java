package utility.leetcode.array;

class MinmumSortedRotatedArray {

	
	public int findMin(int[] num) {
       int l = 0 ;
       int r = num.length-1;
       int mid ;
       while(l <= r){
    	   mid = l +(r-l)/2 ;
    	   if(num[l] < num[r]) return num[l] ;
    	   else if(mid>0 && num[mid-1]>num[mid] ) return num[mid] ;
    	   else if(mid < num.length-1 && num[mid+1] < num[mid]) return num[mid+1] ;
    	   if(num[l] < num[mid]){
    		   l = mid+1 ;
    	   }else {
    		   r = mid-1 ;
    	   }
       }
       return num[l] ;
    }
	public static void main(String[] args) {
		System.out.println("MinmumSortedRotatedArray");

	}
}
class MinmumSortedRotatedArrayDuplicate {

	public int findMin(int[] num) {
       int l = 0 ;
       int r = num.length-1;
       int mid ;
       while(l < r){
    	   mid = l +(r-l)/2 ;
    	   if(num[l] < num[r]) return num[l] ;
    	   else if(mid>0 && num[mid-1]>num[mid] ) return num[mid] ;
    	   else if(mid < num.length-1 && num[mid+1] < num[mid]) return num[mid+1] ;
    	   if(num[l] == num[mid]){
    		   l++ ;
    		   
    		   continue ;
    	   }
    	   if(num[l] < num[mid]){
    		   l = mid + 1 ;
    	   }else {
    		   r = mid - 1 ;
    	   }
    	   //System.out.println("l:"+ l + " r:"+r);
       }
       return num[l] ; 
    }
	public static void main(String[] args) {
		int [] nums = new int[]{5,5,7,7} ;
		int minValue = new MinmumSortedRotatedArrayDuplicate().findMin(nums);
		System.out.println(" min value "+ minValue);
	}
}
