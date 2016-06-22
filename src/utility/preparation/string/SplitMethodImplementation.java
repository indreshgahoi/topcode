package utility.preparation.string;

import java.util.ArrayList;
import java.util.Arrays;

class SplitMethodImplementation {

	
	public static String[] split(String stream, char separtor){
		
		if(stream==null) return null;
		if(stream.length()==0) return null ;
		ArrayList<String> strs = new ArrayList<>() ;
		int off = 0 ;
		int next = 0 ;
		
		while(off < stream.length()){
			next = stream.indexOf(separtor, off) ;
			if(next != -1){
				strs.add(stream.substring(off, next));
				off = next+1 ;
			}else {
				strs.add(stream.substring(off,stream.length()));
				break ;
			}
		}
		String strArray[] = strs.toArray(new String[strs.size()]);
		return strArray ;
	}
	
	
	
	public static void main(String[] args) {
		

		
		
	}

}
