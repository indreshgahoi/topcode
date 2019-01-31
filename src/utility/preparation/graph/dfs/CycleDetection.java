package utility.preparation.graph.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
 * 
 *  Cycle Detection Directed Graph
 * 
 * 
 * 
 */

class Node {
	int color;
	int id;
	Node parent;
	ArrayList<Node> edage;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id:" + id;
	}
}

class CycleDetection {

	HashSet<Node> nodes = new HashSet<Node>();

	ArrayList<Node> G;
	Node cycleStart;
	Node cycleEnd;

	void find_cycle() {
		for (Node n : G) {
			n.color = 0;
		}
		cycleStart = null;
		cycleEnd = null;

		for (Node n : G) {
			if (dfs(n))
				break;
		}
		if (cycleStart == null) {
			System.out.println("Acyclic");
		} else {
			System.out.println("Cyclic");
			ArrayList<Node> cycle = new ArrayList<>(10);
			cycle.add(cycleStart);
			while (cycleEnd != cycleStart) {
				cycle.add(cycleEnd);
				cycleEnd = cycleEnd.parent;
			}
			cycle.add(cycleStart);
			Collections.reverse(cycle);
			for (Node it : cycle) {
				System.out.println(it + "->");
			}
		}
	}

	boolean dfs(Node node) {
		node.color = 1;
		for (Node ch : node.edage) {
			if (ch.color == 0) {
				ch.parent = node;
				if (dfs(ch))
					return true;
			} else if (ch.color == 1) {
				cycleStart = ch;
				cycleEnd = node;
				return true;
			}
		}
		node.color = 2;
		return false;
	}

}
