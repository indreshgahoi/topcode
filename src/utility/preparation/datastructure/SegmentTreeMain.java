package utility.preparation.datastructure;


import java.util.ArrayList;
import java.util.Arrays;

public class SegmentTreeMain {
	
	
	public static void main(String[] args) {
		
		Integer[] elements={1,2,3,6,8,2};
		
		SegmentTree<Segment, Integer> segtree=new SegmentTree<Segment, Integer>
		                                 (new ArrayList<Integer>(Arrays.asList(elements)));
		
		
		segtree.print_tree();
	}

}




interface   SegmentNode<E>
{
	 public    SegmentNode<E> getSegment(E e);
	 public    SegmentNode<E> combineSegments(SegmentNode<E> s1,SegmentNode<E> s2); 
}


class Segment implements SegmentNode<Integer>
{
	public Segment(Integer e)
	{
		this.max=e;	
	}
	
	public Segment getSegment(Integer e)
	{
		return new Segment(e);
	}
		
	Integer max;


	@Override
	public  SegmentNode<Integer> combineSegments(SegmentNode<Integer> s1,
			SegmentNode<Integer> s2) {
		
		
		Integer result;
		if(s2==null) return new Segment(((Segment)s1).max);
		if(((Segment)s1).max>((Segment)s2).max)
			result=((Segment)s1).max;
		else
			result=((Segment)s2).max;
		return new Segment(result);
	}

	
	@Override
	public String toString() {
		return max.toString();
	}
	
}


class SegmentTree<T extends SegmentNode<E>,E>
{
	
	
	public  T getInctance(Class<T> o) throws InstantiationException, IllegalAccessException
	{
		return o.newInstance();
	}
	
	public SegmentTree(ArrayList<E> elementArray)  {
		
	    size=elementArray.size();
		base=1;
		while(base<size)base<<=1;
		System.out.println("base="+base);
		
		this.tempArray=elementArray;
		try
			{
				 Class<T> o=null;
				 dummySegment= this.getInctance(o);
			} 
			catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
	
		tree=new ArrayList<SegmentNode<E>>(base<<1);
		for(int i=0;i<(2*base);++i)
		{
			tree.add(null);
		}
	    System.out.println("tree size="+tree.size());
		build(1);
		
		this.tempArray=null;
	}
	
	
	private void build(Integer idx)
	{
		if(idx>=base)
		{
			System.out.println("idx="+idx);
			if(size>(idx-base))
			tree.add(idx,dummySegment.getSegment(tempArray.get(idx-base)));
		}
		else
		{
			int  tidx=idx<<1;
			build(tidx);
			build(tidx+1);
			tree.add(idx, dummySegment.combineSegments(tree.get(tidx),tree.get(idx+1)));
		}
	}
	
	public String  print_tree()
	{
		return tree.toString();
	}
	
	private T dummySegment; 
	private Integer base;
    private Integer size;
	private ArrayList<E> tempArray;
	private ArrayList<SegmentNode<E> >   tree;
	
}























