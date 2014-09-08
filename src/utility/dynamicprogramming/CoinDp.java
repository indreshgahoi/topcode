package utility.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * Given a list of N coins, their values (V1, V2, ... , VN), and the total sum S. 
 * Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want),
 * or report that it's not possible to select coins in such a way that they sum up to S .
 * 
 * 
 * 
 */

class CoinDp {
     
	int coins[] ;
	int S ;
	
	
	public CoinDp(int value[],int Sum) {
		coins = value ;
		S = Sum ;
	}
	
	public int solve(int S)
	{
		int state[] ;
		state = new int[S+1] ;
		state[0] = 0 ;
		for(int i = 1 ; i<S+1;++i)
			state[i]= Integer.MAX_VALUE;
		
		for(int i= 1 ; i <= S ;++i)
		{
			for(int j = 0 ; j<coins.length ;++j)
			{
				if(i>=coins[j] && state[i-coins[j]]+1<state[i])
				{
					state[i] = state[i-coins[j]]+1 ;
				}
			}
		}
		for(int i = 0 ; i < S+1;++i)
		{
			System.out.println(" "+i+" => "+state[i]);
		}
		return state[S];
	}
       
	public static void main(String[] args) throws IOException 
	{
		InputReader in = InputReader.getInputReader() ;
		int N = in.nextInt() ;
		int S = in.nextInt() ;
		int coins[] ;
		coins = new int[N] ;
		for(int i = 0 ; i<N;++i)
			coins[i] = in.nextInt();
		CoinDp coinDp = new CoinDp(coins, S) ;
		int minNoCoin = coinDp.solve(S);
		System.out.println(""+minNoCoin);
	}
}

/*
 *  Input.txt
 * 
 * 
 */


class InputReader
{
	private BufferedReader br ;
	private StringTokenizer strk ;
	private static InputReader input = null ;
	
	private InputReader()
	{
		br = new BufferedReader(new InputStreamReader(System.in)) ;
	}
	
	public static InputReader  getInputReader()
	{
		if(input==null)
		{
			input = new InputReader();
			
		}
		return input ;
	}
	
	
	public	String next()
	{
		String line = "" ;
		
		while(strk==null || !strk.hasMoreElements() && line!=null)
		{
			
			try {
				line = br.readLine();
				strk = new StringTokenizer(line);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}
		
		return strk.hasMoreElements()? strk.nextToken() : null ;
	}
	
	int nextInt()
	{
		return Integer.parseInt(next()) ;
	}
	double nextDouble()
	{
		return Double.parseDouble(next()) ;
	}
}


