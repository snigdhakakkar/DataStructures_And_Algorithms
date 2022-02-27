package Trees_And_Graphs;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
	
	public T data;
	public boolean visited;
	private Set<Node<T>> adjacent = new HashSet();
	
	public Node(T data) {
		this.data = data;
	}
	
	public Set<Node<T>> getAdjacent(){
		return adjacent;
	}
	
	public T getData() {
		return data;
	}
	
	//returns true if the nodes was added, false if already there
	public boolean addAdjacent(Node<T> node) {
		return adjacent.add(node);
	}
	
	//returns true if any of the nodes were added
	public boolean addAdjacents(Set<Node<T>> nodes) {
		return adjacent.addAll(nodes);
	}
	
	public void visit() {
		visited = true;
	}

}
