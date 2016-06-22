package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class AnkitAndRaceTeam {

	private static final long MOD = 1000000007;
	private static int fact[] = new int[100001];
	private static int ifact[] = new int[100001];

	private static final void preProcess() {
		int inv[] = new int[100001];
		inv[1] = 1;
		for (int i = 2; i < inv.length; ++i) {
			inv[i] = (int) (MOD - (((MOD / i) * (long) inv[(int) (MOD % i)]) % MOD));
		}
		fact[0] = ifact[0] = 1;

		for (int i = 1; i < fact.length; ++i) {
			fact[i] = (int) ((fact[i - 1] * (long) i) % MOD);
		}
		for (int i = 1; i < ifact.length; ++i) {
			ifact[i] = (int) ((ifact[i - 1] * (long) inv[i]) % MOD);
		}
	}

	public static void main(String[] args) throws IOException {

		preProcess();
		int T = nextInt(), N, K;
		while (T-- > 0) {
			N = nextInt();
			K = nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; ++i) {
				arr[i] = nextInt();
			}
			Arrays.sort(arr);

			long ans = 0;
			int count = (N - K + 1);
			for (int i = 0; i < count; ++i) {
				long mul = (((fact[N - 1 - i] * (long) ifact[K - 1]) % MOD) * ifact[N
						- i - K])
						% MOD;
				ans = (ans + ((mul * arr[i]) % MOD)) % MOD;
			}
			System.out.println(ans);
		}

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
				if (line != null) st = new StringTokenizer(line);
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
