package utility;

public class DebugUtility {
	
	public static void print(Integer M[][]){
		int col=M[0].length;
		int row=M.length;
		String detail="   ";
		for(int j=0;j<col;j++)
			detail+="  j="+j;
		detail+="\n";
		for(int i=0;i<row;i++)
		{    
			detail+="i="+i+"";
			for (int j = 0; j < col; j++) {
				detail+="  ["+M[i][j]+"]";
			}
			detail+="\n";
		}
		System.out.println(detail);
	}
	public static void print(Integer[] A) {
    	// TODO Auto-generated method stub
		System.out.println("");
    String row1="",row2="";
        for(int i=0;i<A.length;i++){
        	row1+=" i="+i+" "; 
        	row2+=" ["+A[i]+"] ";
    	} 
        
        System.out.println(row1+"\n"+row2);
    }
	public static void print(int[] A) {
    	// TODO Auto-generated method stub
    String row1="",row2="";
        for(int i=0;i<A.length;i++){
        	row1+=" i="+i+" "; 
        	row2+=" ["+A[i]+"] ";
    	} 
        
        System.out.println(row1+"\n"+row2);
    }
	public static void print(Object[] A) {
    	// TODO Auto-generated method stub
    String row1="",row2="";
        for(int i=0;i<A.length;i++){
        	row1+=" i="+i+" "; 
        	row2+=" ["+A[i]+"] ";
    	} 
        
        System.out.println(row1+"\n"+row2);
    }

}
