package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_bfsAdjList {
	
	List<List<Integer>> Graph_bfsAdjList;
	boolean visited[];
	
	Graph_bfsAdjList(int nodes){
		Graph_bfsAdjList = new ArrayList<>();
		visited = new boolean[nodes];
		
		for(int i = 0; i < nodes; i++) {
			Graph_bfsAdjList.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int a, int b) {
		Graph_bfsAdjList.get(a).add(b);
		Graph_bfsAdjList.get(b).add(a); //if it is a directional graph, then this would get removed
	}
	
	public void bfs(int startIndex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(startIndex);
		visited[startIndex] = true;
		
		while(!queue.isEmpty()) {
			Integer node = queue.poll();
			System.out.print(node + " ");
			
			List<Integer> neighborList = Graph_bfsAdjList.get(node);
			
			for(Integer neighbor : neighborList) {
				if(!visited[neighbor]) {
					queue.add(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}
	
	

}
