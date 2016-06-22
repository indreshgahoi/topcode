package utility.codechef.SEPT2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

interface Solution {
	public void solve(InputReader in, PrintWriter out);
}

class FunWithRoration implements Solution {

	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputstream = null;
		Solution task = new FunWithRoration();
		//inputstream = System.in;
		inputstream = Solution.class.getResourceAsStream("input.txt");
		OutputStream outputstraem = System.out;
		InputReader in = InputReader.getInputReader(inputstream);
		PrintWriter out = new PrintWriter(outputstraem);
		task.solve(in, out);
		out.close();

	}

	public void solve(InputReader in, PrintWriter out) {

		int N = in.nextInt() , M= in.nextInt() ;
		int a[] = new int[N];
		for(int i = 0 ; i < N ; ++i){
			a[i] = in.nextInt();
		}
		
		
	}

}

class InputReader {

	BufferedReader br;
	StringTokenizer st;
	static InputReader input;

	private InputReader(InputStream stream) {
		br = new BufferedReader(new InputStreamReader(stream));
		input = this;
		st = null;
	}

	public static InputReader getInputReader(InputStream stream) {
		if (input == null)
			input = new InputReader(stream);
		return input;
	}

	public static InputReader getInputReader() {
		return input;
	}

	public String next() {

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

	public long nextLong() {
		return Long.parseLong(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

}
