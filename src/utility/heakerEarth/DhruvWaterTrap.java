package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.java2d.jules.TrapezoidList;



public class DhruvWaterTrap {

	public final static long MOD = 1000000007 ;
	
	public static void main(String[] args) {
		int T = nextInt() ;
		
		while(T-->0){
		 int N = nextInt();
		 int height[] = new int[N] ;
		 int maxInd = 0 ;
		 for(int i = 0 ; i < N ; i++){
			 height[i] = nextInt();
			 if(height[i] >height[maxInd]){
				 maxInd = i ;
			 }
		 }
		 long tapWater = 0 ;
		 int previousBuildHeight = 0 ;
		 
		 for(int i = 0 ; i < maxInd ; ++i){
			 if(previousBuildHeight > height[i]){
				 tapWater = (tapWater + (previousBuildHeight-height[i])) % MOD ;  
			 }
			 else 
				 previousBuildHeight = height[i] ;
		 }
		 previousBuildHeight = 0 ;
		 for(int i = N-1 ; i > maxInd ; i--){
			 if(previousBuildHeight > height[i]){
				 tapWater = (tapWater + (previousBuildHeight-height[i])) % MOD ;  
			 }
			 else 
				 previousBuildHeight = height[i] ;
		 }
		 System.out.println(tapWater);
		 
		}
	}
	
	
	private static final BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static final String next() {

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

	private static long nextLong() {
		return Long.parseLong(next());
	}

	private static int nextInt() {
		return Integer.parseInt(next());
	}
	
}
