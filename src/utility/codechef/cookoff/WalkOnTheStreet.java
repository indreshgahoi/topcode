package utility.codechef.cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class WalkOnTheStreet {

	private static long[] res = new long[100001];

	private static final void preprocess() {

		res[1] = 2;
		res[2] = 5;

		for (int i = 3; i < res.length; ++i) {
			res[i] = ((i << 1) + 1) + res[i - 2];
		}
	}

	public static void main(String[] args) {
		preprocess();
		int T = nextInt();
		final StringBuilder ans = new StringBuilder(2000000);
		while (T-- > 0) {
			ans.append(res[nextInt()] + "\n");
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

	private static final int nextInt() {
		return Integer.parseInt(next());
	}

}
