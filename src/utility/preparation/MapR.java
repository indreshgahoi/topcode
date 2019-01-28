package utility.preparation;

import java.util.concurrent.ConcurrentHashMap;

public class MapR {

	ConcurrentHashMa
	
	class Node {
		int value ;
		Node next ;
	}
	
	
	
	
	public boolean isPalindrone(Node node) {
		Node head = node ;
		Node firstHalf = node;
		Node secondHalf = reverseList(findMidddle(node));
		
		int count = 0;
		
		while(firstHalf.next != null && secondHalf.next != null) {
			if(firstHalf.value != secondHalf.value) {
				return false;
			}
			firstHalf = firstHalf.next ;
			secondHalf = secondHalf.next;
		}
		return true;
	}
	
	
	public Node findMidddle(Node node) {
		int length = length(node);
		int distance = ((length + 1)/ 2) ;
		Node resultNode = node;
		while(distance-->0) {
			resultNode = resultNode.next;
		}
		
		return resultNode;
	}
	
	public int length(Node node) {
		int length = 0;
		while(node != null) {
			node = node.next;
			length ++;
		}
		return length;
	}
	
	
	public Node reverseList(Node node) {
		Node current = node;
		Node next = node;
		Node prevoius = null ;
		while(current != null) {
			next = current.next;
			current.next = prevoius ;
			prevoius = current ;
			current = next;
		}
		return prevoius;
	}

}
