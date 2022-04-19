package Trees_And_Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Q4_07_Build_Order_DFS {
	
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
		String[][] dependencies = {
				{"a", "b"},
				{"b", "c"},
				{"a", "c"},
				{"d", "e"},
				{"b", "d"},
				{"e", "f"},
				{"a", "f"},
				{"h", "i"},
				{"h", "j"},
				{"i", "j"},
				{"g", "j"}};
		String[] buildOrder = buildOrderWrapper(projects, dependencies);
		if (buildOrder == null) {
			System.out.println("Circular Dependency.");
		} else {
			for (String s : buildOrder) {
				System.out.print(s + " ");
			}
		}
	}
	
	public static String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
		Stack<Project_Q7> buildOrder = findBuildOrder(projects, dependencies);
		if (buildOrder == null) return null;
		String[] buildOrderString = convertToStringList(buildOrder);
		return buildOrderString;
	}
	
	public static Stack<Project_Q7> findBuildOrder(String[] projects, String[][] dependencies) {
		Graph_Q7_M2 graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}
	
	public static String[] convertToStringList(Stack<Project_Q7> projects) {
		String[] buildOrder = new String[projects.size()];
		for (int i = 0; i < buildOrder.length; i++) {
			buildOrder[i] = projects.pop().getName();
		}
		return buildOrder;
	}
	
	/* Build the graph, adding the edge (a, b) if b is dependent on a. 
	 * Assumes a pair is listed in “build order” (which is the reverse 
	 * of dependency order). The pair (a, b) in dependencies indicates
	 * that b depends on a and a must be built before a. */
	public static Graph_Q7_M2 buildGraph(String[] projects, String[][] dependencies) {
		Graph_Q7_M2 graph = new Graph_Q7_M2();
		
		for (String[] dependency : dependencies) {
			String first = dependency[0];
			String second = dependency[1];
			graph.addEdge(first, second);
		}
		
		return graph;
	}
	
	public static boolean doDFS(Project_Q7 project, Stack<Project_Q7> stack) {
		if (project.getState() == Project_Q7.State.PARTIAL) {
			return false; //cycle
		}
		
		if (project.getState() == Project_Q7.State.BLANK) {
			project.setState(Project_Q7.State.PARTIAL);
			ArrayList<Project_Q7> children = project.getChildren();
			for (Project_Q7 child : children) {
				if (!doDFS(child, stack)) {
					return false;
				}
			}
			project.setState(Project_Q7.State.COMPLETE);
			stack.push(project);
		}
		return true;
	}
	
	public static Stack<Project_Q7> orderProjects(ArrayList<Project_Q7> projects){
		Stack<Project_Q7> stack = new Stack<Project_Q7>();
		for (Project_Q7 project : projects) {
			if (project.getState() == Project_Q7.State.BLANK) {
				if (!doDFS(project, stack)) {
					return null;
				}
			}
		}
		return stack;
	}
	

}
