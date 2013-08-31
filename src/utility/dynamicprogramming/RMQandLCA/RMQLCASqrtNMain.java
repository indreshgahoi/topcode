package utility.dynamicprogramming.RMQandLCA;

import java.io.InputStream;

import utility.DebugUtility;
import utility.input.InputReader;

public class RMQLCASqrtNMain {
	
	public static void main(String[] args) {
		InputStream inputstream=System.in;
	//	OutputStream outputstraem=System.out;
		InputReader in = InputReader.getInputReader(inputstream);	
		         //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13}
	Integer[]   T= { 0, 0, 1, 1, 1, 3, 3, 3, 6, 6, 7, 7,10,10};
	Integer [][]C={{ 0, 2, 0, 5, 0, 0, 8,10, 0, 0,12, 0, 0, 0},
			       { 0, 3, 0, 6, 0, 0, 9,11, 0, 0,13, 0, 0, 0},
			       { 0, 4, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
			      };
	Integer []L =new Integer[T.length];
	Integer []P =new Integer[T.length];
	Integer H=4;
	Integer sq=(int)Math.sqrt(H+.0);
	
	RMQLCASqrtN solve=new RMQLCASqrtN();
	solve.dfs(1, P, T, L, C, sq, 0);
	DebugUtility.print(L);
	DebugUtility.print(P);
	Integer x=in.nextInt(),y=in.nextInt();
	System.out.println("LCA of node x="+x+" and y="+y+" node="+solve.RMQSqrtnQuery(P, T, L, x, y));
	
	}

}
/* O(N) preprocessing Time
 * O(sqrt(N)) Query Time 
 */

class RMQLCASqrtN{
	
	  //Build Array P By decompose the tree into Sqrtn Partition
     //according to the height
    //T[i]=Parent of node i
   //L[i]=Level of node i
  //C[i][j]=pointer to i'th children of node j
 //sq=sqrtn(H) where h equals to the height of the tree
//set the Array P with the pointer to ancestor  that belong to the up level  	
	void dfs(Integer node,Integer P[],Integer T[],Integer L[],Integer C[][],Integer sq,Integer level){
	L[node]=level;	
	if(L[node]<sq)
		P[node]=1;
	
	else if(L[node]%sq==0)
		P[node]=T[node];
	else
		P[node]=P[T[node]];
	
	for(int j=0;j<C.length;j++){
		if(C[j][node]!=0)
		dfs(C[j][node], P, T, L, C, sq,level+1);
	}
		
		
	}
	
	 // we need to find the Lowest Common Ancestor of node x and node y
	//  we first find the ancestor in the same level with the help of preprocessed Array P
   // After the we can find the trival solution
	Integer RMQSqrtnQuery(Integer P[],Integer T[],Integer L[],Integer x,Integer y){
		
		
		while(L[x]!=L[y]){
			if(L[x]>L[y])
				x=P[x];
			else
				y=P[y];
		}
		
		while(x!=y)
		{
			if(L[x]>L[y])
				x=T[x];
			else
				y=T[y];
		}
		
		return x;
	}
}




