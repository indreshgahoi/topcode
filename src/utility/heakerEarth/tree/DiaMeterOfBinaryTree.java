package utility.heakerEarth.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class BinaryTree{
	
	private BinaryTree left = null ;
	private BinaryTree right = null ;
	int val ;
	public BinaryTree(int val){
		this.val = val;
	}
	public BinaryTree getLeft(){
		return this.left ;
	}
	
	public BinaryTree getRight(){
		return this.right ;
	}
	
	public void setLeft(BinaryTree node){
		this.left = node ;
	}
	public void setRight(BinaryTree node){
		this.right = node ;
	}
	public void setVale(int x){
		this.val = x ;
	}
	
	public int getValue(){
		return this.val ;
	}
}


public class DiaMeterOfBinaryTree {

	private static int diaMeter = 0 ;
	
	public static void main(String[] args) {
		int V = nextInt() -1, rootVal = nextInt() ;
        BinaryTree root = new BinaryTree(rootVal);
        while(V-->0){
        	String path = next();
        	int val = nextInt();
        	insertNodeAtPath(root, path, val);
        }
        heightOfNode(root);
        System.out.println(diaMeter);
        
		
	}
	
	private static int heightOfNode(BinaryTree  root){
		if(root == null) return 0 ;
		if(root.getLeft()==null && root.getRight()==null) return 1 ;
		int leftHeight = heightOfNode(root.getLeft());
		int rightHeight = heightOfNode(root.getRight());
		diaMeter = Math.max(diaMeter,leftHeight + rightHeight + 1);
		return Math.max(leftHeight, rightHeight) + 1 ;
	}
	
	
	private static void insertNodeAtPath(BinaryTree root, String path, int val){
		
		int pathLength = path.length() -1;
		
		for(int i=0;i < pathLength; ++i){
			char dir = path.charAt(i);
			if(dir=='L'){
				BinaryTree leftNode = root.getLeft() ;
				if(leftNode==null){
					leftNode = new BinaryTree(0);
					root.setLeft(leftNode);
				}
				root = leftNode ;
			}else{
				BinaryTree rightNode = root.getRight();
				if(rightNode==null){
					rightNode = new BinaryTree(0);
					root.setRight(rightNode);
				}
				root = rightNode;
			}
		}
		if(path.charAt(pathLength)=='L'){
			if(root.getLeft()==null){
				root.setLeft(new BinaryTree(val));
			}else{
				root.getLeft().setVale(val);
			}
			
		}else{
			if(root.getRight()==null){
				root.setRight(new BinaryTree(val));
			}else{
				root.getRight().setVale(val);
			}
		}
	}
	
	
	private static final BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
	private static StringTokenizer st;

	private static final String next() {

		String line = "";
		while ((st == null || !st.hasMoreElements()) && line != null) {
			try {
				line = br.readLine();
				// System.out.println(line);
				if (line != null)
					st = new StringTokenizer(line);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return st.hasMoreElements() ? st.nextToken() : null;

	}

	private static long nextLong() {
		return Long.parseLong(next());
	}

	private static int nextInt() {
		return Integer.parseInt(next());
	}
}
