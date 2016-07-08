package utility.leetcode;

class IntegerToRoman {

	
	
	/*
	 *  I  1
	 *  V  5
	 *  X  10
	 *  L  50
	 *  C  100
	 *  D  500
	 *  M  1000
	 * 
	 * 
	 */
	
	public String intToRoman(int num) {
        StringBuilder resultStr = new StringBuilder(10);
        
        String [] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        
        
        
        for(int i = 0 ; i < values.length ; ++i){
        	while(num>=values[i]){
        		num-= values[i];
        	}
        }
        
        
        
        return new String(resultStr) ;
    }
}
