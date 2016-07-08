package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Encryption {

	
	public static void main(String[] args) {

		String str = next();
		int len = str.length() ;
		double sqrt = Math.sqrt(len+.0); 
		int lb = (int) sqrt ;
		int up = (int)Math.ceil(sqrt);
		int r = 0,c = 0,area=Integer.MAX_VALUE ;
		for(int i = lb ; i <= up ; ++i)
			for(int j = i ; j <= up ; ++j){
				if(i*j >= len && i*j < area){
					area = i * j ;
					r = i ;
					c = j ;
				}
			}
		for(int i = 0 ;i < c ; ++i){
			for(int j = 0 ; j < r ; ++j){
				if((j * c + i) <len){
					System.out.print(str.charAt(j*c+i));
				}
			}
			System.out.print(" ");
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
