package utility.dynamicprogramming;

import java.io.*;

 /*
  * This Question is basically defined 
  *  How to define the state of Dynamic Programming ?
  *  How to pass a way from one state to another state ?
  *  How to define recuurent relation b/w in lower and greater state ? 
  * 
  * 
  */

public class LongestIncSequence {
	
	//longest non-decreasing sequence
    // We have a sequence A1 A2 A3 ..
	// solve by dp
	// Let's define the DP state
	// S[i] is the state which represent the  max length seq which end with A[i]
	// Lets's define the recurrent relation
	// how we find S[i + 1] with the help of lower state i+ i
	// initially S[i+1] would be the 1
	// S[i + 1] = Max(S[j]) all j for which  A[i + 1] >= A[j] + 1
	
	
	

}


