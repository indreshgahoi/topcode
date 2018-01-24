package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MakePathMST {

	/*
	 * http://www.hackerearth.com/problem/algorithm/make-paths-3/
	 * 
	 * @param args
	 */

	private static class Edge implements Comparable<Edge> {
		public int u, v;
		public int cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		public int compareTo(Edge o) {
		  return this.cost - o.cost ;
		}

	}

	private static class Point {
		public int id;
		public int x, y;

		public Point(int x, int y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;

		}
	}

	private static Comparator<Point> xComp = new Comparator<MakePathMST.Point>() {
		public int compare(Point p1, Point p2) {

			return p1.x - p2.x;
		}
	};
	private static Comparator<Point> yComp = new Comparator<MakePathMST.Point>() {
		public int compare(Point p1, Point p2) {
			return p1.y - p2.y;
		}
	};
	private static int parent[];
	private static int rank[];
	private static  final int findSet(int u) {
	    if(u != parent[u]){
	    	parent[u] = findSet(parent[u]);
	    }
		return parent[u];
	}

	private static final void unionSet(int x, int y) {
		int px = parent[x];
		int py = parent[y];
		if (px != py) {
			if (rank[px] > rank[py]) {
				parent[py] = px;
			} else if (rank[py] > rank[px]) {
				parent[px] = py;
			} else {
				parent[px] = py;
				++rank[py];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Point points[] = new Point[N];
		ArrayList<Edge> edages = new ArrayList<>(N + N);
		parent = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; ++i) {
			parent[i] = i;
		}
		int  e = 0;
		for (int i = 0; i < N; ++i){
			String str[] = br.readLine().split(" ");
			points[i] = new Point(Integer.parseInt(str[0]),
					Integer.parseInt(str[1]), i);
		}

		Arrays.sort(points, 0, N, xComp);
		for (int i = 1; i < N; ++i) {
			edages.add( new Edge(points[i - 1].id, points[i].id, points[i].x
					- points[i - 1].x));
		}
		Arrays.sort(points, 0, N, yComp);
		for (int i = 1; i < N; ++i) {
			edages.add(new Edge(points[i - 1].id, points[i].id, points[i].y
					- points[i - 1].y));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>(edages);
		
		
		long cost = 0;
		int edgCount = 0;
		int treeEdge = N -1 ;
		while(!pq.isEmpty()){
			Edge ed = pq.poll();
            int u = findSet(ed.u);
            int v = findSet(ed.v);
			if ( u != v) {
				cost += ed.cost;
				edgCount++;
				if (edgCount == treeEdge)
					break;
				unionSet(ed.u, ed.v);

			}
		}
		

		System.out.println(cost);

	}

	private static final BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
}
