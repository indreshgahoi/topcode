package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TrieMaxXor {

	public static void main(String[] args) throws IOException {

		int N = nextInt();
		int arr[] = new int[N];
		boolean hasSum[] = new boolean[100001];
		long sumCount[] = new long[100001];
		long MOD = 1000000007;
		hasSum[0] = true;
		sumCount[0] = 1;
		int maxSumTillNow = 0;
		for (int i = 0; i < N; ++i) {
			arr[i] = nextInt();
		}
		for (int i = 0; i < N; ++i) {
			for (int j = maxSumTillNow; j >= 0; j--) {
				if (hasSum[j]) {
					hasSum[j + arr[i]] = true;
					sumCount[j + arr[i]] = (sumCount[j + arr[i]] + sumCount[j])
							% MOD;
					maxSumTillNow = Math.max(maxSumTillNow, j + arr[i]);
				}
			}
		}
		Trie zeroOneTree = new Trie(19);
		for (int i = maxSumTillNow; i > 0; i--) {
			if (hasSum[i]) {
				zeroOneTree.add(i);
			}
		}
		StringBuilder res = new StringBuilder(1000000);
		int Q = nextInt(), val, sum;
		for (int i = 0; i < Q; ++i) {
			val = nextInt();
			sum = zeroOneTree.query(val);
			res.append(sum + " " + sumCount[sum] + "\n");

		}
		System.out.println(res);
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

class Trie {

	private class Node {
		Node child[];

		public Node() {
			child = new Node[2];
		}
	}

	private Node root;
	int height;

	public Trie(int height) {
		this.height = height;
		root = new Node();
	}

	public final boolean add(int num) {
		Node p = root;
		int x;
		for (int i = height; i >= 0; --i) {
			x = 1 & (num >> i);
			if (p.child[x] == null) {
				p.child[x] = new Node();
			}
			p = p.child[x];
		}

		return true;
	}

	public final int query(int val) {
		Node p = root;
		int ans = 0, x;
		for (int i = height; i >= 0; --i) {
			x = 1 & (val >> i);
			if (p.child[x] != null) {
				if (x == 1) {
					ans += (1 << i);
				}
				p = p.child[x];
			} else if (p.child[1 - x] != null) {
				if (x == 0) {
					ans += (1 << i);
				}
				p = p.child[1 - x];
			} else {
				break;
			}
		}
		return ans;
	}

}
