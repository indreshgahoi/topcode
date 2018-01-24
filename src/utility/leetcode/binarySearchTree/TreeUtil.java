package utility.leetcode.binarySearchTree;

public class TreeUtil {

	
	public static TreeNode getTree() {

		TreeNode root = new TreeNode(5), returnNode = root;
		root.setLeft(new TreeNode(6));
		root.setRight(new TreeNode(7));
		root = root.left;
		root.setLeft(new TreeNode(8));
		root.setRight(new TreeNode(9));

		return returnNode;
	}

	private static void inOrderUtil(TreeNode root){
		if (root != null) {
			inOrderUtil(root.left);
			System.out.print(" " + root.val);
			inOrderUtil(root.right);
		}
		
	}
	
	
	public static void inOrder(TreeNode root) {
		System.out.println("\n### start ###");
		inOrderUtil(root);
		System.out.println("\n### end ###");
	}

}
