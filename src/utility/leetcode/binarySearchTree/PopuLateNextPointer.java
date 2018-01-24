package utility.leetcode.binarySearchTree;


class TreeNodeWithNextPointer {
	
	TreeNodeWithNextPointer left , right , next ;
	
}


public class PopuLateNextPointer {

	
	public void populateNextPointerSolver(TreeNodeWithNextPointer root){
		
		TreeNodeWithNextPointer current = root ;
		while(current != null){
			TreeNodeWithNextPointer next = null, pre = null ;
			while(current != null){
				if(next ==null){
					next = current.left != null ? current.left : current.right ;
				}
				
				if(current.left != null){
					if(pre != null){
						pre.next = current.left ;
					}
					pre = current.left ;
				}
				if(current.right != null){
					if(pre != null){
						pre.next = current.right ;
					}
					pre = current.right ;
				}
				current = current.next ;
			}
			current = next ;
		}
		
	}
	
}
