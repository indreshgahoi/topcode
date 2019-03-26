package utility.heakerEarth.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/practice-problems/algorithm/min-max-difference/
public class EasyGoing {

	public static void main(String[] args) {
		int T = nextInt();
		while (T-- > 0) {
			final int N = nextInt(), M = nextInt();
			int inputSize = N;
			final int[] a = new int[N];
			int i = 0;
			while (inputSize-- > 0) {
				a[i++] = nextInt();
			}
			Arrays.parallelSort(a);
			int diff = 0;
			for (int ptr = 0; ptr < M; ++ptr) {
				diff += a[N - ptr - 1] - a[ptr];
			}
			System.out.println(diff);
		}

	}

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
