package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class IceCreamPoluar {
   
	private static void solve(final int arr[] , int M){
	 Integer idxArray[] =  new Integer[arr.length] ;
	 for(int i = 0 ; i < arr.length ; ++i)
		 idxArray[i] = i ;
	 Arrays.sort(idxArray,new Comparator<Integer>() {
	 
		 public int compare(Integer o1, Integer o2) {
			 return arr[o1] -arr[o2] ;
		 }
	 }) ;
	 int i = 0 , j = arr.length-1; 
	 while(i < j){
		 int sum = arr[idxArray[i]] + arr[idxArray[j]] ;
		 if(sum==M){
			 System.out.println((Math.min(idxArray[i], idxArray[j])+1)+" "+(Math.max(idxArray[i],idxArray[j])+1));
		  break ;
		 }else if(sum < M){
			 i++ ;
		 }else  j--;
	 }
	
	}
	
	
	public static void main(String[] args) {
        int T = nextInt() ;
        int M,N ;
        while(T-->0){
        	M = nextInt() ;
        	N = nextInt() ;
        	int arr[] = new int[N] ;
        	for(int i = 0 ; i < N ; ++i){
        		arr[i] = nextInt() ;
        	}
        	solve(arr, M);
        }
		
		
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
