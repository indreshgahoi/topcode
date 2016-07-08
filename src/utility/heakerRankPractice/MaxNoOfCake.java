package utility.heakerRankPractice;

<<<<<<< HEAD
import java.util.PriorityQueue;
=======
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
>>>>>>> 8990bb31db1311acf972d2f83d4d23b041b7afab

public class MaxNoOfCake {
	
	PriorityQueue<Integer> pq ;
	
	public static void main(String [] args){
		
	}
	
	
<<<<<<< HEAD
	public void solve(){
=======
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
>>>>>>> 8990bb31db1311acf972d2f83d4d23b041b7afab
		
		for(int i = 0 ; i < maxLen ; ++i){
			System.out.print('a');
		}
				
	}

}
