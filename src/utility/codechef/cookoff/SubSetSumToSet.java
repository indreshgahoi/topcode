package utility.codechef.cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

class SubSetSumToSet {

	public static void main(String[] args) {

		int T = nextInt();
		StringBuilder res = new StringBuilder(1000000);
		 TreeMap<Long, Integer> hMap = new TreeMap<>();
		
		while (T-- > 0) {
			hMap.clear();
			
			int N = nextInt();
			int totalSet = 1 << N ;
			long num;
            boolean fl = true ;  
			for (int i = 0; i < totalSet; ++i) {
				num = nextLong();
				if (num == 0 && fl){
					fl = false ;
					continue;
				}
				if (hMap.containsKey(num)) {
					hMap.put(num, hMap.get(num) + 1);
				} else {
					hMap.put(num, 1);
				}
			}
			ArrayList<Long> possibleSumSet = new ArrayList<>();
			for (int i = 0; i < N; ++i) {
				num = hMap.firstKey();
				int val = hMap.get(num);

				if (val == 1) {
					hMap.remove(num);
				} else {
					hMap.put(num, val - 1);
				}
				int size = possibleSumSet.size();
				for (int j = 0; j < size; ++j) {
					long Nextsum = possibleSumSet.get(j) + num;
					val = hMap.get(Nextsum);
					if (val == 1) {
						hMap.remove(Nextsum);
					} else {
						hMap.put(Nextsum, val - 1);
					}
					possibleSumSet.add(Nextsum);
				}
				possibleSumSet.add(num);
				res.append(num + " ");
			}
			res.append('\n');
		
		}
		System.out.println(res);

	}

	private static final BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
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

	private static final int nextInt() {
		return Integer.parseInt(next());
	}

	private static final long nextLong() {
		return Long.parseLong(next());
	}

}
