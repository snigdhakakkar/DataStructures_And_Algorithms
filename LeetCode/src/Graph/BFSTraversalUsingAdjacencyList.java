package Graph;

public class BFSTraversalUsingAdjacencyList {
	
	//time complexity: O(V+E), Space complexity: O(V)
	public static void main(String[] args) {
		int nodes = 6;
		
		Graph_bfsAdjList a = new Graph_bfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 4);
		a.addEdge(2, 5);
		a.addEdge(4, 5);
		
		a.bfs(0);
		
		
	}

}
