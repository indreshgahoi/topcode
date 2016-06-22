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
    	   if(num[l] <= num[mid]){
    		   l = mid ;
    	   }else if(num[mid] <= num[r] ){
    		   r = mid ;
    	   }
       }
       if(l==r) return num[l] ;
       else return Math.min(num[l], num[r]);
    }
}
