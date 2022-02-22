package Graph;

public class BreadthFirstSearchUsingAdjacencyMatrix {
	
	/*
	 * first we search all the neighbors, and then we go in deep level
	 * this algorithm can be used for a graph or for a tree
	 */
	
	//time complexity: O(V+E)
	public static void main(String[] args) {
		
		Graph_BFSApp theGraph = new Graph_BFSApp();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		
		theGraph.addEdge(0, 1);
		theGraph.addEdge(1, 2);
		theGraph.addEdge(0, 3);
		theGraph.addEdge(3, 4);
		theGraph.addEdge(4, 5);
		theGraph.addEdge(1, 3);
		
		System.out.println("Vists: ");
		theGraph.bfs();
		System.out.println();
		
	}

}
