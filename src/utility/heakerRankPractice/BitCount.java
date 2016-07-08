package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitCount {

	
	
	public static void main(String[] args) throws IOException {
   
		
		//BufferedReader br = new BufferedReader(new InputStreamReader(BitCount.class.getResourceAsStream("input.txt")));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a [] = new int[N];
		for(int i = 0 ; i<a.length ; ++i){
				a[i] = Integer.parseInt(br.readLine());
			} 
			for(int i = 0 ; i < a.length ; ++i){
				a[i] = Integer.bitCount(a[i]);
			}
			int x  = 0 ; 
			for(int i = 0 ; i < a.length ; ++i){
				x ^= a[i] ; 
			}
			
			if(x!=0){
				System.out.println("Ashima");
			}else {
				System.out.println("Shaka :)");
			}
		
		
		
	}
	
	static String reverseWords(String a) {

	    String str[] = a.split(" ");
	    
	    String result = "";
	    
	    for(int i = str.length-1 ; i>=0 ; i--){
	    	if(i==0){
	    		result+=str[i] ; 
	    	}else {
	    		result+=str[i]+" ";
	    	}
	    }
	    return result ;

	}

}
