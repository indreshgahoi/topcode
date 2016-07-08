package utility.heakerRankPractice;

import java.util.Random;

public class QuickSortPartition {

	private static Random random = new Random() ; 
	
	private static int partition(int arr[],int fromindex , int toindex){
	 
		int pivot = fromindex +   random.nextInt(toindex-fromindex) ;
		int key = arr[pivot] ;
		int i = fromindex , j = toindex;
		while(i < j){
			while(i <= toindex && arr[i] < key) i++ ;
			while(j>=fromindex && arr[j] > key) j--;
		}
		return 0 ;
	
	}
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}
