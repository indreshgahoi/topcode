package utility.heakerEarth.graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class TravelDiaries {

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int[] dx = { 0, 0, -1, 1 };
	int[] dy = { 1, -1, 0, 0 };

	public int solve(int[][] mat) {
		int row = mat.length;
		int col = mat[0].length;
		boolean[][] visited = new boolean[row][col];
		int needToChanged = 0;
		int actuallyChanged = 0;
		List<Point> Q = new ArrayList<>();
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (mat[i][j] == 2) {
					Q.add(new Point(i, j));
					visited[i][j] = true;
				}
				if (mat[i][j] == 1) {
					visited[i][j] = false;
					needToChanged++;
				}
			}
		}
		int level = -1;
		while (!Q.isEmpty()) {
			List<Point> traversed = new ArrayList<Point>();

			Q.forEach(p -> {
				for (int d = 0; d < 4; ++d) {
					int xx = p.x + dx[d];
					int yy = p.y + dy[d];
					if (xx >= 0 && yy >= 0 && xx < row && yy < col && mat[xx][yy] == 1 && !visited[xx][yy]) {
						traversed.add(new Point(xx, yy));
						visited[xx][yy] = true;
					}
				}
			});

			actuallyChanged += traversed.size();
			traversed.forEach(t -> {
				mat[t.x][t.y] = 2;
			});
			level++;
			Q = traversed;
		}
		// System.out.println(actuallyChanged + " : " + needToChanged + "level: " +
		// level);

		// System.out.println(Arrays.deepToString(mat));
		if (needToChanged == actuallyChanged)
			return level;
		return -1;

	}

	public static void main(String[] args) {

		int N = nextInt(), M = nextInt();
		int[][] mat = new int[N][M];

		for (int x = 0; x < N; ++x) {
			for (int y = 0; y < M; ++y) {
				mat[x][y] = nextInt();
			}
		}

		System.out.println(new TravelDiaries().solve(mat));

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
