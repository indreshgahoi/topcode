package utility.dynamicprogramming.RMQandLCA;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.DebugUtility;
import utility.input.InputReader;

public class ReductionLCAToRMQMain {
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
	
	List<Integer> E=new ArrayList<Integer>();
	List<Integer> L=new ArrayList<Integer>();
	
	List<Integer> H=new ArrayList<Integer>(Arrays.asList(new Integer[T.length]));
	
	ReductionLCAToRMQ solve=new ReductionLCAToRMQ();
	
	solve.dfs(1, T, C, E, L, H, 0);
	Integer P[][]=new Integer[5][E.size()];
    System.out.println(E);
    System.out.println(L);
    System.out.println(H);
    solve.constructRMQ(E, L, P);
    DebugUtility.print(P);
    int x=in.nextInt(),y=in.nextInt();
	System.out.println("LCA of node x="+x+" and y="+y+" node="+solve.LCAQuery(E, L, P, H, x, y));
	
	}

}

class ReductionLCAToRMQ {
	
	void dfs(Integer node,Integer T[],Integer C[][],List<Integer> E,List<Integer> L,List<Integer>H
			 , Integer level){
		E.add(node);
		L.add(level);
		H.set(node,E.size());
		for(int j=0;j<C.length;j++){
			if(C[j][node]!=0){
				   dfs(C[j][node], T, C, E, L, H,level+1);
			       E.add(node);
				   L.add(level);
			 }
		}
	}
	
	void constructRMQ(List<Integer> E,List<Integer> L,Integer P[][]){
	   int N=E.size();
	   for(int i=0;i<N;i++)
		   P[0][i]=i;
	   
	   for(int i=1;(1<<i)<N;i++)
		   for(int j=1;(j+(1<<i))<N;j++)
			   if(L.get(P[i-1][j])<L.get(P[i-1][j+(1<<(i-1))]))
			   {
				   P[i][j]=P[i-1][j];
			   }
			   else
				   P[i][j]=P[i-1][j+(1<<(i-1))];
	  }
	
	Integer LCAQuery(List<Integer> E,List<Integer> L,Integer P[][],List<Integer>H,int x,int y){
		int l=H.get(x),r=H.get(y);
		int res=1;
		int log;
		for(log=1;(1<<log)<=(r-l+1);log++);
		log--;
		if(L.get(P[log][l])<L.get(P[log][r-(1<<log)]))
			res=P[log][l];
		else
			res=P[log][r-(1<<log)];
		System.out.println("res="+res);
		return E.get(res);
	}
	
}