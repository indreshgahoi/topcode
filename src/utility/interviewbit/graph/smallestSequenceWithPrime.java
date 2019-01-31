package utility.interviewbit.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class smallestSequenceWithPrime {

	public ArrayList<Integer> solve(int p1, int p2, int p3, int k) {
		if (k == 0) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> list = new ArrayList<Integer>(k);

		PriorityQueue<Integer> numQueue = new PriorityQueue<Integer>();
		HashSet<Integer> hashSet = new HashSet<Integer>();

		int primes[] = { p1, p2, p3 };

		for (int p : primes) {
			if (!hashSet.contains(p)) {
				numQueue.add(p);
				hashSet.add(p);
			}
		}

		while (true) {
			int currentNumber = numQueue.poll();

			list.add(currentNumber);
			if (list.size() >= k)
				return list;
			for (int p : primes) {
				if (!hashSet.contains(currentNumber * p)) {
					numQueue.add(currentNumber * p);
					hashSet.add(currentNumber * p);
				}
			}
		}

	}

	public static void main(String[] args) {
		System.out.println(new smallestSequenceWithPrime().solve(2, 3, 5, 5));
	}

}
