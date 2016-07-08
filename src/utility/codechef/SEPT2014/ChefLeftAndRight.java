package utility.codechef.SEPT2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefLeftAndRight {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(
				ChefLeftAndRight.class.getResourceAsStream("input.txt")));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String str = br.readLine();
			int len = str.length();
			boolean isEven = str.length() % 2 == 1;

			long start = 0;

			if (len > 0) {
				if (isEven) {
					if (str.charAt(0) == 'l') {
						start = 2;
					} else {
						start = 4;
					}
				} else {
					start = 1;
				}
			}
			
			
			long id = 1 ;
			
			System.out.println("2 ^ 65 "+(1l<<64));
			for(int i = 0 ; i < len ; ++i){
				if(str.charAt(i)=='l'){
					id = 2 *id - 1 ;
				}else {
					id = 2*id + 1 ;
				}
			}

			if (isEven) {
				for (int i = 2; i < len; i = i + 2) {

					if (str.charAt(i - 1) == 'l' && str.charAt(i) == 'l') {
						start = (start/2 * 4) + 2;
					} else if (str.charAt(i - 1) == 'l' && str.charAt(i) == 'r') {
						start = (start/2 * 4) + 4;
					} else if (str.charAt(i - 1) == 'r' && str.charAt(i) == 'l') {
						start = (start/2 * 4) + 6;
					} else if (str.charAt(i - 1) == 'r' && str.charAt(i) == 'r') {
						start = (start/2 * 4) + 8;
					}
				}
			} else {
				
				
				for (int i = 1; i < len; i = i + 2) {

					if (str.charAt(i - 1) == 'l' && str.charAt(i) == 'l') {
						start =((start+1)/2 * 4) - 1;
					} else if (str.charAt(i - 1) == 'l' && str.charAt(i) == 'r') {
						start = ((start+1)/2 * 4)+ 1;
					} else if (str.charAt(i - 1) == 'r' && str.charAt(i) == 'l') {
						start = ((start+1)/2 * 4) + 3;
					} else if (str.charAt(i - 1) == 'r' && str.charAt(i) == 'r') {
						start = ((start+1)/2 * 4) + 5;
					}
					System.out.println(start);
				}
			}
			
			System.out.println(start);

		}
	}
}
