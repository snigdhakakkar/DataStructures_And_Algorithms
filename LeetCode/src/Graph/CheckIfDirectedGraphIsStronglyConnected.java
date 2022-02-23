package Graph;

public class CheckIfDirectedGraphIsStronglyConnected {
	
	//time complexity: O(V * (V + E))
	public static void main(String[] args) {
		int nodes = 4;
		
		Graph_dfsAdjList a = new Graph_dfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		a.addEdge(0, 3);
		a.addEdge(3, 2);
		
		System.out.println(a.ifDirectedGraphStronglyConnected());
		
	}

}
