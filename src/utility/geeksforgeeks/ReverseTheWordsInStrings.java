package utility.geeksforgeeks;

import java.util.Arrays;
import java.util.Scanner;



public class ReverseTheWordsInStrings {
	
	
	
	private void swap(char [] arr , int x , int y){
		char ch = arr[x] ;
		arr[x] = arr[y] ;
		arr[y] = ch;
	}
	
	
	private void reverse(char [] arr , int start , int end){
        
		while(start < end){
			swap(arr, start, end);
			start++ ; end--;
		}
	}
	
	public String reverseTheWords(String str){
		 char[] chars = str.toCharArray();
		 System.out.println(Arrays.toString(chars));
		 int startWord = -1 ;
		 
		 for(int iter = 0 ; iter < chars.length ; ++iter){
			 char currentChar = chars[iter] ; 
			 
			 if(currentChar != ' ' && currentChar != '	'){
				 if(startWord == -1){
					 startWord = iter ;
				 }
			 }else if(startWord != -1){
				 reverse(chars, startWord, iter-1);
				 startWord = -1 ;
			 }
		 }
		 if(startWord != -1){
			 reverse(chars, startWord, chars.length-1);
		 }
		 reverse(chars, 0, chars.length-1);
		 System.out.println(Arrays.toString(chars));
		 return new String(chars);
	}
	
	
	
	public static String getNextInput(){
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.next();
//		scanner.close();
		String str = "I love my india" ;
		return str ;
	}
	
	
	public static void main(String args[]){
		ReverseTheWordsInStrings solver = new ReverseTheWordsInStrings();

		System.out.println(solver.reverseTheWords(getNextInput()));
		
	}

}
