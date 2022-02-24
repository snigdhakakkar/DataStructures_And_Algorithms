package Graph;

public class TopologicalSortUsingAdjList {
	
	//time complexity: O(V+E); Space complexity: O(V)
	
	public static void main(String[] args) {
		int nodes = 6;
		
		Graph_bfsAdjList a = new Graph_bfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(1, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 4);
		a.addEdge(3, 5);
		a.addEdge(4, 5);
		
		System.out.println(a.topologicalSort());
	}

}
