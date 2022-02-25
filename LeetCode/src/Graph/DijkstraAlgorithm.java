package Graph;

/*used to find the minimum distance from source to destination in a weighted graph (applicable in both 
 * directed and undirected graph)
*/

//Priority queue(minimum heap)


public class DijkstraAlgorithm {
	
	//time complexity: O(ElogE); Space complexity: O(E) + O(V)
		public static void main(String[] args) {
			int nodes = 5;
			
			Graph_Dijkstra a = new Graph_Dijkstra(nodes);
			
			a.addEdge(0, 1, 1);
			a.addEdge(0, 2, 7);
			a.addEdge(1, 2, 5);
			a.addEdge(1, 4, 4);
			a.addEdge(4, 3, 2);
			a.addEdge(2, 3, 6);
			
			System.out.println(a.minDistBetweenTwoNodes(0,4));
		}

}
