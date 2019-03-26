package utility.crackingCodeInterview.treeGraph;

public class CheckBalanceBinaryTree {
	
	private class Node {
		int value;
		Node left, right;
	}
	
	
	private int maxHeight(Node root) {
		if(root == null) return 0;
		return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
	}
	
	private int minHeight(Node root) {
		if(root == null) return 0;
		return 1 + Math.min(minHeight(root.left), minHeight(root.right));
	}
	
	public boolean isBalanced(final Node root) {
		return Math.abs(maxHeight(root) - minHeight(root)) <= 1;
	}

}
