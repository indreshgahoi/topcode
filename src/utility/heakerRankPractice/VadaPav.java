package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class VadaPav {

	
	
	public static void main(String[] args) throws IOException {
	  br = new BufferedReader(new InputStreamReader(System.in));
	  int N = nextInt() ;
	  ArrayList<String> list= new ArrayList<String>(N);
	  HashMap<String,Integer> tabl = new HashMap<>(N);
	  
	  for(int i = 0 ; i < N ; ++i){
		  String str = next();
		  if(!tabl.containsKey(str)){
			  list.add(str);
			  tabl.put(str, 1);
			}
	  }
	  
	  
	  System.out.println(list.size());
	  
	  Collections.sort(list);
	  
	  for(int i = 0 ; i < list.size() ; ++i){
		  System.out.println(list.get(i));
	  }
	  
	  
		
	}
	
	static BufferedReader br;
	static StringTokenizer st;
	public static String next() {

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

	public static long nextLong() {
		return Long.parseLong(next());
	}
	public static int nextInt() {
		return Integer.parseInt(next());
	}
	

}
