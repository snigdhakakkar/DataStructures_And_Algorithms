package Graph;

public class CheckIfSourceToDestinationPathExistsInDirectedGraph {
	//time complexity: O(V+E); Space complexity: O(V)
	public static void main(String[] args) {
		int nodes = 5;
		
		Graph_dfsAdjList a = new Graph_dfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		a.addEdge(3, 2);
		a.addEdge(3, 0);
		a.addEdge(2, 4);
		
		System.out.println(a.ifSourceConnectedToDestination(0,3));
		System.out.println();
		System.out.println(a.ifSourceToDestinationIsReachable(0,2));
	}

}
