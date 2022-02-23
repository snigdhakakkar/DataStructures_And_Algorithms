package Graph;

public class CheckIfUndirectedGraphHasCycle {
	//time complexity: O(V+E); Space complexity: O(V)
	public static void main(String[] args) {
		int nodes = 3;
		
		Graph_dfsAdjList a = new Graph_dfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(1, 2);
		a.addEdge(2, 0);
		
		System.out.println(a.ifUndirectedGraphHasCycle());
	}

}
