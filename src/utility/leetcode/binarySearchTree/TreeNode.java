package utility.leetcode.binarySearchTree;

class TreeNode {
 int val ;
 TreeNode left ;
 TreeNode right ;
 TreeNode(int x ) { this.val = x ; left = right = null ;}
 
 
 public static void inOrder(TreeNode root){
	 if(root!=null){
		 inOrder(root.left);
		 System.out.println(" "+root.val);
		 inOrder(root.right);
	 }
 }

}
