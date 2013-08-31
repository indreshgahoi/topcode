package utility.preparation.graph.ShortestPath.Dijkstra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

import utility.DebugUtility;
/*
 * SRM 150 DIV 1 1000 Level 3
 */
class node{
	int x,y;
	int id;
	node[] edge={null,null,null,null,null,null};
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public node(Integer x,Integer y,int id) {
		this.x=x;
		this.y=y;
		this.id=id;
	}
	public node(Integer x,Integer y) {
		this.x=x;
		this.y=y;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		node other = (node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Node:["+x+","+y+"]"+" id:"+id;
	}
}
class state implements Comparable<state>{
	Integer times;
	Integer id;
	Integer dir;
	Integer fstep;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public Integer getDir() {
		return dir;
	}
	public void setDir(Integer dir) {
		this.dir = dir;
	}

   public state(Integer times,Integer dir,Integer id,Integer fstep){
	   this.times=times;
	   this.dir=dir;
	   this.id=id;
	   this.fstep=fstep;
   }
	public int compareTo(state o) {
		
		if(this.times<o.times)
			return -1;
		if(this.times>o.times)
			return 1;
		if(this.id<o.id)
			return -1;
		if(this.id>o.id)
			return 1;
		
		if(this.dir<o.dir)
			return -1;
		if(this.dir>o.dir)
			return 1;
		return 0; 
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		state st=(state)obj;
		
		return (st.dir==this.dir && st.id==this.id && st.times==this.times);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:"+id+" times="+times+" dir:"+dir+" fstep:"+fstep;
	}
}
public class RoboCourier
{ 
	int[] dx={0,1,1,0,-1,-1};
	int[] dy={1,1,0,-1,-1,0};
	Map<node,Integer> vertex;
	node [] list;
	Integer noOfNode;
	Integer start=0,dest;
	public RoboCourier(){
		vertex =new HashMap<node,Integer>();
		list=new node[500];
		noOfNode=0;
	}
	Integer getNode(Integer x, Integer y){
		Integer t=vertex.get(new node(x,y));
		if(t!=null)
			return t;
		t=++noOfNode;
		vertex.put(new node(x,y,t),t);
		list[t]=new node(x,y,t);
		return t;
		
	}
	
	/*
	 * main function for solving
	 */
	
