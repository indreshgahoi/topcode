package utility.leetcode.binarySearchTree;

public class MirrorTree {

	
	
	public void mirrotTree(TreeNode root){
		if(root != null){
			mirrotTree(root.left);
			mirrotTree(root.right);
			TreeNode t = root.left ;
			root.left = root.right ;
			root.right = t ;
		}
	}
	
	public static void main(String[] args) {
		MirrorTree solver = new MirrorTree();
		TreeNode tree = TreeUtil.getTree();
		TreeUtil.inOrder(tree);
		solver.mirrotTree(tree);
		TreeUtil.inOrder(tree);
	}
}
