package utility.preparation.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import utility.DebugUtility;




class Suffix implements Comparable<Suffix>{
  static String str;
  static int H=0;
  static int[] Bucket;
  static int[] alphabet;
  
  int idx;
  public Suffix(){
	  
  }
  public Suffix(int idx){
      this.idx=idx;
  }
 
public int compareTo(Suffix s) {
   
    if(H==0)
        return str.charAt(idx)-str.charAt(s.idx);
    if(Bucket[idx]==Bucket[s.idx])
        return ((idx+H)<str.length()?Bucket[idx+H]:0)-((s.idx+H)<str.length()?Bucket[s.idx+H]:0);
    else
        return Bucket[idx]-Bucket[s.idx];
}

public  void updateBucket(Suffix[] sfx){
    int [] tempBucket=new int[sfx.length];
     tempBucket[sfx[0].idx]=0;
    for(int i=1,id=0;i<sfx.length;i++){
           if(!sfx[i].equals(sfx[i-1]))
                id++;
           tempBucket[sfx[i].idx]=id;
    }
    Suffix.Bucket=(int[])tempBucket.clone();
   
}

//Nlog^2N implements

public  void SuffixSort(String str){
	
	Suffix.str=str;
	
	Suffix[] sfx=new Suffix[str.length()];
    Suffix.Bucket =new int[str.length()];
    
	for (int i = 0; i < sfx.length; i++) {
        sfx[i]=new Suffix(i);
    }
  
    //sort for H=0
    Arrays.sort(sfx);
    updateBucket(sfx);
    printSfxs(sfx);
    DebugUtility.print(Bucket);
    
    for(Suffix.H=1;Suffix.H<Suffix.str.length();Suffix.H=2*Suffix.H){
        Arrays.sort(sfx);
        updateBucket(sfx);
        printSfxs(sfx);
        DebugUtility.print(Bucket);
        
    }
    printSfxs(sfx);
}
 

public  void printSfxs(Suffix[] sfx){
    
	for (int i = 0; i < sfx.length; i++) {
         System.out.println(sfx[i]); 
        }
    System.out.println("\n");
}

public String toString() {
       return idx+" "+str.substring(idx);
}

public boolean equals(Suffix s) {
            if(this.compareTo(s)==0)
                return true;
            return false;
}

}

public class SuffixArray {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
        	 new Suffix().SuffixSort(br.readLine());
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
     
     
    }
   
    
}