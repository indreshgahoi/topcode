package utility.leetcode.binarySearchTree;

class ListNode {
  int val ;
  ListNode next ;
  ListNode(int x ) { this.val = x ; next = null ;}

  
  public static ListNode createList(int arr[]){
	  if(arr.length == 0) return null ;
	  ListNode head = new ListNode(arr[0]);
	  ListNode pre = head ;
	  for(int i = 1 ; i < arr.length ;++i){
		  pre.next = new ListNode(arr[i]) ;
		  pre = pre.next ;
	  }
	  
	  return head ;
  }
  
}
