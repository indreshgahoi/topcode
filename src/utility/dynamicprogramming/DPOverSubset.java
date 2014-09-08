package utility.dynamicprogramming;

import java.util.ArrayList;

/*  
 * http://apps.topcoder.com/forums/?module=Thread&threadID=697369&start=0
 * 
 * TSP problem (Traveling sales men problem)
 * 
 * The set of cities X = [0,1,2,....n-1] n cities ,
 * state (s,a) = R
 *  Where R is shortest Path start from 0 and end with a, through subset s 
 *  
 *  iterate through all state in lexicographical order
 *  
 * 
 * 
 */

interface Graph {
	public void addEdge(int u, int v, int cost);

	public int getNumberOfNode();

	public class Edge implements Comparable<Edge> {
		private int u;
		private int v;
		private int cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;

		}

		public int getNext() {
			return this.v;
		}

		public int getCost() {
			return this.cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public int compareTo(Edge edge) {
			return this.cost - edge.getCost();
		}
	}

}

class AdjancyListGraph implements Graph {

	public ArrayList<ArrayList<Edge>> adjList;
	private int numberOfNodes;
	private int numberOfEdgae;

	AdjancyListGraph(int numberOfNode) {
		this.numberOfNodes = numberOfNode;
		this.numberOfEdgae = 0;
		adjList = new ArrayList<ArrayList<Edge>>(numberOfNode);
	}

	public void addEdge(int u, int v, int cost) {
		Edge edge = new Edge(u, v, cost);
		this.numberOfEdgae++;
		if (adjList.get(u) == null) {
			adjList.set(u, new ArrayList<Edge>());
		}
		adjList.get(u).add(edge);
	}

	public int getNumberOfNode() {
		return this.numberOfNodes;
	}
}

// public class AdjancyMatrixGraph implements Graph {
// public ArrayList<> adjList ;
// }

public class DPOverSubset {
	int numberOfNode;
	int cost[][];

	public DPOverSubset(int numberOfNode, int costMatrix[][]) {
		this.numberOfNode = numberOfNode;
		this.cost = costMatrix;
	}
	
	

	public int solve() {
		int minCost[][] = new int[1 << numberOfNode][numberOfNode];
		minCost[0][0] = 0;
		for (int s = 0; s < 1 << numberOfNode; ++s) {
			for (int d = 0; d < numberOfNode; ++d) {
				for (int v = 0; v < numberOfNode; ++v) {
					if ((s & (1 << v)) != 0) {
						int nextS = s | (1 << v);
						int cost = minCost[s][d] + this.cost[d][v];
						if (this.cost[nextS][d] > cost) {
							this.cost[nextS][d] = cost;
						}
					}
				}
			}
		}
		
		int cost = Integer.MAX_VALUE ;
		
		for(int i = 0 ; i < this.numberOfNode ; ++i){
			
		          cost = Math.min(cost,minCost[(1 << this.numberOfNode) -1][i] + this.cost[0][i]);		
			
		}
		return cost ;
	}

}
