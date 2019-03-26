package utility.heakerEarth.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {

	public int swapCount(int a[]) {
		assert (a != null);
		int count = 0;
		final int len = a.length;
		for (int size = 0; size < len - 1; size++) {
			for (int ptr = 0; ptr < len - size - 1; ++ptr) {
				if (a[ptr] > a[ptr + 1]) {
					int tmp = a[ptr];
					a[ptr] = a[ptr + 1];
					a[ptr + 1] = tmp;
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		int N = nextInt();
		int[] a = new int[N];
		int i = 0;
		while (N-- > 0) {
			a[i++] = nextInt();
		}
		System.out.println(new BubbleSort().swapCount(a));
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
