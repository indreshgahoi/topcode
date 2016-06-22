package utility.heakerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

class QueryArray {

	
	private int arr[] ;
	
	TreeSet<IndexKey> key = new TreeSet<QueryArray.IndexKey>(new Comparator<IndexKey>() {
		public int compare(IndexKey o1, IndexKey o2) {
			
			return o1.getval() - o2.getval();
		};
		
	});
	
	class IndexKey {
		private int keyIndex ;
		private int val ;
		public IndexKey(int i , int val) {
			this.keyIndex = i ;
			this.val = val ;
		}
		public IndexKey(int val){
			this.val = val ;
		}
		int getKey(){
			return keyIndex ;
		}
		int getval(){
			return val ;
		}
		void hit(){
			val-- ;
			arr[keyIndex]--;
		}
		
	}
	
	
	
	public void solve(){
		int N = nextInt();
     	arr = new int[N] ;
     for(int i = 0 ; i < N ; ++i){
    	 arr[i] = nextInt();
    	 key.add(new IndexKey(i,arr[i]));
     }
     int Q = nextInt();
     
     for(int i = 0 ; i < Q ; ++i){
    	 int e = nextInt();
      SortedSet<IndexKey> set 	=  key.tailSet(new IndexKey(e));
      
      for(IndexKey k : set){
    	  key.remove(k);
    	  k.hit();
    	  key.add(k);
      }
     }
     
     for(int i = 0 ; i < N ;++i){
    	 System.out.print(arr[i]+" ");
     }
	
	}
	
	
	public static void main(String[] args) {
     
		QueryArray solve = new QueryArray() ;
		solve.solve();
		
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

	private static long nextLong() {
		return Long.parseLong(next());
	}

	private static int nextInt() {
		return Integer.parseInt(next());
	}
	
}
