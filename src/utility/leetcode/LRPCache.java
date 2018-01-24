package utility.leetcode;

import java.awt.SecondaryLoop;
import java.util.Map;



class DllNode<T> {
    public T key ;
    public DllNode<T> next ;
    public DllNode<T> pre ;
    
    public DllNode(T key){
    	this.key = key ;
    	this.next = null ;
    	this.pre = null ;
    }
    
}


class Queue<T>
{
   
	private int capacity  ;
    private int _size ;
    private DllNode<T> first;
    private DllNode<T> last ;


    public Queue(int size){
    	this.capacity = size ;
    	this._size = size ;
    	first = new DllNode<T>(null);
    	last = new DllNode<T>(null);
        first.pre = null;
        first.next = last ;
        last.pre = first ;
        first.next = null ;
    }
    
    public DllNode<T> getFront(){
    	return this.first.next ;
    }
    

 
    
 
  
   
    boolean isEmpty()
    {
        return first.next==last ;
    }
   
    public int size()
    {
        return _size ;
    }
    
    public DllNode<T> push(T key)
    {

        DllNode<T> t = new DllNode<T>(key) ;
        last.pre.next = t ;
        t.pre = last.pre ;
        t.next = last ;
        last.pre = t ;
        _size++ ;
        return t ;
    }

    public <T> void pop()
    {
        if(first.next == last){
        	return ;
        }
        else
        {
        	DllNode t = first.next ;
            first.next = t.next ;
            t.next.pre = first ;
            _size-- ;
            
        }
    }

    public <T>
    void moveFront(DllNode t)
    {
       if(_size>1)
       {
    	deattach(t);
        last.pre.next = t ;
        t.pre = last.pre ;
        t.next = last ;
        last.pre = t ;
        _size++ ;
       }
    }
   
    public void moveBack(DllNode t)
    {
       if(_size>1)
       {
    	deattach(t);
    	t.next = first.next ;
    	first.next.pre = t ;
        t.pre = first ;
        first.next = t ;
        _size++ ;
       }
    }

    
    public boolean deattach(DllNode t)
    {
        if(first.next != (last))
        {
            t.pre.next = t.next ;
            t.next.pre = t.pre ;
            _size-- ;
        }
        return true ;
    }

    public void print()
    
    {
    	DllNode curr = first.next ;
    	
    	while(curr != last)
    	{
    		System.out.print(curr.key);
    		curr = curr.next ;
    		
    	}
    	
    }
 
    
}






class LRUCache{
    
    private int capacity ;
    private Queue<Integer> Q ;
    private Map<Integer,DllNode<Integer>> H ;
    
    
    LRUCache(int cap) {
        capacity = cap ;
    }

    int get(int key) {
        
        if(H.containsKey(key))
        {
            DllNode<Integer> t = H.get(key);
            Q.moveFront(t);
            return t.key ;
        }
        return - 1;
    }
    /*
     if Already in cache ;
     update value and move to front
     else
     {
     if cache is full pop front and remove from hash
     then push other wise direct push
     push to queue i
     }
     */

    void set(int key) {
      
        if(H.containsKey(key))
        {
            DllNode<Integer> t = H.get(key);
            t.key = key ;
            Q.moveFront(t);
        }
        else
        {
            if(Q.size()==capacity)
            {
            	 DllNode<Integer> t = Q.getFront() ;
                 
                 //H.erase(H.find(t->key.key));
                 H.
                 Q.pop();
            }
            /*
              it already go in front
             */
            info i ;
            i.key = key ;
            i.value = value ;
            H[key] =Q.push(i); ;
        }
    }
};



public class LRPCache {

}
