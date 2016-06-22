package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Flowers {

	
	public static void solve1(){
		int N = nextInt();
		int K = nextInt();
		int cost[] = new int[N];
		for(int i = 0 ; i < N ; ++i){
			cost[i] = nextInt();
		}
		Arrays.sort(cost);
		long total_cost = 0 ;
		int count = 0 ;
		for(int i = N-1 ; i >=0 ;i-- ){
			total_cost += cost[i] * ((count/K) + 1); 
			++count;
		}
		System.out.println(total_cost);
	}
	
	
	public static void solve(){
		int N = nextInt();
		int K = nextInt();
		int cost[] = new int[N];
		for(int i = 0 ; i < N ; ++i){
			cost[i] = nextInt();
		}
		Arrays.sort(cost);
		long total_cost = 0 ;
		int turn = 1 ;
		for(int i = N-1 ; i >=0 ; ){
			long sum = 0 ;
			for(int j = 0 ; j < K && i >= 0 ;j++,i--){
				sum += cost[i] ;
			}
			total_cost += (sum * turn);
			turn++;
		}
		System.out.println(total_cost);
	}
	
	
	public static void main(String[] args) {
		
		//solve();
		solve1();
	}
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static String next() {

		String line = "";
		while ((st == null || !st.hasMoreElements()) && line != null) {
			try {
				line = br.readLine();
				// System.out.println(line);
				if (line != null)
					st = new StringTokenizer(line);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return st.hasMoreElements() ? st.nextToken() : null;
	}

	public static long nextLong() {
		return Long.parseLong(next());
	}

	public static int nextInt() {
		return Integer.parseInt(next());
	}

}
