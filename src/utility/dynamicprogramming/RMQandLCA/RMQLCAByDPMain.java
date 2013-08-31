package utility.dynamicprogramming.RMQandLCA;

import java.io.InputStream;

import utility.DebugUtility;
import utility.input.InputReader;

public class RMQLCAByDPMain {
	public static void main(String[] args) {
		InputStream inputstream=System.in;
	//	OutputStream outputstraem=System.out;
		InputReader in = InputReader.getInputReader(inputstream);	
		         //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13}
	Integer[]   T= { 0, -1, 1, 1, 1, 3, 3, 3, 6, 6, 7, 7,10,10};
	Integer [][]C={{ 0, 2, 0, 5, 0, 0, 8,10, 0, 0,12, 0, 0, 0},
			       { 0, 3, 0, 6, 0, 0, 9,11, 0, 0,13, 0, 0, 0},
			       { 0, 4, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
			      };
	Integer []L =new Integer[T.length];
	
	Integer H=4;
	Integer log;
	for(log=1;(1<<log)<=T.length;log++);
	//log--;
	Integer [][]P =new Integer[log][T.length];
	
	RMQLCADP solve=new RMQLCADP();
	solve.dfs(1, L, C, 0);
	solve.preprocess(T, P);
	DebugUtility.print(L);
	DebugUtility.print(P);
	Integer x=in.nextInt(),y=in.nextInt();
	
	System.out.println("LCA of node x="+x+" and y="+y+" node="+solve.RMQLCADPQuery(T.length, T, L, P, x, y));
	
	}
}


class RMQLCADP{
	
	void dfs(Integer node,Integer L[],Integer C[][],Integer level){
		L[node]=level;	
		
		
		for(int j=0;j<C.length;j++){
			if(C[j][node]!=0)
			dfs(C[j][node],L, C,level+1);
		}
	}
	void preprocess(Integer T[],Integer P[][])
	{
		Integer N=T.length;
		
		for(int i=0;i<N;i++)
			for(int j=0;(1<<j)<N;j++)
			 P[j][i]=-1;
		for(int i=1;i<N;i++)
			P[0][i]=T[i];
	
		for(int i=1;(1<<i)<N;i++)
			for(int j=1;j<N;j++)
			 if(P[i-1][j]!=-1)//check matrix index should not be negative
				 P[i][j]=P[i-1][P[i-1][j]];
	}
	
	//We have to find the LCA of node x and y
   // with The help of PreProcess Array P
  // P[j][i]=2^j'th ancestor of node i	
	
	Integer RMQLCADPQuery(Integer N,Integer T[],Integer L[],Integer P[][],Integer x,Integer y){
		
		int log;
		
		if(L[x]<L[y])
		{
		 Integer tmp;
		 tmp=x;
		 x=y;
		 y=tmp;
		}
		// Level of x is greater then Level of y
		
		for(log=1;(1<<log)<=L[x];log++);
		 log--;
		// we need to calculate highest value of i
	   // so x ka 2^i'th children ka level is greater then level of y 
		for(int i=log;i>=0;i--){
			System.out.println("x="+x+" L[x]="+L[x]+" i="+i+" 2^i="+(1<<i));
			if((L[x]-(1<<i))>=L[y]){
				x=P[i][x];
				System.out.println("x="+x+" 2<<i="+(1<<i)+" L[x]="+L[x]+" L[y]="+L[y]);
			}
			
			
		}
		if(x==y)
         return x;
		for(int i=0;i<log;i++)
			if(P[i][x]!=-1 && P[i][x]!=P[i][y]){
				x=P[i][x];
			    y=P[i][y];
			}
		// return parent of x because not parent of y because x may be the children of y 
	   // in that case lca of x and y is y means (parent of x =y)
	 return T[x];
	}
	
}
