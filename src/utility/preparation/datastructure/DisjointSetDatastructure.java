package utility.preparation.datastructure;


/*  Disjoint set Data Structure
 *  
 *   Operation:
 *         1. Create-Set
 *         2. Find-Set
 *         3. Union-Set
 * 
 *  Two heuristics
 *  
 *  1. Weight by Union  (worst case implementation complexity in equal to link list implementation )
 *  2. Path Compression
 *  
 *  implementation by rooted tree with both heuristics give liner time and space complexity
 * 
 * 
 */


public class DisjointSetDatastructure {

	int rank[] ; // upper bound on height of the tree
	int parent[] ;
	
    public DisjointSetDatastructure(int numberOfNode) {
    	rank = new int[numberOfNode+1];
    	parent = new int [numberOfNode+1];
    	
    }
	
	public void CreateSet(int x){
		parent[x] = x ;
		rank[x] = 0 ;
	}
	
	/*
	 *  it does not change the root
	 *   it's just an optimization
	 * 
	 */
	public Integer FindSet(int x){
		
		if(parent[x] == x) return x ;
		parent[x] = FindSet(parent[x]); // path compression
	  return parent[x];
	}
	
	/*    we make the root with smaller rank point to the root with larger rank
	 * 
	 * 
	 */
	
	public void UnionSet(int x , int y){
		int px = parent[x] ;
		int py = parent[y] ;
		if(px != py){                   // weight by union
			if(rank[px] > rank[py]){
				parent[py] = px ; 
			}else if(rank[px] < rank[py]){
				parent[px] = py ;
			}
			else  {
				//(rank[px]==rank[py])
				parent[px] = py ;
				rank[py] = rank[py] +1 ;
			}
		}
	}
	
}
