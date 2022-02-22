package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph_dfsAdjList {
	
	List<List<Integer>> Graph_dfsAdjList;
	boolean visited[];
	
	Graph_dfsAdjList(int nodes){
		Graph_dfsAdjList = new ArrayList<>();
		visited = new boolean[nodes];
		
		for(int i = 0; i < nodes; i++) {
			Graph_dfsAdjList.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int a, int b) {
		Graph_dfsAdjList.get(a).add(b);
		Graph_dfsAdjList.get(b).add(a); //if it is a directional graph, then this would get removed
	}
	
	public void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		
		stack.push(start);
		visited[start] = true;
		
		while(!stack.isEmpty()) {
			Integer node = stack.pop();
			System.out.print(node + " ");
			
			List<Integer> neighborlist = Graph_dfsAdjList.get(node);
			
			for(Integer neighbor : neighborlist) {
				if(!visited[neighbor]) {
					stack.push(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}

}
