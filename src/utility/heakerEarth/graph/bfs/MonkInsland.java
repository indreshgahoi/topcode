package utility.heakerEarth.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/
 * 
 * @author indresh
 *
 */

public class MonkInsland {

	enum NodeStatus {
		WHITE, GRAY, BLAK;
	}

	MonkInsland(int count) {
		initGraph(count);
	}

	Map<Integer, List<Integer>> adjList;
	NodeStatus[] status;

	private void initGraph(int count) {
		status = new NodeStatus[count + 1];
		Arrays.fill(status, NodeStatus.WHITE);
		adjList = new HashMap<Integer, List<Integer>>(count);
	}

	public void addEdge(int x, int y) {
		adjList.putIfAbsent(x, new ArrayList<Integer>());
		adjList.putIfAbsent(y, new ArrayList<Integer>());

		adjList.get(x).add(y);
		adjList.get(y).add(x);

	}

	public int bfs(int source, int target) {
		Queue<Integer> queue = new LinkedList<Integer>();

		status[source] = NodeStatus.GRAY;

		queue.add(source);
		queue.add(0);

		while (true) {
			int node = queue.remove();
			int currentLevel = queue.remove();

			if (node == target) {
				return currentLevel;
			}
			adjList.get(node).forEach(child -> {
				if (status[child] == NodeStatus.WHITE) {
					status[child] = NodeStatus.GRAY;
					queue.add(child);
					queue.add(currentLevel + 1);
				}
			});
			status[node] = NodeStatus.BLAK;
		}
	}

	public static void main(String[] args) {
		int T = nextInt();
		while (T-- > 0) {
			int N = nextInt(), M = nextInt();
			MonkInsland solve = new MonkInsland(N);
			while (M-- > 0) {
				int x = nextInt(), y = nextInt();
				solve.addEdge(x, y);
			}
			System.out.println(solve.bfs(1, N));

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
