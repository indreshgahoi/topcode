package utility.dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 
 * https://leetcode.com/problems/longest-increasing-subsequence/solution/
 * 
 * https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
 * 
 * @author indresh
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * brute force 1. generate all the sub sequences 
	 * 2. check for the maximum
	 *  Cost is N!
	 *  WHat is overlapping sub problem
	 *  T(n) = (2^n)
	 *  
	 *  
	 *   a b a  c b a d a e 
	 *   
	 *   a->b
	 *       ->c
	 *          ->d
	 *   a->c
	 *       ->d
	 *          ->e 
	 *   a->b
	 *       ->d
	 *          ->e 
	 *   a->d
	 *       ->e
	 *   a->e
	 *       
	 */

	private int lengthOfLIS(Integer sequence[], int currentPos, int lastValue) {
		if (currentPos >= sequence.length) {
			return 0;
		}
		int localMax = 0;
		if (lastValue < sequence[currentPos]) {
			localMax = 1 + lengthOfLIS(sequence, currentPos + 1, sequence[currentPos]);
		}
		localMax = Math.max(localMax, lengthOfLIS(sequence, currentPos + 1, lastValue));
		return localMax;

	}

	public int generateAllSubsequence(List<Integer> sequence) {
		return lengthOfLIS(sequence.toArray(new Integer[sequence.size()]), 0, Integer.MIN_VALUE);
	}

	public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence()
				.generateAllSubsequence(Arrays.asList(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)));

	}

}
