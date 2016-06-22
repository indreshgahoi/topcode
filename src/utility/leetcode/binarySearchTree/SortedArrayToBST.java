package utility.leetcode.binarySearchTree;

public class SortedArrayToBST {

	
	 TreeNode sortedArrayToBST(int[] num , int start , int end){
		 if(start > end) return null ;
		 int mid = start + (end-start)/2 ;
		 TreeNode root = new TreeNode(num[mid]) ;
		 root.left = sortedArrayToBST(num, start,mid-1);
		 root.right = sortedArrayToBST(num,mid+1,end);
		 return root ;
	 }
	
	 public TreeNode sortedArrayToBST(int[] num) {
	        return sortedArrayToBST(num, 0, num.length-1);
	 }
	
	public static void main(String[] args) {
		
	}
}
