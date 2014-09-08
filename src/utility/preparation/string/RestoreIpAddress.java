package utility.preparation.string;

import java.util.ArrayList;

public class RestoreIpAddress {
	
	
	 void    restoreIpAddress(char str[],int start,int end,int part,String res,ArrayList<String> list){
    	 if(start>end) return;
    	 
    	 if(part==3 && (end-start+1)<4){
    		
    		 String t=new String(str, start, end-start+1);
            Integer num=0;
            num=Integer.parseInt(t);
    		if( num<=255 )
    		{
                String ts=res+num.toString();
                if((ts.length()-3)==str.length)
    			list.add(ts);
    		}
    	 }
    	 else{
    	 Integer num=0;
    	 for(int i=start;i<=start+3 && i<=end;i++){
    		 num=(num*10)+(str[i]-'0');
    		 if(num<=255){
    			 String tmp=new String(res+num.toString()+".");
    			 restoreIpAddress(str, i+1, end, part+1, tmp, list);
    		}
    		 else
    			 break;
    	 }
    	 } 
     }
	
	
	 public ArrayList<String> restoreIpAddresses(String s) {
	        
	      char[] str=s.toCharArray();
	      int len=s.length();
	      ArrayList<String> list=new ArrayList<>();
	      if(len>=13)
	    	  return list;
	      restoreIpAddress(str, 0, len-1, 0, "", list);
	      return list;
	    }

	 public static void main(String[] args) {
		RestoreIpAddress q=new RestoreIpAddress();
		String s="25525511135";
		System.out.println(q.restoreIpAddresses(s));
	}
}
