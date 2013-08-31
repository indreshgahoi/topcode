package utility.preparation.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import utility.DebugUtility;





public class SuffixArrayUsingCountSort {

String str;	
Integer[] permutation; //permutation of the suffix index
Integer[] bucket;
int H;
//for count sort;
int alphabet;

public SuffixArrayUsingCountSort(String str){
	this.str=str;
	alphabet=26;
	permutation=new Integer[str.length()];
	bucket=new Integer[str.length()];
	for(int i = 0; i < str.length(); i++){
		permutation[i]=i;
		bucket[permutation[i]]=str.charAt(i)-'a';
    }
	
	
	
}

void updateBucket(){
	Integer[] tempBucket=new Integer[bucket.length];
	for(int i=0;i<tempBucket.length;i++)
		tempBucket[i]=alphabet;
	
	tempBucket[permutation[0]]=0;
	for (int i = 1,id=0; i < permutation.length; i++) {
		if(bucket[permutation[i]]!=bucket[permutation[i-1]] || 
				(((permutation[i]+H)<permutation.length?bucket[permutation[i]+H]:0)-((permutation[i-1]+H)<permutation.length?bucket[permutation[i-1]+H]:0))!=0)
			id++;
		tempBucket[permutation[i]]=id;
	}
	bucket=tempBucket;
}
public Integer[] getSuffixArray(){
	countSort(permutation,alphabet);
	updateBucket();
	printPermutation();
	System.out.println("\n");
	
	DebugUtility.print(bucket);
	for(H=1;H<permutation.length;H=2*H){
		System.out.println(" for h="+H+"\n");
		System.out.println("first bucket");
		DebugUtility.print(bucket);
		countSort(permutation, alphabet);
		updateBucket();
		//updateBucket();
	
		
		printPermutation();
		//System.out.println("second bucket");
		//DebugUtility.print(bucket);
		
	}
	printPermutation();
	return permutation;
}

void printPermutation(){
	for(int i=0;i<permutation.length;i++)
		System.out.println(" "+permutation[i]+" "+str.substring(permutation[i]));
	System.out.println();
}

void countSort(Integer[]A,Integer alphabet){
	Integer[]C=new Integer[alphabet+1];
	Integer[]B=new Integer[A.length];
	
	for(int j=0;j<alphabet;j++)
		C[j]=0;
	for(int j=0;j<A.length;j++)
		C[bucket[A[j]]]++;
		
	
	for(int i=1;i<alphabet;i++)
		C[i]=C[i]+C[i-1];
	
	for(int i=A.length-1;i>=0;i--){
		B[--C[bucket[A[i]]]]=A[i];
		
	}
//	bucket=tempBucket;
	permutation=B;
	//DebugUtility.print(B);
	
}
 public static void main(String[] args) {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	try{
		Integer[] a=new SuffixArrayUsingCountSort(br.readLine()).getSuffixArray();
		//DebugUtility.print(a);
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

}
