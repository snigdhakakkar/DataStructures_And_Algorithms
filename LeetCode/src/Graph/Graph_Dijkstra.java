package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_Dijkstra {
	
	List<List<Edge_Dijkstra>> graph;
	boolean visited[];
	int distance[];
	
	Graph_Dijkstra(int nodes){
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		distance = new int[nodes];
		
		for(int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
			distance[i] = Integer.MAX_VALUE; 
		}
	}
	
	public void addEdge(int sourceNode, int targetNode, int distance) {
		graph.get(sourceNode).add(new Edge_Dijkstra(targetNode, distance));
		//graph.get(targetNode).add(new Edge_Dijkstra(sourceNode, distance)); //commenting this for directed graph
	}
	
	public int minDistBetweenTwoNodes(int source, int destination) {
		if(source == destination) {
			return 0;
		}
		
		PriorityQueue<Edge_Dijkstra> minHeap = new PriorityQueue<>((e1, e2) -> e1.distanceFromNode - e2.distanceFromNode);
		
		distance[source] = 0;
		minHeap.add(new Edge_Dijkstra(0,0));
		
		while (!minHeap.isEmpty()) {
			int v = minHeap.poll().targetNode;
			if(visited[v]) {
				continue;
			}
			
			visited[v] = true;
			
			List<Edge_Dijkstra> childList = graph.get(v);
			
			for(Edge_Dijkstra child : childList) {
				int dist = child.distanceFromNode;
				int childNode = child.targetNode;
				
				if(!visited[childNode] && (distance[v] + dist < distance[childNode])) {
					distance[childNode] = distance[v] + dist;
					child.distanceFromNode = distance[v] + dist;
					minHeap.add(child);
				}
			}
		}
		
		return distance[destination];
		
	}

}
