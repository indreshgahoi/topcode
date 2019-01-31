package utility.interviewbit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<>();
		}
	};

	Map<Integer, UndirectedGraphNode> visitedNode = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (visitedNode.containsKey(node.label)) {
			return visitedNode.get(node.label);
		}
		final UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

		for (UndirectedGraphNode child : node.neighbors) {
			newNode.neighbors.add(cloneGraph(child));
		}
		return newNode;

	}

}
