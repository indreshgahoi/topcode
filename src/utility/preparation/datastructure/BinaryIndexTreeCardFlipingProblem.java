package utility.preparation.datastructure;

public class BinaryIndexTreeCardFlipingProblem {

	int[] ftree;
	int maxN = 52;

	int read(int idx) {
		int sum = 0;
		while (idx >= 0) {
			sum += ftree[idx];
			idx = (idx & (idx + 1)) - 1;// it,s easy to handle zero index
		}
		return sum;
	}

	void update(int idx, int newValue) {

		while (idx < maxN) {
			ftree[idx] += newValue;
			idx = (idx | (idx + 1));
			// System.out.println("idx="+idx);
		}

	}

	void init() {
		ftree = new int[maxN];
	}

	public static void main(String[] args) {
		InputReader in = InputReader.getInputReader(System.in);
		BinaryIndexTreeCardFlipingProblem s = new BinaryIndexTreeCardFlipingProblem();
		s.init();
		while (true) {
			int Q = in.nextInt();
			switch (Q) {
			case 1:
				int i = in.nextInt(), j = in.nextInt();
				s.update(i - 1, 1);
				s.update(j, -1);
				break;
			case 0:
				int x = in.nextInt();
				String s1 = (((s.read(x - 1)) % 2) == 0) ? "same" : "flip";
				System.out.println(s1);
				break;
			case -1:
				System.exit(0);
			}
		}

	}

}
