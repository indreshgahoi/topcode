package utility.preparation.graph.dfs;

import java.util.ArrayList;
import java.util.Collections;

class Graph {
	int V; // nubber Of Vertex
	ArrayList<ArrayList<Integer>> adjList;
}

class CycleDetectionUndirectGraph {

	private boolean visited[];
	private int parent[];
	private Graph g;
	private int cycle_strt;
	private int cycle_end;

	CycleDetectionUndirectGraph(Graph g) {

	}

	private void clear() {
		visited = new boolean[g.V];
		parent = new int[g.V];
		cycle_strt = -1;
		cycle_end = -1;
	}

	void detectCycle() {
		clear();
		for (int i = 0; i < g.V; ++i) {
			if (!visited[i])
				if (dfs(i, -1))
					break;
		}
		if (cycle_strt != -1) {
			ArrayList<Integer> cycle = new ArrayList<Integer>();
			cycle.add(cycle_strt);
			while (cycle_end != cycle_strt) {
				cycle.add(cycle_end);
				cycle_end = this.parent[cycle_end];
			}
			cycle.add(cycle_strt);
			Collections.reverse(cycle);
		}
	}

	boolean dfs(int u, int parent) {
		visited[u] = true;
		for (Integer v : g.adjList.get(u)) {
			if (!visited[v]) {
				this.parent[v] = u;
				return dfs(v, u);
			} else if (v != parent) {
				cycle_strt = v;
				cycle_end = u;
				return true;
			}
		}
		return false;
	}

}
