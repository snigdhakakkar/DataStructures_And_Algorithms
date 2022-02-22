package Graph;

//data structure used would be List<List<Integer>> 
//will use a stack and a boolean array for DFS
public class DFSTraversalUsingAdjacencyList {
	
	//time complexity: O(V+E), Space complexity: O(V+E)
	public static void main(String[] args) {
		int nodes = 7;
		
		Graph_dfsAdjList a = new Graph_dfsAdjList(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(1, 3);
		a.addEdge(2, 4);
		a.addEdge(3, 5);
		a.addEdge(4, 5);
		a.addEdge(4, 6);
		
		a.dfs(0);
	}
	
	

}
