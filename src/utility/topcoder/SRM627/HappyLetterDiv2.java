package utility.topcoder.SRM627;

import java.util.Arrays;

public class HappyLetterDiv2 {
	
	
	public static  class Pair<F extends Comparable<F>,S extends Comparable<S>> implements Comparable<Pair<F,S>> {
		public F f ;
		public S s ;
		
		public Pair(F first , S second){
			this.f = first ;
			this.s = second ;
		}
		
		@Override
		public int compareTo(Pair<F,S> o) {
			
			return f.compareTo((F)o.f);
		}
		
		
		
		
	}
	
	public char getHappyLetter(String letters) {
		Pair<Integer,Character> buf[]  = new Pair[26] ;
		for(int i = 0 ; i < 26 ; ++i){
			buf[i] = new Pair<Integer,Character>(0,'0');
		}
		for(char ch : letters.toCharArray()){
			buf[ch-'a'].f++;
		}
		for(int i = 0 ; i < 26 ; ++i ){
			Pair<Integer,Character> p = buf[i] ;
			p.s = (char)('a' + i) ;
		}
		Arrays.sort(buf);
		return  (buf[25].f * 2 > letters.length()) ? buf[25].s :'.' ;
	}
	
	
	public static void main(String[] args) {
		HappyLetterDiv2 task = new HappyLetterDiv2();
		System.out.println(task.getHappyLetter("aacaaa"));
	}
}
