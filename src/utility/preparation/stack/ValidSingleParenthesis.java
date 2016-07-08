package utility.preparation.stack;

class ValidSingleParenthesis {

	
	public static int solution(String S) {
       int openCount = 0 ;
       for(int i = 0 ; i < S.length() ; ++i){
    	   if(openCount < 0) return 0 ;
    	   if(S.charAt(i)=='(') openCount++;
    	   else openCount--; 
       }
	   return (openCount==0) ? 1 : 0 ;
    }

	
	
	public static void main(String[] args) {
		
		System.out.println("" + solution("(((()))))()(()()"));
	}

}
