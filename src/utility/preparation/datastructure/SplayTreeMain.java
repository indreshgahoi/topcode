package utility.preparation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/* Balance Tree Problem
 * http://www.codechef.com/problems/CARDSHUF/
 * this can be solve by Treap Or SkipList method Or
 * LinkCutTree
 */

public class SplayTreeMain {

	public static void main(String[] args) {

		InputStream inputstream = System.in;
		// OutputStream outputstraem=System.out;
		InputReader in = InputReader.getInputReader(inputstream);
		// PrintWriter out= new PrintWriter(outputstraem);
		int n = in.nextInt(), m = in.nextInt(), a, b, c;
		SplayTree Tr, Ta, Tb, Tc;
		Tr = new SplayTree(1, n);
		for (int i = 1; i <= m; i++) {
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			// Tr.printTree();
			// Node p=sptree.search(2);
			// System.out.println("left:"+p.left.key+"right:"+p.right.key+" value:"+p.value);

			Ta = Tr.detach(a);
			// Ta.printTree();

			Tb = Tr.detach(b);
			// Tb.printTree();

			Tr = SplayTree.megre(Ta, Tr);
			Tc = Tr.detach(c);

			Tb.reverse();
			Tr = SplayTree.megre(Tb, Tr);
			Tr = SplayTree.megre(Tc, Tr);

			// sptree.delete(p);
		}
		Tr.printTree();
		System.out.println("");
	}

}

class Node {
	int key;
	int value;
	int size;
	boolean reverse;
	Node left;
	Node right;
	Node parent;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.size = 1;
		reverse = false;
		left = right = parent = null;
	}

	void setSize() {
		int size = 1;
		if (this.left != null) size += this.left.size;
		if (this.right != null) size += this.right.size;
		this.size = size;
	}

	int getSize() {
		return this.size;
	}

	boolean isLeft() {
		if (this.parent == null) return false;
		return (this == (this.parent.left));
	}

	boolean isRight() {
		if (this.parent == null) return false;
		return (this == (this.parent.right));
	}

	void setLeft(Node node) {
		if (node != null) {
			node.parent = this;
			this.size += node.size;
		}
		this.left = node;

	}

	void setRight(Node node) {
		if (node != null) {
			node.parent = this;
			this.size += node.size;
		}
		this.left = node;
	}

	public static int getSize(Node p) {
		return p == null ? 0 : p.getSize();
	}

}

class SplayTree {
	Node root = null;

	public SplayTree(int l, int r) {
		this.root = build(l, r);
	}

	public SplayTree(Node tree) {
		this.root = tree;
	}

	public void reverse() {
		if (this.root == null) return;
		this.root.reverse = !this.root.reverse;
	}

	public static void resolve(Node p) {
		if (p == null) return;
		if (p.reverse) {
			p.reverse = false;
			if (p.left != null) p.left.reverse = !p.left.reverse;
			if (p.right != null) p.right.reverse = !p.right.reverse;
			// exchange p.left and p.right
			Node temp = p.right;
			p.right = p.left;
			p.left = temp;
		}
	}

	/*  T=Merge(n1,n2), After traversing T in inorder n1 should display first;
	 *  set n1 as a left son of minimum node of n2;
	 *  So we neen to resolve all lazy operation   
	 */
	public static SplayTree megre(SplayTree T1, SplayTree T2) {
		Node n2 = T2.root;
		Node n1 = T1.root;
		if (n1 == null) return new SplayTree(n2);
		if (n2 == null) return new SplayTree(n1);

		resolve(n2);
		while (n2.left != null) {
			n2 = n2.left;
			resolve(n2);
		}
		// System.out.println("n2.key="+n2.key);
		// System.out.println("n2.left="+n2.left.key);
		// System.out.println("n2.right="+n2.right.key);

		T2.splay(n2);
		n2.left = n1;
		n1.parent = n2;
		n2.setSize();
		return new SplayTree(n2);
	}

	void leftRotate(Node x) {
		Node y = x.right;
		resolve(x.parent);
		resolve(x);
		resolve(y);
		x.right = y.left;
		if (y.left != null) y.left.parent = x;
		y.parent = x.parent;
		if (x.parent == null) this.root = y;
		else if (x.isLeft()) x.parent.left = y;
		else x.parent.right = y;
		y.left = x;
		x.parent = y;
		x.setSize();
		y.setSize();
		if (y.parent != null) y.parent.setSize();

	}

	void rightRotate(Node x) {
		Node y = x.left;
		resolve(x.parent);
		resolve(x);
		resolve(y);
		x.left = y.right;
		if (y.right != null) y.right.parent = x;
		y.parent = x.parent;
		if (x.parent == null) this.root = y;
		else if (x.isLeft()) {
			x.parent.left = y;
		} else x.parent.right = y;
		y.right = x;
		x.parent = y;
		x.setSize();
		y.setSize();
		if (y.parent != null) y.parent.setSize();

	}

