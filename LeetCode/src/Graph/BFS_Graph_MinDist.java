package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_Graph_MinDist {
	
	List<List<Integer>> BFS_Graph_MinDist;
	boolean visited[];
	
	BFS_Graph_MinDist(int nodes){
		BFS_Graph_MinDist = new ArrayList<>();
		visited = new boolean[nodes];
		
		for(int i = 0; i < nodes; i++) {
			BFS_Graph_MinDist.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int a, int b) {
		BFS_Graph_MinDist.get(a).add(b);
	}
	
	public int minDistBetweenTwoNodes(int source, int destination) {
		if(source == destination) {
			return 0;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int minDist = 0;
		
		queue.add(source);
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size > 0) {
				Integer node = queue.poll();
				
				List<Integer> childList = BFS_Graph_MinDist.get(node);
				
				for(Integer child : childList) {
					if(child == destination) {
						return ++minDist;
					}
					
					if(!visited[child]) {
						queue.add(child);
						visited[child] = true;
					}
				}
				size--;
			}
			minDist++;
			
		}
		return -1; //in case, you cannot reach from source to destination
		
	}
	
	

}
