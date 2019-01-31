package utility.interviewbit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LongestPath {

	private Map<Integer, List<Integer>> adjList;
	private int height[];
	private boolean visited[];

	public void initGraph(List<Integer> edges) {
		adjList = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < edges.size(); ++i) {
			if (edges.get(i) >= 0) {
				addEdge(i, edges.get(i));
			} else {
				adjList.put(i, new ArrayList<Integer>());
			}
		}
	}

	public void initDfs(int size) {
		height = new int[size];
		visited = new boolean[size];
		Arrays.fill(height, 0);
		Arrays.fill(visited, false);
	}

	public void dfs(int root, int size) {
		initDfs(size);
		dfsRecur(root, 0);
	}

	private void dfsRecur(int u, int distance) {
		height[u] = distance;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(u);
		while (!stack.isEmpty()) {
			int c = stack.pop();
			visited[c] = true;
			adjList.get(c).forEach(v -> {
				if (!visited[v]) {
					stack.push(v);
					height[v] = height[c] + 1;
				}
			});
		}
	}

	public void addEdge(int i, int j) {
		adjList.putIfAbsent(i, new ArrayList<Integer>());
		adjList.putIfAbsent(j, new ArrayList<Integer>());
		adjList.get(i).add(j);
		adjList.get(j).add(i);
	}

	public int findMaxIndex(int[] height) {
		int maxIndex = 0;
		for (int i = 0; i < height.length; ++i) {
			if (height[i] > height[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public int solve(ArrayList<Integer> edges) {
		initGraph(edges);
		dfs(0, edges.size());
		dfs(findMaxIndex(height), edges.size());
		int result = findMaxIndex(height);
		return height[result];
	}

	public static void main(String[] args) {
		LongestPath solve = new LongestPath();
		List<Integer> input = Arrays.asList(-1);
		System.out.println(solve.solve(new ArrayList(input)));
	}

}