	void splay(Node x) {
		if (this.root == x || x == null) {
			return;
		}
		Node p = x.parent;
		Node g = p.parent;
		// Zig Rotation
		if (p == this.root) {
			if (x.isLeft()) rightRotate(p);
			else leftRotate(p);
		}
		// Performing Zig-Zig and Zig-Zag
		else {
			if (x.isLeft() && p.isLeft())// Zig-Zig
			{
				rightRotate(g);
				rightRotate(p);
			} else if (x.isRight() && p.isRight()) { // Zig-Zig
				leftRotate(g);
				leftRotate(p);
			} else if (x.isRight() && p.isLeft()) { // Zig-Zag
				leftRotate(p);
				rightRotate(g);
			} else if (x.isLeft() && p.isRight()) { // Zig-Zag
				rightRotate(p);
				leftRotate(g);
			}
		}
		splay(x);
	}

	void insert(int key, int value) {
		Node x = new Node(key, value);

		if (this.root == null) {
			this.root = x;
			return;
		}
		Node current = this.root, pre = null;

		while (current != null) {
			pre = current;
			if (x.key <= current.key) current = current.left;
			else current = current.right;
		}

		if (pre.key <= x.key) {
			pre.setLeft(x);
		} else pre.setRight(x);
		splay(x);

	}

	Node search(int key) {
		if (this.root == null || this.root.key == key) return this.root;
		Node current = this.root, pre = null;
		while (current != null && current.key != key) {
			pre = current;
			if (key < current.key) current = current.left;
			else current = current.right;
		}
		if (current != null) splay(current);
		else splay(pre);
		return current;
	}

	/*
	 * Transplant replaces the subtree rooted at node u , with the subtree rooted at v,
	 *  node u's parent becomes node v's parent
	 */

	void transplant(Node u, Node v) {
		Node p = u.parent;
		if (p == null) {
			this.root = v;
			if (v != null) v.parent = null;
		} else if (u.isLeft()) p.setLeft(v);
		else p.setRight(v);

	}

	Node minimum(Node tree) {
		while (tree.left != null)
			tree = tree.left;
		return tree;
	}

	void delete(Node z) {
		if (z.left == null) {
			transplant(z, z.right);
		} else if (z.right == null) {
			transplant(z, z.left);
		} else {
			Node y = minimum(z.right);
			if (y.parent != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.parent = y;
			y.left.setSize();
			y.right.setSize();
			y.setSize();
			// y.parent.setSize();
		}
	}

	SplayTree detach(int k) {
		Node front = null, curr;
		if (k == 0) return new SplayTree(front);
		if (Node.getSize(this.root) == k) {
			front = this.root;
			this.root = null;
			return new SplayTree(front);
		}

		k = k + 1;
		resolve(this.root);
		curr = this.root;
		int curr_size = Node.getSize(curr.left);
		while ((curr_size + 1) != k) {
			if (curr_size >= k) {
				curr = curr.left;
			} else {
				k -= curr_size + 1;
				resolve(curr);
				curr = curr.right;
			}
			resolve(curr);
			curr_size = Node.getSize(curr.left);
		}
		splay(curr);
		front = curr.left;
		curr.left = null;
		front.parent = null;
		curr.setSize();
		return new SplayTree(front);
	}

	Node build(int l, int r) {
		if (l > r) return null;
		int m = (l + r) >> 1;
		Node u = new Node(m, m);
		u.left = build(l, m - 1);
		u.right = build(m + 1, r);

		if (u.left != null) {
			u.size += u.left.size;
			u.left.parent = u;
		}
		if (u.right != null) {
			u.size += u.right.size;
			u.right.parent = u;
		}
		u.parent = null;
		return u;
	}

	void printTree() {
		printTreeUtil(root);
	}

	private void printTreeUtil(Node tree) {
		if (tree != null) {
			resolve(tree);
			printTreeUtil(tree.left);
			// System.out.println("Node["+tree.key+":"+tree.value+"]");
			System.out.print(tree.value + " ");
			printTreeUtil(tree.right);
		}
	}

}

class InputReader {
	BufferedReader br;
	StringTokenizer st;
	static InputReader input;

	private InputReader(InputStream stream) {
		br = new BufferedReader(new InputStreamReader(stream));
		input = this;
		st = null;
	}

	public static InputReader getInputReader(InputStream stream) {
		if (input == null) input = new InputReader(stream);
		return input;
	}

	public static InputReader getInputReader() {
		return input;
	}

	public String next() {

		String line = "";
		while ((st == null || !st.hasMoreElements()) && line != null) {
			try {
				line = br.readLine();
				if (line != null) st = new StringTokenizer(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}

		}
		return st.hasMoreElements() ? st.nextToken() : null;

	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}
