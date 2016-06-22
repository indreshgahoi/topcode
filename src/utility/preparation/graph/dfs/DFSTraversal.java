package utility.preparation.graph.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


class AdjGraph{
	private int num_nodes ;
	private List<List<Integer>> adjList ; 
	
	public AdjGraph(int num_nodes) {
		this.num_nodes = num_nodes ;
		adjList = new ArrayList<>(this.num_nodes);
		for(int i = 0 ; i < this.num_nodes; ++i){
			ArrayList<Integer> nList = new ArrayList<>();
			adjList.add(nList);
		}
		
	}
	
	public void addEdge(int u, int v){
		adjList.get(u-1).add(v);
		adjList.get(v-1).add(u);
	}
	
	public List<Integer> getNeighbours(int u){
		return adjList.get(u - 1);
	}
	
	public int getNumofVertex(){
		return this.num_nodes ;
	}
	
}

class UndirectedGRaphTraversal {
	private AdjGraph graph;
	public UndirectedGRaphTraversal(AdjGraph g) {
		this.graph = g;
	}
	
	
	
	public void iterativeTraversal(int rootNode){
		Stack<Integer> stack = new Stack<>() ;
		boolean [] visited_nodes = new boolean[this.graph.getNumofVertex() + 1] ;
		int current_time = 1 ;
		stack.push(rootNode);
		while(!stack.empty()){
			int current_node = stack.peek();
		    stack.pop(); 			
		    if(visited_nodes[current_node]) continue ;
		    
		    visited_nodes[current_node] = true ;
		    System.out.println("Node"+ current_node+": has tag "+ current_time);
		    current_time++;
		    for(int child : this.graph.getNeighbours(current_node)){
		    	stack.push(child);
		    }
		}
	}
	
	

}



public class DFSTraversal {
   
	public DFSTraversal() {
       
	}
	
	private AdjGraph createGrapg(){
		int node_count = 7 ;
		AdjGraph graph = new AdjGraph(node_count);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(3, 6);
		graph.addEdge(3, 7);
		return graph ;
	}
	
	private void traversal(){
		AdjGraph graph = createGrapg();
		
		new UndirectedGRaphTraversal(graph).iterativeTraversal(1);
	}
	
	public static void main(String[] args) {
		new DFSTraversal().traversal();
	}
	
	
}
