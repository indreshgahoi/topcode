package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackList {

	

	/**
	 * @param args
	 */

	static int N, K;
	static int cost[][];
	static int dpSum[][];
	static boolean used[];
	static int globalSum = Integer.MAX_VALUE;
	static int globalCount = 0;
	static int currentSum = 0;

	static void solve(int start , int mask) {
		if(start==N){
			
			return ;
		}
		
		if (mask == ((1<<K)-1)) {
			return ;
		}
		if(globalCount==N){
			globalSum = Math.min(globalSum, currentSum);
		}
		int val = dpSum[start][mask];
		if(val!= -1) return  ;
		for (int i = 0; i < K; ++i) {
			
			
			int localSum = 0;
			int count = 0;
			for (int j = start; j < N; ++j) {
				globalCount++;
				count++;
				localSum += cost[i][j];
				currentSum += cost[i][j];
				if (currentSum > globalSum)
					break;
				solve(j + 1,mask | 1<<i);
			}
			globalCount -= count;
			currentSum -= localSum;
			used[i] = false;
		}
	}
	static BufferedReader br;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = nextInt();
		K = nextInt();

		cost = new int[K][N];
		used = new boolean[K];

		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; ++j)
				cost[i][j] = nextInt();
		}

		solve(0,0);

		System.out.println(globalSum);

	}

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
	
	/*
	 * 3 3 1 5 1 2 2 2 9 1 9
	 * 
	 * 5 3 9 4 3 7 6 1 0 7 3 2 1 8 4 1 3
	 */
}
