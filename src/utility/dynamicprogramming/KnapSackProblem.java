package utility.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

/* Top Coder Recipe 
 * http://apps.topcoder.com/forums/?module=Thread&threadID=697369&start=0
 * 
 *  DP Solution :- Finding Recurrent Relation
 *  
 *    Basically Recurrent relation has two parts
 *    1 => State Domain (set of states (subproblems))
 *    2 => Transition (relation between different state)
 *    
 * 
 */

/* (i,j) is state and maxCost[i][j] is result of state (i,j)
 * 
 * here state(i,j) means maximum cost of items considering first i items over 
 * the size of j . 
 * 
 * 
 */


public class KnapSackProblem {

	int maxCost[][];
	int items[], bagSpace;
	int size[] ;
	// items[i] cost of ith item
	// size[i] space obtain by th ith item
	

	public KnapSackProblem(int itemsList[],int size[], int bagCapacity) {
		this.bagSpace = bagCapacity ;
		items = itemsList ;
		this.size = size ;
		maxCost = new int[items.length+1][bagCapacity+1];
		for(int i = 0 ; i < maxCost.length ;++i){
			Arrays.fill(maxCost[i],Integer.MIN_VALUE);
		}
	}

	public void solve() {
         maxCost[0][0] = 0 ; 
		for(int i = 0 ; i < items.length ; ++i ){
			for(int j = 0 ; j <= bagSpace ;++j){
				 int ni = i+1 ;                               // forward transition when we do not include ith item
				 int nj = j ;
				 int nmaxCost = maxCost[i][j] ;
				 
				 if(maxCost[ni][nj] < nmaxCost){
					 maxCost[ni][nj] = nmaxCost ;
				 }
				 nj = j + size[i] ;                                         // forward transition when we include ith item
			     if(nj <= bagSpace && maxCost[ni][nj] <(items[i] + nmaxCost)){
			    	 maxCost[ni][nj] = items[i]+ nmaxCost ;
			     }
			}
		}
		int maxCost = Integer.MIN_VALUE ;
		for(int i = 0 ; i <= bagSpace;++i){
			if(this.maxCost[items.length][i] > maxCost){
				maxCost = this.maxCost[items.length][i];
			}
		}
	}
}
