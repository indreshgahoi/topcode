package utility.topcoder.srm573;

public class First250 {

	public int minCost(int[] altitude)
	{
		int len=altitude.length;
		int ans=0;
		for(int i=0;i<len;i++){
			if(altitude[i]>altitude[i-1]){
				ans=altitude[i]-altitude[i-1];
				altitude[i]=altitude[i-1];
			}
		}
		return ans;
		
	}
	
	
}
