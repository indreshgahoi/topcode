package utility.preparation.string;

import java.util.ArrayList;
import java.util.Arrays;

class Tries {
	public static final int ALPHABETS = 26;
	private Tries[] children;
	private boolean isEnd;
	boolean isTaken;
	Integer idx;
	Integer countWords;
	Integer countPrefixs;

	public Tries() {
		children = new Tries[ALPHABETS];
		isEnd = false;
		countWords = 0;
		countPrefixs = 0;
		isTaken = false;
	}

	private void addWordHelper(char[] word, Integer idx, Integer i) {
		Tries node = this.children[word[idx] - 'a'];
		if (node == null) {
			node = new Tries();
			this.children[word[idx] - 'a'] = node;
		}
		node.countPrefixs = this.countPrefixs + 1;
		if (word.length == (idx + 1)) {
			node.isEnd = true;
			node.countWords++;
			node.idx = i;
			node.isTaken = false;
		} else {
			node.addWordHelper(word, idx + 1, i);
		}
	}

	public void addWord(String word, Integer i) {

		char[] ch = word.toCharArray();
		addWordHelper(ch, 0, i);

	}

	private Tries helperFind(char[] word, int idx) {
		boolean res = false;
		Tries t = null;
		Tries node = this.children[word[idx] - 'a'];
		if (node == null) {
			res = false;
			return node;
		}
		if ((idx + 1) == word.length) {
			res = node.isEnd;
			if (res) {
				t = node;
			}
		} else {
			t = node.helperFind(word, idx + 1);
		}
		return t;
	}

	public Tries find(String word) {
		char[] ch = word.toCharArray();
		if (ch.length == 0)
			return null;
		return helperFind(ch, 0);
	}

	String traverse(ArrayList<Character> list) {

		String tree = "";
		if (this.isEnd) {
			tree = "\n" + list.toString();
		}

		char ch = 'a';
		for (int i = 0; i < ALPHABETS; i++, ch++) {
			Tries t = children[i];

			if (t != null) {
				list.add(ch);
				tree += t.traverse(list);
				list.remove(list.size() - 1);
			}
		}
		return tree;
	}

	public String toString() {
		String tree = "";
		tree = "Tree= \n" + traverse(new ArrayList<Character>());
		return tree;
	}

	public static void main(String[] args) {
		Tries tries = new Tries();
		tries.addWord("indresh", 1);
		tries.addWord("sanjay", 2);
		tries.addWord("sandeep", 3);

		System.out.println(tries);
	}

}

class Solution {

	public ArrayList<String> anagrams(String[] strs) {
		Integer cnt = 0;
		Tries t = new Tries();
		ArrayList<String> sol = new ArrayList<String>();
		for (int i = 0; i < strs.length; i++) {
			char[] ch = strs[i].toCharArray();
			if (ch.length == 0) {
				cnt++;
				continue;
			}

			Arrays.sort(ch, 0, ch.length);
			String s = new String(ch);

			Tries f = t.find(s);
			if (f == null) {
				t.addWord(s, i);

			} else {
				if (!f.isTaken) {
					f.isTaken = true;
					sol.add(strs[f.idx]);
				}
				sol.add(strs[i]);

			}

		}
		if (cnt > 1)
			for (int i = 0; i < cnt; i++)
				sol.add("");
		System.out.println(t);
		return sol;

	}

	public static void main(String[] args) {
		Solution sol = new Solution();

		String[] strs = new String[] { "and", "dan" };
		System.out.println(sol.anagrams(strs));
	}

}