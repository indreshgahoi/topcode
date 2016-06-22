package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ChanduAndDesPal {

	private static final long  MOD= 1000000007 ;
	private static final long pow(final int x , final int n){
		if(n==0) return 1 ;
		long t = pow(x,n/2);
		t = (t * t) % MOD ;
		if((n & 1)==1){
			t = (t * x) % MOD ;
		}
		return t ;
	}

	public static void main(String[] args) throws IOException {

		 int N = nextInt() ;
		 final int hash [] = new int[26];
		 final HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(10000);
		 String str ;
		
		while(N-->0){
		  str = next();
		  for(int i = 0 ; i < 26 ; ++i){
			  hash[i] = -1 ;
		  }
		  map.clear();
		  for(int i = 0 ; i < str.length(); ++i){
			  final int idx = str.charAt(i)-'a';
			  if(hash[idx] >= 0){
				  final int diff = i - hash[idx] ;
				  if(map.containsKey(diff)){
					  map.put(diff,map.get(diff)+1);
				  }else {
					  map.put(diff,1);
				  }
				 
			  }
			  hash[idx] = i ;
		  }
		  
		  long ans = 0 ;
		  for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			  ans = (ans + ((pow(2,entry.getKey()) * entry.getValue()) % MOD)) % MOD ;
		  }
		  
		  System.out.println(ans);
		  
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
