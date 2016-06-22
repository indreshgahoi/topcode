package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxNoOfCake {
	
	
	public static void main(String [] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = 0 , maxLen = 0;
		for(int i = 0 ; i < str.length() ;++i){
			if(str.charAt(i)=='a'){
				len++;
			}else {
				len = 0 ;
			}
			maxLen = Math.max(len, maxLen);
		}
		if(maxLen==str.length()){
			maxLen++;
		}
		
		for(int i = 0 ; i < maxLen ; ++i){
			System.out.print('a');
		}
				
	}

}
