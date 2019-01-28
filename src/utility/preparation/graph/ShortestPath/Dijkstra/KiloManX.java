package utility.preparation.graph.ShortestPath.Dijkstra;

/*
 * SRM 181 DIV 1 1000
 */
import java.util.TreeSet;

class State implements Comparable {
	int weapons;
	int shots;

	public State(int weapons, int shots) {
		this.weapons = weapons;
		this.shots = shots;
	}

	@Override
	public int compareTo(Object o) {

		if ((((State) o).shots) < this.shots)
			return 1;
		if ((((State) o).shots) > this.shots)
			return -1;
		if ((((State) o).weapons) < this.weapons)
			return 1;
		if ((((State) o).weapons) > this.weapons)
			return -1;

		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " shots=" + this.shots;
	}
}

public class KiloManX {

	int[] health;
	int[][] shots;
	boolean[] visited;

	void init(String[] damageChart, int[] bossHealth) {
		health = bossHealth;
		visited = new boolean[1 << 15];
		shots = new int[damageChart.length][damageChart.length];
		for (int i = 0; i < damageChart.length; i++)
			for (int j = 0; j < damageChart.length; j++) {
				if (i == j || damageChart[i].charAt(j) == '0')
					shots[i][j] = Integer.MAX_VALUE;
				else
					shots[i][j] = (health[j] + damageChart[i].charAt(j) - '1') / (damageChart[i].charAt(j) - '0');
			}
	}

	int solve() {
		TreeSet<State> pq = new TreeSet<State>();
		pq.add(new State(0, 0));

		while (pq.size() > 0) {
			State current = pq.first();
			// System.out.println(""+pq);
			pq.remove(pq.first());
			// if Already state is Already visited then continue
			if (visited[current.weapons])
				continue;
			visited[current.weapons] = true;
			// check if target is achieve
			// means all bosses are dead means we have all weapons(all bits are set)
			if (current.weapons == ((1 << health.length) - 1))
				return current.shots;
			for (int i = 0; i < health.length; i++) {
				if (((current.weapons >> i) & 1) != 0)
					continue;
				int best = health[i];
				for (int j = 0; j < health.length; j++) {
					if (i == j)
						continue;
					if (((current.weapons >> j) & 1) != 0 && shots[j][i] != Integer.MAX_VALUE)
						best = Math.min(best, shots[j][i]);
				}
				pq.add(new State(current.weapons | 1 << i, current.shots + best));
				// System.out.println("add"+new State(current.weapons|1<<i,current.shots+best));
			}

		}
		return Integer.MAX_VALUE;
	}

	public int leastShots(String[] damageChart, int[] bossHealth) {

		init(damageChart, bossHealth);
		int result = solve();
		return result;
	}

	public static void main(String[] args) {

		System.out.println(
				"" + new KiloManX().leastShots(new String[] { "070", "500", "140" }, new int[] { 150, 150, 150 }));
	}
}
