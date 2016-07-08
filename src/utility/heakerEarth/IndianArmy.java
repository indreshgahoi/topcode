package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IndianArmy {

	/**
	 * @param args
	 */

	private static final class Interval implements Comparable<Interval> {
		public Long start;
		public Long end;

		public Interval(long strt, long offset) {
			start = strt - offset;
			end = strt + offset;
		}

		public int compareTo(Interval o) {
			if (this.start != o.start)
				return  start.compareTo(o.start);
			return end.compareTo(o.end);
		};

		@Override
		public String toString() {
			return "{"+start+":"+end+"}";
		}
	}

	public static void main(String[] args) throws IOException {

		final int N = nextInt();
		long S = nextLong(), E = nextLong();
		Interval arr[] = new Interval[N];
		for (int i = 0; i < N; ++i) {
			arr[i] = new Interval(nextLong(), nextLong());
		}
		Arrays.sort(arr);
//		for(int i = 0  ; i < arr.length ; ++i){
//			System.out.println(arr[i]);
//		}
	
		int sz = 0 ;
		for(int i = 1 ; i < N ; i++){
			
			if(arr[sz].end > arr[i].start){
				arr[sz].end = Math.max(arr[sz].end, arr[i].end);
			}else {
				sz++;
				arr[sz] = arr[i] ;
			}
		}
		sz++;
//		System.out.println("After Sort");
//		for(int i = 0  ; i < sz ; ++i){
//			System.out.println(arr[i]);
//		}
		long ans = 0;
		
		for (int i = 0; i < sz; ++i) {

			if (S < arr[i].start) {
				ans += (Math.min(arr[i].start,E) - S);
			//	System.out.println((arr[i].start - S));
				S = Math.min(arr[i].start,E);
			}

			if (arr[i].start <= S && arr[i].end > S) {
				S = Math.min(arr[i].end , E);
			}
			if (S == E)
				break;
		}
		
			ans += (E-S);
			//System.out.println( ((E - S) + 1));
		
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

	private static long nextLong() {
		return Long.parseLong(next());
	}

	private static int nextInt() {
		return Integer.parseInt(next());
	}
}
