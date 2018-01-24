package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivisibleBySeven {
	
	
	
	public static void main(String[] args) {
		String str = next();
		char [] didits = str.toCharArray();
		int N = nextInt();
		for(int q = 0 ; q<N ; ++q){
			int l = nextInt();
			int r = nextInt();
			int curr_sum =0, j = r ;
			
			int length = (r-l +1) ;
			int add =  1;
			while((l-2) >= j){
                int n = didits[j-2] * 100 + didits[j-1] * 10 + didits[j] ;
                n = n * add ;
                add = add * -1 ;
			    curr_sum += n ; 
				j = j - 3 ;
			}
			int remain = length % 3, n = 0 ;
			if(remain ==0){
				
			}else if(remain == 1){
				n = didits[l] ;
			}else{
				n = didits[l-1] * 10 + didits[l];
			}
			n = n * add ;
			curr_sum += add ;
			if((curr_sum % 7) == 0){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
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
