package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph_MST_Weighted {
	
	List<List<Edge_Dijkstra>> graph;
	boolean visited[];
	int nodes;
	
	Graph_MST_Weighted(int nodes){
		graph = new ArrayList<>();
		visited = new boolean[nodes];
		this.nodes = nodes;
		
		for(int i = 0; i < nodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int sourceNode, int targetNode, int distance) {
		graph.get(sourceNode).add(new Edge_Dijkstra(targetNode, distance));
		graph.get(targetNode).add(new Edge_Dijkstra(sourceNode, distance)); //commenting this for directed graph
	}
	
	public int mst() {
		int minCost = 0;
		
		for(int i = 0; i < nodes; i++) {  //to cover the case of unconnected graphs
			if(!visited[i]) {
				minCost = minCost + minSpanningTreeWeightedGraph(i);
			}
		}
		
		return minCost;
		
	}
	
	public int minSpanningTreeWeightedGraph(int source) {
		
		PriorityQueue<Edge_Dijkstra> minEdgeHeap = new PriorityQueue<>((e1, e2) -> e1.distanceFromNode - e2.distanceFromNode);
		
		visited[source] = true;
		List<Edge_Dijkstra> childOfSource = graph.get(source);
		
		for(Edge_Dijkstra edge : childOfSource) {
			minEdgeHeap.add(edge);
		}
		
		int minimumCost = 0;
		while(!minEdgeHeap.isEmpty()) {
			
			Edge_Dijkstra minValueEdge = minEdgeHeap.poll();
			
			if(visited[minValueEdge.targetNode]) {
				continue;
			}
			
			visited[minValueEdge.targetNode] = true;
			
			minimumCost = minimumCost + minValueEdge.distanceFromNode;
			
			List<Edge_Dijkstra> childList = graph.get(minValueEdge.targetNode);
			
			for(Edge_Dijkstra edge : childList) {
				if(!visited[edge.targetNode]) {
					minEdgeHeap.add(edge);
				}
			}
		}
		
		return minimumCost;
	}
	
	

}
