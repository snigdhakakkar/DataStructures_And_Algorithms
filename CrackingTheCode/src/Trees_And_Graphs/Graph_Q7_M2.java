package Trees_And_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph_Q7_M2 {
	
	private ArrayList<Project_Q7> nodes = new ArrayList<Project_Q7>();
	private HashMap<String, Project_Q7> map = new HashMap<String, Project_Q7>();
	
	public Project_Q7 getOrCreateNode(String name) {
		if (!map.containsKey(name)) {
			Project_Q7 node = new Project_Q7(name);
			nodes.add(node);
			map.put(name, node);
		}
		return map.get(name);
	}
	
	public void addEdge(String startName, String endName) {
		Project_Q7 start = getOrCreateNode(startName);
		Project_Q7 end = getOrCreateNode(endName);
		start.addNeighbor(end);
	}
	
	public ArrayList<Project_Q7> getNodes() {
		return nodes;
	}   

}
