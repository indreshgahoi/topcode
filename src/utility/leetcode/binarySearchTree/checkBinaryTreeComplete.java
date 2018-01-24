package utility.leetcode.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class checkBinaryTreeComplete {

	
	
	// if any non-null node is find then next other node must be leaf node
	
	
	
	boolean checkCompleteTree(TreeNode root){
	    
		boolean isNonFullFound = false ;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			TreeNode t = q.poll() ;
			
			if(t.left != null){
				if(isNonFullFound)
					return false ;
				q.add(t.left);
			}
			else
				isNonFullFound = true ;
			if(t.right != null){
				if(isNonFullFound)
					return false ;
				q.add(t.right);
			}else
				isNonFullFound = true ;
		}
		
		return true ; 	
	}
	
	
	
}
