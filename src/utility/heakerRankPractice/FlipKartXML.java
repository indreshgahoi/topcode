package utility.heakerRankPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlipKartXML {

	public static class Node{
		public String name;
		public Integer value;
		public Long expansaionCount;
		public List<Node> child ;
	}
	static HashMap<String, Integer> graph = new HashMap<>(); 
	static List<Node> nodeList = new ArrayList<>();
	
	static void entityExpansion(long l, String[] entities) {
	    int i = 0 ;
		for(String entity: entities){
			Node node = getNode(entity);
			nodeList.add(node);
			graph.put(node.name, i);
			i++;
		}
		long count = 0 ;
		long resultCount = count ;
		for(Node node: nodeList){
			count += expandNode(node);
			if( count > (10^18) ){
				resultCount = 0l ;
			}else{
				resultCount = count;
			}
		}
		
		
		if(count > l){
			System.out.println("0 " + resultCount);
		}else{
			System.out.println("1 " + resultCount);
		}
		
    }
	
	
	static Node getNode(String entity){
		entity = "<!ENTITY a1 10;a2>";
		String[] nodeStrings = entity.substring(8, entity.length()-1).split(" |;");
		Node node = new Node();
		node.child = new ArrayList<>();
		node.name = nodeStrings[0];
		node.expansaionCount = 0l;
		for(int i = 1; i < nodeStrings.length;++i){
			if(isInteger(nodeStrings[i])){
				node.value = Integer.parseInt(nodeStrings[i]);
				node.expansaionCount = 1l;
			}else{
				Integer index = graph.get(nodeStrings[i]);
				if(index != null){
					node.child.add(nodeList.get(index));
				}
			}
			
		}
		return node;
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
	static Long expandNode(Node node){
		// detect cycle
		if(node.child==null || node.child.size()==0) {
			return 1l;
		}
		long expandCount = node.expansaionCount ; 
		for(Node child : node.child){
			expandCount += expandNode(child);
		}
		node.expansaionCount = expandCount;
		return expandCount ;
	}
	public static void main(String[] args) {
		getNode("");
	}
}
