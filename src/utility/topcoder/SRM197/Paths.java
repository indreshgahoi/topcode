package utility.topcoder.SRM197;

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class Paths
{
	class State implements Comparable<State>{
		private int nodeId ;
		private int dist ;
		private int parentId ;
		
		State(int nodeId,int dist){
			this.nodeId = nodeId ;
			this.dist = dist ;
			this.parentId = - 1 ;
		}
		public int getnodeId(){
			return this.nodeId ;
		}
		public int getDist(){
			return this.dist ;
		}
		public void setParent(int id){
			this.parentId = id ;
		}
		@Override
		public int compareTo(State arg0) {
			
			return this.dist - arg0.getDist() ;
		}
		
	}
	
	public int secondBest(String[] graph, int from, int to) {
		
		State best = null ;
		State secondBest = null;
		LinkedList<State> Q = new LinkedList<State>() ;
		Q.add(new State(from, 0)) ;
		
		return 0;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new Paths().secondBest(new String[]{"01111", "10111", "11011", "11101", "11110"}, 0, 0);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Paths().secondBest(new String[]{"1"}, 0, 0);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Paths().secondBest(new String[]{"X1119", "1X119", "11X19", "111X1", "9111X"}, 0, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Paths().secondBest(new String[]{"X1110", "1X111", "11111", "111X1", "0111X"}, 0, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Paths().secondBest(new String[]{"X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XX9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXXX", "X99999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXXX", "X999999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXXX", "X9999999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXXX", "X99999999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXXX", "X999999999999999999999999X9XXXXXXXXXXXXXXXXXXXXXXX", "X9999999999999999999999999X9XXXXXXXXXXXXXXXXXXXXXX", "X99999999999999999999999999X9XXXXXXXXXXXXXXXXXXXXX", "X999999999999999999999999999X9XXXXXXXXXXXXXXXXXXXX", "X9999999999999999999999999999X9XXXXXXXXXXXXXXXXXXX", "X99999999999999999999999999999X9XXXXXXXXXXXXXXXXXX", "X999999999999999999999999999999X9XXXXXXXXXXXXXXXXX", "X9999999999999999999999999999999X9XXXXXXXXXXXXXXXX", "X99999999999999999999999999999999X9XXXXXXXXXXXXXXX", "X999999999999999999999999999999999X9XXXXXXXXXXXXXX", "X9999999999999999999999999999999999X9XXXXXXXXXXXXX", "X99999999999999999999999999999999999X9XXXXXXXXXXXX", "X999999999999999999999999999999999999X9XXXXXXXXXXX", "X9999999999999999999999999999999999999X9XXXXXXXXXX", "X99999999999999999999999999999999999999X9XXXXXXXXX", "X999999999999999999999999999999999999999X9XXXXXXXX", "X9999999999999999999999999999999999999999X9XXXXXXX", "X99999999999999999999999999999999999999999X9XXXXXX", "X999999999999999999999999999999999999999999X9XXXXX", "X9999999999999999999999999999999999999999999X9XXXX", "X99999999999999999999999999999999999999999999X9XXX", "X999999999999999999999999999999999999999999999X9XX", "X9999999999999999999999999999999999999999999999X9X", "X99999999999999999999999999999999999999999999999X9", "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"}, 0, 49);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 459;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new Paths().secondBest(new String[]{"X"}, 0, 0);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
