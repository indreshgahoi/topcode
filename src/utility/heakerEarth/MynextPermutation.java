package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class MynextPermutation {

	
	

	
	
	public static void swap(char [] digits, int x , int y){
		char temp = digits[x] ;
		digits[x] = digits[y] ;
		digits[y] = temp ;
	}
	public static void reverse(char [] digits, int start, int end){
		
		
		while(start < end){
			swap(digits, start, end);
			start++ ;
			end-- ;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {

             int N = nextInt();
             int[] arr = new int[N] ;
             int[] prefixSum = new int[N];
             
             for(int i = 0 ; i < N ; ++i){
            	 arr[i] = nextInt() ;
            	 prefixSum[i] = arr[i] ;
             }
             for(int i = 1 ; i < N ; ++i){
            	
            	 prefixSum[i] = prefixSum[i] + prefixSum[i-1] ;
             }
             int l = 0 , r = arr.length-1;
             
             int maxZero = prefixSum[N-1] ;
             int ans = maxZero;
             for(int i = 0 ; i < N ; ++i)
            	 for(int j = i+1 ; j < N ; ++j){
            		  int tempOne =   prefixSum[j] - prefixSum[i] ;
            		  int tempZero = j -i + 1 - tempOne ;
            		  int resOne  = maxZero - tempOne + tempZero;
            		  ans = Math.max(ans, resOne);
            	 }
             
             
	       System.out.println(ans);
		
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
