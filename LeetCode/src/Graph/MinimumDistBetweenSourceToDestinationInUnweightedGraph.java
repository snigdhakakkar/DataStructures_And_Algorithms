package Graph;


//unweighted graph implicates that each edge has 1 unit distance
public class MinimumDistBetweenSourceToDestinationInUnweightedGraph {
	
	//time complexity: O(V + E); Space complexity: O(V)
	public static void main(String[] args) {
		int nodes = 6;
		
		BFS_Graph_MinDist a = new BFS_Graph_MinDist(nodes);
		
		a.addEdge(0, 1);
		a.addEdge(0, 3);
		a.addEdge(1, 2);
		a.addEdge(3, 4);
		a.addEdge(2, 4);
		a.addEdge(4, 5);
		
		System.out.println(a.minDistBetweenTwoNodes(0,5));
	}

}
