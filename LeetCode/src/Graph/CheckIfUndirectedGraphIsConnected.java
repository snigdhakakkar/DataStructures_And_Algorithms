package Graph;

public class CheckIfUndirectedGraphIsConnected {
	
	//time complexity: O(V+E)
	public static void main(String[] args) {
		int nodes = 7;
		
		Graph_dfsAdjList a = new Graph_dfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(1, 3);
		a.addEdge(2, 4);
		a.addEdge(3, 5);
		a.addEdge(4, 5);
		//a.addEdge(4, 6);
		
		System.out.println(a.ifGraphConnected());
		
	}


}
