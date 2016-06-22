package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GriDSearch {

	private static String[] grid;
	private static String[] pat;
	private static int r, c, R, C;

	private static final boolean findPattern(int x, int y) {

		for (int i = 0; i < r; ++i)
			for (int j = 0; j < c; ++j) {
				int ii = x + i, jj = j + y;
				if (ii >= R || jj >= C)
					return false;
				if (grid[ii].charAt(jj) != pat[i].charAt(j))
					return false;
			}
		return true;
	}

	private static void solve() {
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j) {
				if (findPattern(i, j)) {
					System.out.println("YES");
					return;
				}
			}
		System.out.println("NO");
	}

	public static void main(String[] args) {
		int T = nextInt();

		while (T-- > 0) {
			R = nextInt();
			C = nextInt();
			grid = new String[R];
			for (int i = 0; i < R; ++i)
				grid[i] = next();
			r = nextInt();
			c = nextInt();
			pat = new String[r];
			for (int i = 0; i < r; ++i)
				pat[i] = next();
			solve();
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));;
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
