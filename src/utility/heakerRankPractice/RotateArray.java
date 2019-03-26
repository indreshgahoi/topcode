package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RotateArray {

	public static void solve(int[] a, int d) {
		rotate(a, 0, d - 1);
		rotate(a, d, a.length - 1);
		rotate(a, 0, a.length - 1);
	}

	private static void rotate(final int[] a, final int first, final int last) {
		int begin = first, end = last;
		while (begin < end) {
			int tmp = a[end];
			a[end] = a[begin];
			a[begin] = tmp;
			begin++;
			end--;
		}
	}

	public static void main(String[] args) {

		int N = nextInt(), d = nextInt();
		int i = 0;
		int[] a = new int[N];
		while (N-- > 0) {
			a[i++] = nextInt();
		}

		solve(a, d);
		for (int it = 0; it < a.length; ++it) {
			System.out.print(a[it] + " ");
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

	private static final int nextInt() {
		return Integer.parseInt(next());
	}

}
