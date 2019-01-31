package utility.preparation.graph.ShortestPath.FloydWarshall;

public class TeamBuilder {
	boolean[][] adj;
	int x = 0, y = 0;

	void print(boolean[][] adj) {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++)
				System.out.print(" " + adj[i][j]);
			System.out.println();
		}
	}

	public void init(String[] paths) {
		adj = new boolean[paths.length][paths.length];
		for (int i = 0; i < paths.length; i++)
			for (int j = 0; j < paths.length; j++)
				adj[i][j] = (i == j | (paths[i].charAt(j) == '1'));
		// Apply floydWarshall
		//
		// print(adj);
		for (int k = 0; k < paths.length; k++)
			for (int i = 0; i < paths.length; i++)
				if (adj[i][k])
					for (int j = 0; j < paths.length; j++)
						adj[i][j] = adj[i][j] | adj[k][j];
		// print(adj);
		for (int i = 0; i < paths.length; i++) {
			int cnt = 0;
			for (int j = 0; j < paths.length; j++)
				if (adj[i][j])
					cnt++;

			if (cnt == paths.length)
				x++;
		}
		for (int i = 0; i < paths.length; i++) {
			int cnt = 0;
			for (int j = 0; j < paths.length; j++)
				if (adj[j][i])
					cnt++;

			if (cnt == paths.length)
				y++;
		}

	}

	public int[] specialLocations(String[] paths) {
		init(paths);
		return new int[] { x, y };
	}

	public static void main(String[] args) {
		System.out.println("" + new TeamBuilder().specialLocations(new String[] { "0010", "1000", "1100", "1000" })[0]);
	}

}
