package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFSApp {
	
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue<Integer> q;


	public Graph_BFSApp() {
	vertexList = new Vertex[MAX_VERTS];
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	q = new LinkedList<Integer>();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
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
	
	public void bfs() {
		vertexList[0].wasVisited = true;
		displayVertex(0);
		q.add(0);
		int v2;
		
		while(!q.isEmpty()) {
			int v1 = q.remove();
			while((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				q.add(v2);
			}
		}
	}

}
