package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoyShopping {

	
	static BufferedReader br;
	static StringTokenizer st;
	static int prime[] , cnt ;
	static boolean p[] ;
	
	public static void  preprocess(){
		prime = new int[1000000];
		cnt = 0 ;
		 p  = new boolean[1000001];
		Arrays.fill(p, true);
		cnt = 0 ;
		for(int i = 2 ; i*i < 1000001 ; ++i){
			if(p[i]==true){
		    	prime[cnt++] = i ;
				for(int j = i+i ; j < p.length ; j+=i){
			       p[j] = false ; 	
			   }
			}
		}
		
		for(int i = 1000 ; i < p.length ; ++i){
			if(p[i]){
				prime[cnt++] = i ;
			}
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		preprocess();
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = nextInt() ;
		for(int i = 0 ; i < N ; ++i){
			int money = nextInt() ;
			if(p[money]){
				System.out.println("0");
				continue ;
			}
			
			for(int k = 0 ; k < cnt ; ++k){
				if((money % prime[k])==0){
					System.out.println(money-prime[k]);
					break ;
				}
			}
		}
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

}
