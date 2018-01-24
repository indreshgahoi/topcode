package utility.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class BadNeighbour {

	int[][] cache;
	int[] value;
	int len;

	public int solve(int n, boolean bool) {
		if (n < 0) return -2;
		if (bool) {
			if (n < 1) return 0;
			if (n == 1) return cache[bool ? 1 : 0][n] = value[n];
		} else {
			if (n == 0) return cache[bool ? 1 : 0][n] = value[n];
		}

		if (cache[bool ? 1 : 0][n] != -1) {
			return cache[bool ? 1 : 0][n];
		}

		return cache[bool ? 1 : 0][n] = Math.max(solve(n - 2, bool) + value[n], solve(n - 1, bool));

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BadNeighbour q = new BadNeighbour();
		StringTokenizer st = new StringTokenizer(in.readLine(), " \\{\\},");
		q.value = new int[st.countTokens()];
		int i = 0;

		while (st.hasMoreTokens()) {
			q.value[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		q.len = q.value.length;
		q.cache = new int[2][q.value.length];
		Arrays.fill(q.cache[0], -1);
		Arrays.fill(q.cache[1], -1);

		System.out.println("" + Math.max(q.solve(q.len - 3, true) + q.value[q.len - 1], q.solve(q.len - 2, false)));
		for (int j = 0; j < q.len; j++) {
			System.out.println(" " + q.cache[0][j] + " " + q.cache[1][j]);
		}

	}

}
