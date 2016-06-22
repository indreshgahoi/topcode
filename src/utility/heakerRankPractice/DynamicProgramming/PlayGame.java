package utility.heakerRankPractice.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGame {

	
	/*
	 *  http://www.hackerearth.com/problem/algorithm/a-game-for-soft-drinks/description/
	 * 
	 * 
	 */
	private static final int MAX_SIZE = 101 ;
	private static final boolean dp[][][] = new boolean [MAX_SIZE][MAX_SIZE][MAX_SIZE];
	
	private static final void solve(){
		for(int i = 0 ; i < MAX_SIZE ; ++i)
			for(int j = 0 ; j < MAX_SIZE ; ++j)
				for(int k = 0 ; k < MAX_SIZE ; ++k){
					if((i > 0 && !dp[i-1][j][k]) || (j > 0 && !dp[i][j-1][k]) || (k > 0 && !dp[i][j][k-1]) ||
						(i > 0 && j > 0 && !dp[i-1][j-1][k]) || (i > 0 && k > 0 && !dp[i-1][j][k-1]) ||(j > 0 && k > 0 && !dp[i][j-1][k-1]) 
						||(i > 0 && j > 0 && k > 0 && !dp[i-1][j-1][k-1])){
						dp[i][j][k] = true;
					}else {
						dp[i][j][k] = false ;
					}
					
				}
	}
	
	public static void main(String[] args) throws IOException {
		solve();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		while(N-->0){
			String str[] = br.readLine().split(" ");
			if(dp[Integer.parseInt(str[0])][Integer.parseInt(str[1])][Integer.parseInt(str[2])]){
				System.out.println("Ashima");
			}else {
				System.out.println("Aishwarya");
			}
		}

	}

}
