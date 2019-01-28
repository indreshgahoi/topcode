package utility.topcoder.srm566;

public class PenguinPals {
	String p;
	int[][] ans;

	public int findmax(int i, int j) {
		if (j <= 0 || i >= (p.length() - 1))
			return 0;
		if (i >= j)
			return 0;
		if (ans[i][j] != -1)
			return ans[i][j];
		if((i+1) == j) {
			return ans[i][j] = 0; 
		}

		if (p.charAt(i) == p.charAt(j)) {
			// System.out.println(" i="+i+" j="+j);
			return ans[i][j] = findmax(i + 1, j - 1) + 1;
		} else
			return ans[i][j] = Math.max(findmax(i, j - 1), findmax(i + 1, j));

	}

	public int findMaximumMatching(String colors) {
		int m = 0;
		int len = 2 * colors.length();
		p = colors + colors;
		ans = new int[p.length()][p.length()];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++)
				ans[i][j] = -1;
		}

		m = findmax(0, 2 * colors.length() - 1);

		return m / 2;
	}

	public static void main(String[] args) {
		System.out.println(new PenguinPals().findMaximumMatching(new String("RRRBRBRBRBRB")));
	}
}
