package utility.leetcode.binarySearchTree;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		this.val = x;
		left = right = null;
	}

	void setLeft(TreeNode left) {
		this.left = left;
	}

	void setRight(TreeNode right) {
		this.right = right;
	}

}
