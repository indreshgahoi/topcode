package utility.preparation.string;

import java.util.ArrayList;

class KMPMatcher {


	/*   Prefix function Algorithm
	 *   Where m is length of pattern
	 *   Pf:{1,2,....m}-> {0,1....m-1}
	      pf(q) = max{k : k< q and Pk suffix of Pq }
     *   pk means P[1.....K]
     *   Pq means [P.....q]
	 * 
	 */
	
	private int[] createPrefixFunction(String p){
		int []prefix_fn = new int[p.length()];
		prefix_fn[0] = 0 ;
		int k = 0 ;
		for(int q = 1 ; q < p.length() ; ++q){
			while(k > 0 && p.charAt(q) != p.charAt(k))
				 k = prefix_fn[k];
			if(p.charAt(k)==p.charAt(q)) k++;
			 prefix_fn[q] = k ; //  Maixmum Length  suffix of pattern p end at q  Which is also a prefix of pattern p  
			
		}
		return prefix_fn ;
	}
	
	/*
	 *  Analysis :
	 *    pre processing time  O(m) Where m is the length of Pattern
	 *    SearchTime O(n)  where n is the length of text
	 *    
	 *    
	 *    Space Complexity o(m)   Where m is the length of Pattern
	 * 
	 */


	public ArrayList<Integer> allOccurrence(String text, String pattern){
		ArrayList<Integer> locations = new ArrayList<Integer>();
		int [] prefix_fn = createPrefixFunction(pattern);
		int q = 0 ;
		for(int i = 0 ; i < text.length() ; ++i){
			while(q>0 && pattern.charAt(q) != text.charAt(i))
				 q = prefix_fn[q] ;
			if(pattern.charAt(q) == text.charAt(i))
				 q = q+1 ;
			if(q==pattern.length()){
				locations.add(i-pattern.length()+1);
				q = prefix_fn[q-1];
			}
		}
		
	 return locations ;	
	}
	
	
	public static void main(String[] args) {
		KMPMatcher matcher = new KMPMatcher() ;
		
		ArrayList<Integer> allOccurrence = matcher.allOccurrence("asnmnshtadfgmnstksjdkjhasdjkaasdsadgadfgmnstsdjadaklsjdlka", "adfgmnst");
		for(int i = 0 ; i < allOccurrence.size() ; ++i){
			System.out.println("loc : "+allOccurrence.get(i));
		}
		
	}

}
