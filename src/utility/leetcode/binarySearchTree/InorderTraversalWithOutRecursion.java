package utility.leetcode.binarySearchTree;

import java.util.Stack;

public class InorderTraversalWithOutRecursion {


	
	public void inorderTraversal(TreeNode root){
		TreeNode current = root ;
		Stack<TreeNode> stack = new Stack<>();
		while(current != null || !stack.isEmpty()){
			if(current != null){
				stack.push(current) ;
				current = current.left ;
			}else{
				TreeNode t =  stack.pop();
				System.out.print(" "+t.val);
				current = t.right ;
			}
		}
	}
	
	
	public void inOrderTraversalWithOutStack(TreeNode root){
		TreeNode current = root ;
		
		while(current != null){
			
			if(current.left == null){
				System.out.print(" "+ current.val);
				current = current.right ;
			}
			else{
				// find inorder predecessor
				TreeNode pre = current.left ;
				while(pre.right != null && pre.right != current){
					pre = pre.right ;
				}
				
				if(pre.right ==null){
					pre.right = current ;
					current = current.left ;
					
				}else{
					pre.right = null ;
					System.out.print(" "+ current.val);
					current = current.right ;
				}
				
			}
		}
		
	}
	
    
	public static void main(String[] args) {
		InorderTraversalWithOutRecursion solver = new InorderTraversalWithOutRecursion();
		TreeNode tree = TreeUtil.getTree();
		TreeUtil.inOrder(tree);
		//solver.inorderTraversal(tree);
		solver.inOrderTraversalWithOutStack(tree);
		TreeUtil.inOrder(tree);
	}




}
