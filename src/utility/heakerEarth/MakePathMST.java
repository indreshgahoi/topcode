package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

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
		while (parent[u] != u){
		 	parent[u] = parent[parent[u]];
		 	u = parent[u] ;
		}
		return u;
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
		Edge edages[] = new Edge[N + N];
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
			edages[e++] = new Edge(points[i - 1].id, points[i].id, points[i].x
					- points[i - 1].x);
		}
		Arrays.sort(points, 0, N, yComp);
		for (int i = 1; i < N; ++i) {
			edages[e++] = new Edge(points[i - 1].id, points[i].id, points[i].y
					- points[i - 1].y);
		}
		Arrays.sort(edages, 0, e);
		
		long cost = 0;
		int edgCount = 0;
		for (int i = 0; i < e; ++i) {
			Edge ed = edages[i];

			if (findSet(ed.u) != findSet(ed.v)) {
				cost += ed.cost;
				edgCount++;
				if (edgCount == (N - 1))
					break;
				unionSet(ed.u, ed.v);

			}
		}

		System.out.println(cost);

	}

	private static final BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
}
