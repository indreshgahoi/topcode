package utility.preparation.graph.bipartiteGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;


/*  Bipartite Matching
 *   
 * http://www.codechef.com/problems/KMHAMHA/
 * http://discuss.codechef.com/questions/26248/kmhamha-editorial
 * 
 * 
 * Vertex cover,  Hopcroft–Karp algorithm
 * 
 * For Bipartite Graph
 *  König's theorem :
 *  Maximal-Matching = minimal Vertex Cover 
 * 
 * 
 */



 class Kamehameha  {

	
	TreeMap<Integer, Integer> mapX = new TreeMap<>() , mapY = new TreeMap<>();
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int mark[] = new int[1002];
	int match[] = new int[1002];
	int stamp = 0 ;
	
	
	public static void main(String[] args) throws IOException {
		Kamehameha  taskSolver = new Kamehameha ();
		 int T = taskSolver.getInteger();
		 while(T-- > 0){
			 taskSolver.solve();
		 }
	}

	public void solve() throws IOException{
		clear();
		int N = getInteger() ;
		while(N-->0){
			String str[] = br.readLine().split(" ");
			Integer x = Integer.parseInt(str[0]);
			Integer y = Integer.parseInt(str[1]);
			
			if(!mapX.containsKey(x)){
				ArrayList<Integer> newList = new ArrayList<>();
				adjList.add(newList);
				mapX.put(x, adjList.size()-1);
			}
			if(!mapY.containsKey(y)){
				mapY.put(y, mapY.size());
			}
			
			adjList.get(mapX.get(x)).add(mapY.get(y));
		}
		System.out.println(findMaximalMatchIng());
	}
	// Hopcroft–Karp algorithm
	public Integer findMaximalMatchIng(){
		Integer count = 0 ;
		Arrays.fill(match, -1);
		Arrays.fill(mark, -1);
		stamp = 0 ;
		
		for(int i = 0 ; i < mapX.size() ; ++i){
			stamp++;
			if(augmentPath(i)){
				count++;
			}
		}
		
	    return count ;
	}
	
	public boolean augmentPath(int x){
		
		for(Integer y : adjList.get(x)){
			if(mark[y]==stamp) continue ;
			mark[y] = stamp ;
			if(match[y]==-1 || augmentPath(match[y])){
				match[y] = x ;
				return true ;
			}
			
		}
		return false ;
	}
	
	public Integer getInteger(){
		
		try {
		 return	Integer.parseInt(br.readLine());
		} 
		catch (IOException ex){
			
		}
		
		return -1 ; 
	}
	public void clear(){
		mapX.clear();
		mapY.clear();
		adjList.clear();
	}
}
