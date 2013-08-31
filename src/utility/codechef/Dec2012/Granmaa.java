package utility.codechef.Dec2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Granmaa {
	
public static void main(String[] args)throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	int test=Integer.parseInt(br.readLine());
	while(test --> 0){
		st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		int len1 = a.length();
		String b = st.nextToken();
		int len2 = b.length();
		int arr[] = new int[26];
		int brr[] = new int[26];
		for (int i=0; i<len1; i++) {
		arr[a.charAt(i)-'a']++;
		}
		for (int i=0;i<len2;i++) {
		brr[b.charAt(i)-'a']++;
		}
		String ans = "YES";
		for (int i=0;i<26;i++) {
		if((arr[i] == 0 && brr[i] != 0) || (brr[i] == 0 && arr[i] != 0))
		{
		ans = "YES";
		break;
		}
		if(arr[i] == brr[i]){
		continue;
		}
		else{
		ans = "NO";
		//break;
		}
		}
		System.out.println(ans);
		}
}
}