	int shortestpath(){
		
		state[] st=new state[(noOfNode+1)*6];
		boolean[] visited=new boolean[(noOfNode+1)*6];
		
		for(int i=0;i<st.length;i++){
			st[i]=new state(Integer.MAX_VALUE,i%6,i/6,0);
		}
		
		st[0].setTimes(0);
		st[0].setTimes(0);
		
		PriorityQueue<state> pq=new PriorityQueue<state>((noOfNode+1)*6,new Comparator<state>() {

			@Override
			public int compare(state o1, state o2) {
				
				return o1.compareTo(o2);
			}
		});
		pq.add(st[0]);
		
		while(pq.size()>0){
			//System.out.println(pq);
			state curr=pq.poll();
			Integer currId=curr.getId();
			//System.out.println(curr);
			
		/*	if(pq.contains(pq.first())){
			System.out.println("hello"+pq.first());
			}
			else
			{
			System.out.println("not find"+pq.first());	
			}
			pq.remove(curr);*/
			
			
			
			if(visited[currId*6+curr.dir])
				continue;
			visited[currId*6+curr.dir]=true;
			
			if(currId==dest)
				return st[currId*6+curr.dir].times;
			
			for(int i=0;i<6;i++){
				
				if(list[currId].edge[i]!=null){
					//System.out.println("for="+list[currId].edge[i]);
					Integer minDir=Math.min(6-Math.abs(i-curr.dir),Math.abs(i-curr.dir));
					Integer time=st[(list[currId].edge[i].id)*6+i].times;
					Integer tm=4;
			        
					if(i==curr.dir){
						tm=4;
						if(curr.fstep>=2)
				        	tm=2;
					      state tmp=curr;
						  Integer step=curr.fstep;
						  
						  while(list[tmp.id].edge[i]!=null){
							  tm=4;
								if(tmp.fstep>=2)
						        	tm=2;
						     Integer t=st[(list[tmp.id].edge[i].id)*6+i].times;	
							 //System.out.println("go to if"+list[tmp.id].edge[i]);
						     if((tmp.times+tm)<t){
									st[(list[tmp.id].edge[i].id)*6+i].times=(tmp.times+tm);
									pq.add(st[(list[tmp.id].edge[i].id)*6+i]);
									//System.out.println(pq);
							  st[(list[tmp.id].edge[i].id)*6+i].fstep=tmp.fstep+1;
							 }
							
						    tmp=st[(list[tmp.id].edge[i].id)*6+i];
						 }
					}
					else
					{
						
						if((curr.times+(3*minDir)+tm)<time){
							st[(list[currId].edge[i].id)*6+i].fstep=1;
							//System.out.println("go to update tm="+tm);
							st[(list[currId].edge[i].id)*6+i].times=curr.times+(3*minDir)+tm;
							pq.add(st[(list[currId].edge[i].id)*6+i]);
							//System.out.println(pq);
					   }
						
					}
					//System.out.println("out "+(curr.times+(3*minDir)+tm)+" time="+time);
					
			    }
			}
			
			
		}
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<6;i++)
			min=Math.min(min,st[dest*6+i].times);
		return min;
	}
	public int timeToDeliver(String[] path)
	{
		String fullpath="";
		
		for (String string : path) {
			fullpath+=string;
		}
		Integer x=0,y=0,dir=0;
		list[0]=new node(0,0);
		vertex.put(list[0],0);
		Integer pre=0;
		start=0;
		for(int i=0;i<fullpath.length();i++){
			switch (fullpath.charAt(i)) {
			case 'R':
				 dir=(dir+1)%6;
				break;
            case 'L':
				dir=(dir+5)%6;
				break;
           case 'F':
				x+=dx[dir];
				y+=dy[dir];
				Integer t=getNode(x, y);
				list[pre].edge[dir]=list[t];
				list[t].edge[(dir+3)%6]=list[pre];
				//System.out.println(""+list[pre]+" link to "+list[pre].edge[dir]);
				//System.out.println(""+list[t]+" link to "+list[t].edge[(dir+3)%6]);
				//System.out.println();
				pre=t;
				break;
			}
		}
	    dest=pre;
		return shortestpath();
	}
	
	public static void main(String[] args) {
		RoboCourier task= new RoboCourier();
		
		System.out.println(""+(task.timeToDeliver(new String[]
				{"FFLRLFRRFRFFRLFRLRLRLRLRLFFRLRLRLFRLFRFFLLFFFFR", "RLFFLRLFRFFFLLFFFFFRFRLFLRLRFFFLFFFRFFFFFLFFFFF", "FFFRLRFFRFFFRFLRFFFLRFFFLRFFRLFFFFFFFRLFFFLRLRL", "RLFRLFFFRLRLRFLRLFFFFFFFRLFFFFRFFFRRFLFFFFFLLFF", "FFRLFFFFRFFLFFLFRLFFFFFFFFFFRFFFFFLFRLRRFFFLRLF", "LFRLFFFFFFFFFRFFFLRFFFFFFFRLFLFLRRFLFFFRFFFLLFF", "RFFLFFRFFRFFFFFFFRFFFRFLFFLRFFRLFFFFFFFLFFLFFLR", "FFFFRFFFFFRLFFFFLFFLRFFFLFFFFFFFFLFLFFRRLRLRLRF", "FFRFLFFFLRFFLRLLFRLRLRFFFRFFFFRFRRFLLFFFFRLRLRF", "FFFFFRRFFFRLLFFFFFLRFRFFFFR"})));
	//	System.out.println("dest="+task.dest);
	 //  for(int i=0;i<=task.noOfNode;i++)
	//    	   System.out.println(""+task.list[i]);

	}
}