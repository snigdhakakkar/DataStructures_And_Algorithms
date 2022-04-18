package Trees_And_Graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Q4_01_Route_Between_Nodes_BFS {
	
	public static void main(String[] args) {
		Graph g = new Graph();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node1.addAdjacent(node2);
		node1.addAdjacent(node3);
		node1.addAdjacent(node4);
		node3.addAdjacent(node5);
		
		g.addNode(node1);
		
		System.out.println("Is Route exists : " + Q4_01_Route_Between_Nodes_BFS.search(g, node1, node5));
	}
	
	public static boolean search(Graph g, Node start, Node end) {
		if(start == end) {
			return true;
		}
		
		//using Linkedlist as a queue because we are conducting breadth-first search in this scenario
		
		LinkedList<Node> queue = new LinkedList<Node>();
		start.visit();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Node current = queue.remove();
			System.out.println("current node = " + current.data);
			if(current.getAdjacent() != null) {
				Iterator<Node> nodeIterator = current.getAdjacent().iterator();
				
				while(nodeIterator.hasNext()) {
					Node neighbor = nodeIterator.next();
					System.out.println("neighbor node = " + neighbor.data);
					if(!neighbor.visited) {
						if(neighbor == end) {
							return true;
						} else {
							neighbor.visit();
							queue.add(neighbor);
						}
					}
				}
					
			}      
			current.visit();
		}
		return false;
	}

}
