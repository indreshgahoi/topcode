package utility.leetcode.binarySearchTree;

class SortedListToBST {
 
	ListNode CurrRef = null;
	
	Integer getSize(ListNode head){
	 int size = 0 ;
	 while(head != null){
		 size++;
		 head = head.next ;
	 }
	 return size ;
	}
	
	public TreeNode sortedListToBST(int size){
		if(size==0 ) return null ;
		TreeNode  leftNode = sortedListToBST(size/2);
		TreeNode root = new TreeNode(CurrRef.val);
		CurrRef = CurrRef.next ;	
		root.right = sortedListToBST(size - size/2-1);
		root.left = leftNode ;
		return root ;
	}
	
	
	public TreeNode sortedListToBST(ListNode head) {
	  CurrRef =  head ;
      Integer size = getSize(head);
      return sortedListToBST(size) ;
	}
	
	public static void main(String[] args) {
		
		ListNode head = ListNode.createList(new int[]{1,2,3,4,5,6,7});
		
		TreeNode.inOrder(new SortedListToBST().sortedListToBST(head));
	}
}
