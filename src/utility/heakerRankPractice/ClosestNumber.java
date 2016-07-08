package utility.heakerRankPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ClosestNumber {

	private static class Pair<T,U>{
	  T first ;
	  U second ;
	  public Pair(T f , U s){
		  this.first = f ;
		  this.second = s ;
	  }
	  
	}
	
	private static void solve(int arr[]){
	
		Arrays.sort(arr);
		
		int i = 0 ;
		int j = i+1 ;
		int minDiff = Integer.MAX_VALUE ;
		
		while(i < j && j < arr.length){
			int diff = arr[i]-arr[j] ;
			minDiff = Math.min(minDiff,Math.abs(diff));
			
			if(diff==0){
				break ;
			}
			
			if(diff < 0){
				i++;
			}else {
				j++;
			}
			if(i==j) j++;
		}
		
		ArrayList<Pair<Integer, Integer>> list = new ArrayList<>() ;
		i = 0 ;
		j = i+1;
		while(i < j && j < arr.length){
			int diff = arr[i]-arr[j] ;
			
			
			if(Math.abs(diff)==minDiff){
			    list.add(new Pair<Integer, Integer>(arr[i],arr[j]));
				j++;
			}else if(diff < 0){
				i++;
			}else {
				j++;
			}
			if(i==j) j++;
		}
		
		Collections.sort(list, new Comparator<Pair<Integer,Integer>>() {
		  @Override
		public int compare(Pair<Integer, Integer> o1,
				Pair<Integer, Integer> o2) {
			if(o1.first==o2.first) return o1.second.compareTo(o2.second); 
			return o1.first.compareTo(o2.first);
		}
		});
		
		 
		for( i = 0 ; i<list.size();++i){
		    Pair<Integer, Integer> p = list.get(i);
			System.out.print(p.first+" "+p.second+" ");	
		}
	 
	}
	
	
	
	public static void main(String[] args) {
            
		int N = nextInt() ;
		int arr[] = new int[N];
		for(int i = 0 ; i < N ; ++i)
			arr[i] = nextInt() ;
		solve(arr);
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
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
