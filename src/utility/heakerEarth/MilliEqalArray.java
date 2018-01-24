package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MilliEqalArray {

	
	
	public  static void solve(){
		int N = nextInt(), X = nextInt() , Y = nextInt(), Z = nextInt();
		int[] div = new int[]{X, Y, Z} ;
		int[] arr  = new int[N] ;
		int preFactor = -1 ;
		for( int i = 0 ; i < N ;++i){
			arr[i] = nextInt();
		}
		for(int i = 0 ; i < N ; ++i){
			int num = arr[i] ;
			for(int j = 0 ; num > 1 && j < 3 ; ++j){
				while((num % div[j])==0){
					num = num/div[j] ;
				}
			}
			if(preFactor == -1){
				preFactor = num ;
				continue ;
			}
			if(preFactor != num){
					System.out.println("She can't");
					return ;
			}	
					
			
			
		}
		System.out.println("She can");
		
	}
	
	
	public static void main(String[] args) {
		int T = nextInt();
		while(T-->0){
			solve();
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

	private static final long nextLong() {
		return Long.parseLong(next());
	}

	private static final int nextInt() {
		return Integer.parseInt(next());
	}
}
