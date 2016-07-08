package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class MehataSubArray {

	
	public static void main(String[] args) throws IOException {

		int N = nextInt();
		final Integer[] arr = new Integer[N];
		Integer [] indexArray = new Integer[N] ;
		for(int i = 0 ; i < N ;++i){
			if(i>0)
			arr[i] = arr[i-1] + nextInt();
			else arr[i] = nextInt();
			indexArray[i] = i ;
		}
		
		Arrays.sort(indexArray, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				
				return arr[o1]-arr[o2];
			}
		});
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
