package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph_BFSApp {
	
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue<Integer> q;
	private char sortedArray[]; //for saving the result of topological sort


	public Graph_BFSApp() {
	vertexList = new Vertex[MAX_VERTS];
	adjMat = new int[MAX_VERTS][MAX_VERTS];
	nVerts = 0;
	q = new LinkedList<Integer>();
	sortedArray = new char[MAX_VERTS];
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		//adjMat[end][start] = 1; //it's a directed graph, so commenting this one
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
	
	public void topoSort() {
		int orig_Verts = nVerts;
		
		while(nVerts > 0) {
			int currentVertex = noSuccessors();
			if(currentVertex == -1) {
				System.out.println("Graph has cycle. Topological sort is not possible.");
				return;
			}
			
			sortedArray[nVerts - 1] = vertexList[currentVertex].label;
			
			deleteVertex(currentVertex);
		}
		
		System.out.println("Topologically sorted order: ");
		for(int j = 0; j < orig_Verts; j++) {
			System.out.print(sortedArray[j]);
		}
		
		System.out.println();
	}
	
	public int noSuccessors() {
		boolean isEdge;
		
		for(int row = 0; row < nVerts; row++) {
			isEdge = false;
			for(int col = 0; col < nVerts; col++) {
				if(adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if(!isEdge) {
				return row;
			}
		}
		return -1;
	}
	
	public void deleteVertex(int delVert) {
		if(delVert != nVerts - 1) {    //if not last vertex
			for(int j = delVert; j <nVerts - 1; j++) { //delete from vertex list
				vertexList[j] = vertexList[j + 1];
			}
			
			for(int row = delVert; row < nVerts - 1; row++) { //delete row from adjMat
				moveRowUp(row, nVerts);
			}
			
			for(int col = delVert; col < nVerts - 1; col++) { //delete column from adjMat
				moveColLeft(col, nVerts - 1);
			}
		}
		
		nVerts--; //one less vertex
	}
	
	private void moveRowUp(int row, int length) {
		for(int col = 0; col < length; col++) {
			adjMat[row][col] =  adjMat[row + 1][col];
		}
	}
	
	private void moveColLeft(int col, int length) {
		for(int row = 0; row < length; row++) {
			adjMat[row][col] =  adjMat[row][col + 1];
		}
	}

}
