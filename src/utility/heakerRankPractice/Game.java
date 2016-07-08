package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Game {

	public static void main(String[] args) throws IOException {
		int i, q, lastUpper, j, parm, lower, upper;
		final StringBuilder ans = new StringBuilder(100000);
		final int N = Integer.parseInt(next()), M = Integer.parseInt(next()), Q = Integer
				.parseInt(next());
		final int arr[][] = new int[N][M];
		for (i = 0; i < N; ++i) {
			for (j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(next());
			}
		}

		for (q = 0; q < Q; ++q) {
			lastUpper = M;
			for (i = 0; i < N; ++i) {
				parm = Integer.parseInt(next());
				lower = Arrays.binarySearch(arr[i], 0, lastUpper, parm);
				if (lower < 0) {
					lower = -lower;
					lower--;
				}
				upper = lower;
				while (upper < M && arr[i][upper] <= parm)
					upper++;
				upper--;
				lastUpper = Math.min(lastUpper, upper);

			}
			ans.append((lastUpper + 1) + "\n");
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

	private static int nextInt() {
		return Integer.parseInt(next());
	}

}
