package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Graph_dfsAdjList {
	
	List<List<Integer>> Graph_dfsAdjList;
	boolean visited[], recursiveStack[];
	int nodes;
	
	Graph_dfsAdjList(int nodes){
		Graph_dfsAdjList = new ArrayList<>();
		visited = new boolean[nodes];
		recursiveStack = new boolean[nodes];
		this.nodes = nodes;
		
		for(int i = 0; i < nodes; i++) {
			Graph_dfsAdjList.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int a, int b) {
		Graph_dfsAdjList.get(a).add(b);
		//Graph_dfsAdjList.get(b).add(a); //if it is a directional graph, then this would get removed
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
		System.out.println();
	}
	
	public boolean ifGraphConnected() {
		int startIndex = 0;
		this.dfs(startIndex);
		
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean ifDirectedGraphStronglyConnected() {
		
		for(int i = 0; i < nodes; i++) {
			dfs(i);
			
			for(int j = 0; j < nodes; j++) {
				if(!visited[j]) {
					return false;
				}
			}
			Arrays.fill(visited, false);
		}
		return true;
	}
	
	//Another way to implement depth first search using recursion
	public void dfsAnother(int start) {
		visited[start] = true;
		
		List<Integer> neighborlist = Graph_dfsAdjList.get(start);
		for(Integer neighbor : neighborlist) {
			if(!visited[neighbor]) {
				dfsAnother(neighbor);
			}
		}
	}
	
	public int numberOfConnectedComponent() {
		int numberOfConnectedComponent = 0;
		
		for(int i = 0; i < nodes; i++) {
			if(!visited[i]) {
				dfs(i);
				numberOfConnectedComponent++;
			}
		}
		return numberOfConnectedComponent;
	}
	
	public boolean ifSourceToDestinationIsReachable(int source, int destination) {
		dfs(source);
		
		return visited[destination];
	}
	
	public boolean ifSourceConnectedToDestination(int source, int destination) {
		dfs(source);
		
		return visited[destination];
	}
	
	public boolean ifUndirectedGraphHasCycle() {
		for(int i = 0; i < nodes; i++) {
			if(!visited[i]) {
				if(dfs_withParent(i, -1)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean dfs_withParent(int index, int parent) {
		visited[index] = true;
		
		List<Integer> neighborlist = Graph_dfsAdjList.get(index);
		for(Integer neighbor : neighborlist) {
			if(!visited[neighbor]) {
				dfs_withParent(neighbor, index);
			} else if(neighbor != parent) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public boolean ifDirectedGraphHasCycle() {
		
		for(int i = 0; i < nodes; i++) {
			if(dfs_ifCycleExists(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean dfs_ifCycleExists(int index) {
		if(recursiveStack[index]) {
			return true;
		}
		
		if(visited[index]) {
			return false;
		}
		
		visited[index] = true;
		recursiveStack[index] = true;
		
		List<Integer> neighborlist = Graph_dfsAdjList.get(index);
		
		for(Integer neighbor : neighborlist) {
			if(dfs_ifCycleExists(neighbor)) {
				return true;
			}
		}
		
		recursiveStack[index] = false;
		return false;
		
	}

}
