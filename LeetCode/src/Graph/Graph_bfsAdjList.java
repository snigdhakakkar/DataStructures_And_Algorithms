package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph_bfsAdjList {
	
	List<List<Integer>> Graph_bfsAdjList;
	HashMap<Integer, Integer> incomingDegree;
	int visitedNodes;
	int nodes;
	Queue<Integer> sourceQueue;
	boolean visited[];
	
	Graph_bfsAdjList(int nodes){
		Graph_bfsAdjList = new ArrayList<>();
		visited = new boolean[nodes];
		incomingDegree = new HashMap<>();
		sourceQueue = new LinkedList<>();
		this.nodes = nodes;
		visitedNodes = 0;
		
		for(int i = 0; i < nodes; i++) {
			Graph_bfsAdjList.add(i, new ArrayList<>());
			incomingDegree.put(i, 0);
		}
	}
	
	public void addEdge(int a, int b) {
		Graph_bfsAdjList.get(a).add(b);
		//Graph_bfsAdjList.get(b).add(a); //if it is a directional graph, then this would get removed
		incomingDegree.put(b, incomingDegree.get(b) + 1);
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
	
	public boolean ifDirectedGraphHasCycle() {
		for(Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if(entry.getValue() == 0) {
				sourceQueue.add(entry.getKey());
			}
		}
		
		while(!sourceQueue.isEmpty()) {
			visitedNodes++;
			int source = sourceQueue.remove();
			
			List<Integer> childrenList = Graph_bfsAdjList.get(source);
			
			for(Integer child : childrenList) {
				incomingDegree.put(child, incomingDegree.get(child) - 1);
				
				if(incomingDegree.get(child) == 0) {
					sourceQueue.add(child);
				}
			}
		}
		return nodes != visitedNodes;
	}
	
	public List<Integer> topologicalSort() {
		for(Map.Entry<Integer, Integer> entry : incomingDegree.entrySet()) {
			if(entry.getValue() == 0) {
				sourceQueue.add(entry.getKey());
			}
		}
		
		List<Integer> result = new ArrayList<>();
		
		while(!sourceQueue.isEmpty()) {
			int source = sourceQueue.remove();
			result.add(source);
			
			List<Integer> childrenList = Graph_bfsAdjList.get(source);
			
			for(Integer child : childrenList) {
				incomingDegree.put(child, incomingDegree.get(child) - 1);
				
				if(incomingDegree.get(child) == 0) {
					sourceQueue.add(child);
				}
			}
		}
		
		if(result.size() != nodes) {
			System.out.println("There is a cycle in the given graph.");
			return new ArrayList<>();
		}
		
		return result;
		
	}
	
	

}
