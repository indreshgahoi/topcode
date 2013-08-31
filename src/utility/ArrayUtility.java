package utility;


import java.util.Arrays;
import java.util.Comparator;
import utility.input.InputReader;
import utility.input.NextInput;

class WrapData implements Cloneable  {
	int a;
	public WrapData(InputReader in){
		this.a=in.nextInt();
	}
	 public int get(int i){
	    	return a;
	    }
	    
	   public void set(int value){
		   a=value;
	   }
	public String toString() {
		  return " "+a;
		}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}


public class ArrayUtility<T extends Comparable<T> , U extends NextInput<T>>  {
	 int size;
	 T [] data;
	 U u;
	 InputReader input;


	public ArrayUtility(int size,T[] a,U u){
		this.size=size;
		
		this.data=a;
		this.u=u;
		//data=new T[size];
		input=InputReader.getInputReader();
		
	}
	
	public void  fillByUser(){
		for(int i=0;i<size;i++){
		  	data[i]=(T)u.nextT();
		}
	}
	
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    String row1="",row2="";
        for(int i=0;i<size;i++){
        	row1+=" i="+i+" "; 
        	row2+=" ["+data[i]+"] ";
    	} 
        
        return row1+"\n"+row2;
    }
   
    
    
    public void inSort(){
    	Arrays.sort(data,
    			new Comparator<T>()
    			{  
    		       @Override
    		    public int compare(T o1, T o2) {
    		    	// TODO Auto-generated method stub
    		    	return o1.compareTo(o2);
    		    }
		         
    			});
    }
    
    
    
    
    public void deSort(){
    	Arrays.sort(data,
    			new Comparator<T>() 
    			{  
    		       @Override
    		    public  int compare(T o1, T o2) {
    		    	// TODO Auto-generated method stub
    		    	return o2.compareTo(o1);
    		    }
		         
    			});
    	
    }
    public void set(T a,int idx){
    	data[idx]=a;
    }
    public T get(int i){
    	return data[i];
    }
    public T[] getArray(){
    	return this.data;
    }
  

}
