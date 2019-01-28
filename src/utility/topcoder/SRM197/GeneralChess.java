package utility.topcoder.SRM197;

import java.util.Iterator;
import java.util.TreeSet;

public class GeneralChess {
	class Pair implements Comparable<Pair> {
		public int x;
		public int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int x() {
			return this.x;
		}

		public int y() {
			return this.y;
		}

		//@Override
//		public boolean equals(Object obj) {
//			// TODO Auto-generated method stub
//			Pair p = (Pair) obj;
//			return (p.x() == this.x && p.y() == this.y);
//		}
		
		
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+","+y;
		}

		@Override
		public int compareTo(final Pair o) {
			if(this.x != o.x){
				return this.x - o.x ;
			}
			if(this.y != o.y)
				return this.y - o.y ;
			
			return 0;
		}
	}

	public String[] attackPositions(String[] pieces) {
		int dx[] = {1,1,-1,-1,2,2,-2,-2};
		int dy[] = {2,-2,2,-2,1,-1,1,-1};
       TreeSet<Pair> s = null ;
		
		for (int i = 0; i < pieces.length; ++i) {
			String str[] = pieces[i].split(",");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
            TreeSet<Pair> s1 = new TreeSet<Pair>();
			for (int d = 0; d < dx.length; ++d) {
				int xx = x + dx[d];
				int yy = y + dy[d];
				Pair p = new Pair(xx,yy);
				if(i==0){
					 s1.add(p) ;
				}else {
					if(s != null && s.contains(p)){
						s1.add(p) ;
					}
				}
            }
			s= s1 ;
		}
		
		String str[] = new String[s.size()] ;	
		Iterator<Pair> iter = s.iterator() ;
		int i = 0 ;
		while(iter.hasNext()){
			str[i++] = iter.next().toString() ; 
		}
		return str ;
	}

	public static void main(String[] args) {
		long time;
		String[] answer;
		boolean errors = false;
		String[] desiredAnswer;

		boolean same;

		time = System.currentTimeMillis();
		answer = new GeneralChess().attackPositions(new String[] { "0,0" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new String[] { "-2,-1", "-2,1", "-1,-2", "-1,2",
				"1,-2", "1,2", "2,-1", "2,1" };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i = 1; i < answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GeneralChess().attackPositions(new String[] { "2,1",
				"-1,-2" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new String[] { "0,0", "1,-1" };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i = 1; i < answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GeneralChess()
				.attackPositions(new String[] { "0,0", "2,1" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new String[] {};
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i = 1; i < answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new GeneralChess().attackPositions(new String[] {
				"-1000,1000", "-999,999", "-999,997" });
		System.out.println("Time: " + (System.currentTimeMillis() - time)
				/ 1000.0 + " seconds");
		desiredAnswer = new String[] { "-1001,998" };
		System.out.println("Your answer:");
		if (answer.length > 0) {
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i = 1; i < answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0) {
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i = 1; i < desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		} else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i = 0; i < answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same) {
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		} else
			System.out.println("Match :-)");
		System.out.println();

		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out
					.println("You're a stud (at least on the test data)! :-D ");
	}

}
// Powered by [KawigiEdit] 2.0!
