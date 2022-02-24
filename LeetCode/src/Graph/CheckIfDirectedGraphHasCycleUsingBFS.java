package Graph;

/*
 * Steps:
 * 1. Adjacency list
 * 2.Get the number of incoming nodes for each vertex
 * 3. Initialize a queue and a counter variable - visitedNodes
 * 4. Move any index (vertex) to queue that has 0 incoming nodes
 * 5. Remove it from the queue and we can deduce that
 * there is no cycle from this node with 0 incoming nodes. 
 * 6. Reduce the number of incoming nodes of all its children by 1.
 * 7.Add its children's index to the queue if the incoming nodes reduce to 0 for them
 * 8. Increment the visitedNodes variable each time an index gets added to the queue
 * 9. If the visitedNodes count equals the number of nodes, then we can be certain that there is no cycle.
 */
public class CheckIfDirectedGraphHasCycleUsingBFS {
	
	//time complexity: O(V+E); Space complexity: O(V)
		public static void main(String[] args) {
			int nodes = 5;
			
			Graph_bfsAdjList a = new Graph_bfsAdjList(nodes);
			
			a.addEdge(0, 1);
			a.addEdge(1, 2);
			a.addEdge(2, 0);
			a.addEdge(3, 0);
			
			System.out.println(a.ifDirectedGraphHasCycle());
			
		}

}
