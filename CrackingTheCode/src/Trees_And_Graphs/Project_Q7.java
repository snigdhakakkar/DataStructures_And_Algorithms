package Trees_And_Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Project_Q7 {
	public enum State {COMPLETE, PARTIAL, BLANK};
	private ArrayList<Project_Q7> children = new ArrayList<Project_Q7>();
	private HashMap<String, Project_Q7> map = new HashMap<String, Project_Q7>();
	private String name;
	private State state = State.BLANK;
	
	public Project_Q7(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public void addNeighbor(Project_Q7 node) {
		if (!map.containsKey(node.getName())) {
			children.add(node);
			map.put(node.getName(), node);
		}     
	}
	
	public ArrayList<Project_Q7> getChildren() {
		return children;
	}
	
	public State getState() { 
		return state;
	}
	
	public void setState(State st) {
		state = st;
	}
}