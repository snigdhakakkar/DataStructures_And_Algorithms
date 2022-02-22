package Graph;

public class DepthFirstSearchUsingAdjacencyMatrix {
	
	/*Properties of depth first search algorithm - first we go into the depth of one element and 
	then we traverse to the other element
	* e.g. first we go A - B - C and then we move back to D - E - F
	*/
	
	//Each vertex has two properties: first label such as A, B and C ; second, the visited flag - boolean, by default all are false
	
	/*Edges - represented in adjacency matrix as 1 if there is an edge between A (index 0) and B (index 1); 
	 * then a01 = a10 = 1 in adjacency matrix
	*/
	
	//time complexity for depth first search: O(V + E)
	public static void main(String[] args) {
		
		Graph_DFSApp theGraph = new Graph_DFSApp();
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
		theGraph.dfs();
		System.out.println();
	}
	
	
	
	

}
