package Graph;

/*
 * Minimum spanning tree is the minimum cost which covers all the nodes in the weighted graph
 */
public class MinimumSpanningTreeInWeightedGraph {
	
	//time complexity: O(ElogE); Space complexity: O(E) + O(V) ~ O(E)
			public static void main(String[] args) {
				int nodes = 5;
				
				Graph_MST_Weighted a = new Graph_MST_Weighted(nodes);
				
				a.addEdge(0, 1, 6);
				a.addEdge(0, 3, 4);
				a.addEdge(1, 2, 10);
				a.addEdge(1, 3, 7);
				a.addEdge(1, 4, 7);
				a.addEdge(2, 3, 8);
				a.addEdge(2, 4, 5);
				a.addEdge(3, 4, 12);
				
				System.out.println(a.mst());
			}

}
