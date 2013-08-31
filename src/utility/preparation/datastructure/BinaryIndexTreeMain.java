package utility.preparation.datastructure;

import java.io.InputStream;

import utility.DebugUtility;



public class BinaryIndexTreeMain {
 
 public static void main(String[] args) {
 Integer[] A={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
 //InputStream inputstream=System.in;
 
 //InputReader in = InputReader.getInputReader(inputstream);
 
 BinaryIndexTree solve=new BinaryIndexTree(A);
 //Integer x=in.nextInt();
 solve.updateAt(10, 1);
 solve.updateAt(13, 1);
 solve.updateAt(13, 1);
 solve.updateAt(13, 1);
 solve.updateAt(13, 1);
//System.out.println("value= "+solve.sum(x));
DebugUtility.print(solve.ftree);
 }
}

class BinaryIndexTree{
	Integer[] ftree;
	
	public BinaryIndexTree(Integer A[]){
		int size=A.length;
		ftree=new Integer[size];
		generateTree(A);
		ftree[0]=0;
	}
	
	
	private void generateTree(Integer [] A){
       for(int i=0;i<A.length;i++)
			ftree[i]=0;
			
		for(int i=1;i<A.length;i++)
			updateAt(i, A[i]);
		
	}
	
	public void updateAt(Integer idx,Integer newValue){
		Integer maxValue=ftree.length-1;
		while(idx<=maxValue){
			ftree[idx]+=newValue;
			idx+=(idx & -idx);
		}
	}
	
	public Integer sum(Integer idx){
		Integer sum=0;
		while(idx>0){
			sum+=ftree[idx];
			idx-=(idx & -idx);
		}
		
		return sum;
	}
	
	public Integer readAt(int idx){
		Integer value=ftree[idx];
		//find predecessor of idx
		Integer z=idx-(idx & -idx);
		idx--;
		while(z!=idx){
			value-=ftree[idx];
			idx-=(idx & -idx);
		}
		return value;
	}
	
	public Integer findFrequencySum(Integer target){
		Integer idx=0,currentIdx=0;
		Integer bitmask=ftree.length-1;
		
		while(bitmask!=0 && idx<(ftree.length-1)){
			currentIdx=idx+bitmask;
			if(target==ftree[currentIdx])
				return currentIdx;
			if(target>ftree[currentIdx]){
				target-=ftree[currentIdx];
				idx=currentIdx;
			}
			bitmask>>=1;
		}
		if(target!=0)
			return -1;
		else
			return idx;
		
	}
	
}