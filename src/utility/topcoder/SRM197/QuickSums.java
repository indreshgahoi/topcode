package utility.topcoder.SRM197;

import java.util.StringTokenizer;


/*Given a string of digits, find the minimum number of additions required for the
 *string to equal some target number. Each addition is the equivalent of inserting a
 * plus sign somewhere into the string of digits. After all plus signs are inserted, 
 * evaluate the sum as usual. For example, consider the string "12" 
 * (quotes for clarity). With zero additions, we can achieve the number 12.
 *  If we insert one plus sign into the string, we get "1+2", which evaluates to 3
 	So, in that case, given "12", a minimum of 1 addition is required to get the number 3.
  	As another example, consider "303" and a target sum of 6. 
  	The best strategy is not "3+0+3", but "3+03". You can do this because leading
   	zeros do not change the result.
 * 
 * 
 * 
 */

public class QuickSums {
	
	int minCost = Integer.MAX_VALUE ;
	
	int minSums(String numbers, int sum){
		minCost = Integer.MAX_VALUE ;
		minSums(numbers, "", 0, sum);
		if(minCost == Integer.MAX_VALUE) return -1 ;
		return minCost-1 ;
	}
	
	
	void minSums(String numbers , String currentString  ,int depth , int targetSum){
		
	    if(depth >= numbers.length()){
	    
	    	StringTokenizer stn = new StringTokenizer(currentString, "+") ;
	    	int res = 0 ;
	    	int x = 0 ;
	    	while(stn.hasMoreTokens()){
	    		res += Long.parseLong(stn.nextToken());
	    		x++ ;
	    	}
	    	
	    	if(res == targetSum){
	    		minCost = Math.min(x, minCost) ;
	    	}
	    	
	    } else {
	    	
	    	minSums(numbers, currentString+""+numbers.charAt(depth), depth+1, targetSum);
	    	minSums(numbers, currentString+numbers.charAt(depth)+"+",depth+1,targetSum) ;
	    	
	    }
	
	}
	
	public static void main(String[] args) {
		QuickSums sol = new QuickSums() ;
		
		System.out.println("Ans = "+ sol.minSums("99999", 45)); //1110
		System.out.println("Ans = "+ sol.minSums("1110", 03)); 
		System.out.println("Ans = "+ sol.minSums("99999", 100));//99999
		System.out.println("Ans = "+ sol.minSums("382834", 100));//382834
		System.out.println("Ans = "+ sol.minSums("9230560001", 71));//9230560001
	}

}
