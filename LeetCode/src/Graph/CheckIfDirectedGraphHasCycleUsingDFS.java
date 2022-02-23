package Graph;

public class CheckIfDirectedGraphHasCycleUsingDFS {
	//time complexity: O(V+E); Space complexity: O(V)
	public static void main(String[] args) {
		int nodes = 5;
		
		Graph_dfsAdjList a = new Graph_dfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(2, 0);
		a.addEdge(0, 3);
		a.addEdge(1, 2);
		a.addEdge(3, 4);
		a.addEdge(4, 0);
		
		
		System.out.println(a.ifDirectedGraphHasCycle());
	}

}
