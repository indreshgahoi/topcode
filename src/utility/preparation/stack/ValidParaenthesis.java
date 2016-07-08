package utility.preparation.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class ValidParaenthesis {

	
	
	
	public boolean isValid(String expression){
	  Stack<Character> st = new Stack<>() ;
	  Map<Character,Character> map = new HashMap<>() ;
	  map.put('(', ')');
	  map.put('{', '}');
	  map.put('[', ']');
	  for(int i = 0 ; i < expression.length() ; ++i){
		  char symb = expression.charAt(i) ;
		  switch(symb){
		  case '(' : case '{' : case '[': st.push(symb) ; break ;
		  case ')' : case '}' : case ']':
			  if(st.empty()) return false ;
			  char lastOpenSymb = map.get(st.peek()) ;
			  if(lastOpenSymb== symb){
				  st.pop() ;
			  }else {
				  return false ;
			  }
			}
		  
	  }
	  
	  
	  return st.empty() ;
	
	
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(new ValidParaenthesis().isValid("(())"));
		System.out.println(new ValidParaenthesis().isValid("((())"));
		System.out.println(new ValidParaenthesis().isValid("(()))"));
		System.out.println(new ValidParaenthesis().isValid(""));
		System.out.println(new ValidParaenthesis().isValid(")))"));
		System.out.println(new ValidParaenthesis().isValid("((("));
		System.out.println(new ValidParaenthesis().isValid("(()}"));

	}

}
