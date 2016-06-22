package utility.preparation.string;

/*
 *  Question 1 :
 *     Find the first non-repeated (unique) character in a given string.
 *     
 *     
 *     Algorithm :
 *         Step : 1
 *         first iterate through the string and maintain 
 *         the number of occurrence and first occurrence position of char
 *            
 *        Step : 2   
 *         iterate through all alphabet set and find the minimum index of char whose
 *         number of occurrence is one ;  
 *         
 *         
 *         Analysis :
 *            Step 1 :
 *              O(n) Where n is string length
 *            Step 2  :
 *              O(w) Where w is  size of alphabet set          
 *           O(n) + O(w)   
 *            w is constant So total time Complexity
 *            is O(n)
 *            
 *            
 *        Space Complexity :
 *            O(w)    
 
 */



class FirstNonRepeatedCharInString {

	private static final int NO_OF_CHAR = 256 ;
	char firstNonRepeatedChain(String str){
		if(str==null || str.length()==0) return '\0' ;
		int count[] = new int[NO_OF_CHAR]  ;
		int firstPosition[] = new int[NO_OF_CHAR];
		for(int i = 0 ; i < str.length() ; ++i){
			char ch = str.charAt(i);
              if(count[ch]==0){
            	  firstPosition[ch] = i;
              }
              count[ch]++;
        }
		int minIndex = str.length();
		for(int i = 0 ; i < NO_OF_CHAR ; ++i){
			if(count[i]==1){
				minIndex = Math.min(minIndex,firstPosition[i]);
			}
		}
		return str.charAt(minIndex) ;
	}
	
	
	
	/* Uint Test Case
	 */
	
	
	public static void main(String[] args) {
		FirstNonRepeatedCharInString solver = new FirstNonRepeatedCharInString();
		
		System.out.println("Test 1 : "+solver.firstNonRepeatedChain("indresh"));
		System.out.println("Test 2 : "+solver.firstNonRepeatedChain("PubMatic"));
        System.out.println("Test 3 : "+"");
        System.out.println("Test 4 : "+solver.firstNonRepeatedChain(null));
        System.out.println("Test 5 : "+solver.firstNonRepeatedChain("abcabcbgldefyiefld/jsfgefj"));
		
		
                    
	}

}
