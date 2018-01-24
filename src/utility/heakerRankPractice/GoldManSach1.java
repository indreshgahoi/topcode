package utility.heakerRankPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GoldManSach1 {

	 static String findQualifiedNumbers(int[] numberArray) {
		 StringBuilder result = new StringBuilder("");
	     List<Integer> eligibleNumbers = new ArrayList<>(numberArray.length); 
		 
	     for(int x : numberArray){
	    	 if(isEligible(x)){
	    		 eligibleNumbers.add(x); 
	    	 }
	     }
	     if(eligibleNumbers.size()> 0){
	    	 int length = eligibleNumbers.size();
	    	 Collections.sort(eligibleNumbers);
	    	for(int i = 0 ; i <length; i++){
	    		if(i == (length-1)){
	    			result.append(eligibleNumbers.get(i).toString());
	    		}else{
	    			result.append(eligibleNumbers.get(i).toString()+",");
	    		}
	    	}
	     }else{
	    	 result.append("-1");
	     }
	     
		 return result.toString() ;
	 }

	 static boolean isEligible(int x){
		int flag = 0 ;
		System.out.println("int: " + x);
		while(x != 0){
			int digit = x % 10 ;
			switch (digit) {
			case 1:
				flag = flag | 1 ;
				break;
			case 2:
				flag = flag | 2 ;
				break;
			case 3:
				flag = flag | 4 ;
				break;
			default:
				;
			}
			System.out.println("flag : " + flag);
			if(flag ==7){
				return true;
			}
			x /=10;
		}
		System.out.println("=======================");
		
		return false ;
	}
	/*
	 *numberArray[0] = ;
	 */
	public static void main(String[] args) {
		int []numberArray = new int[4];
		numberArray[0] = 1456 ;
		numberArray[1] = 345671;
		numberArray[2] = 43218;
		numberArray[3] =123 ;
		System.out.println(findQualifiedNumbers(numberArray));
	}
}
