package utility.topcoder.SRM627;

public class ManySquares {
	public int howManySquares(int[] sticks){
		
		int countArray[] = new int[1001];
		
		for(int x : sticks){
			countArray[x]++;
		}
		int res = 0 ;
		for(int x : countArray){
			res += x/4 ;
		}
	
		return res ;
	}
}
