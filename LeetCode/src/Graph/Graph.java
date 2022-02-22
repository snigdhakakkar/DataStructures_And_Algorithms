package Graph;

import java.util.Stack;

public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack<Integer> s;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		s = new Stack<Integer>();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void dfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		s.push(0);
		
		while(!s.isEmpty()) {
			int v = getAdjUnvisitedVertex(s.peek());
			
			if(v == -1) {
				s.pop();
			} else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				s.push(v);
			}
		}
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label + " ");
	}
	
	public int getAdjUnvisitedVertex(int v) {
		for(int j = 0; j < nVerts; j++) {
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
				return j;
			}
		}
		return -1;
	}
}
