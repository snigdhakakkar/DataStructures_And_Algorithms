package BinaryTree;

public class PrintNodesAtKDistanceFromLeafNodes {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		
		printAllNodesAtKDistanceFromLeafNodes(root, 1);

	}
	
	public static void printAllNodesAtKDistanceFromLeafNodes(Node node, int k) {
		if(node == null || k < 0) {
			return;
		}
		
		int[] arr = new int[20];
		boolean[] visited = new boolean[20];
		
		printAllNodesAtKDistanceFromLeafNodesUtil(node, k, arr, visited, 0); // here, 0 is the array index
	}
	
	public static void printAllNodesAtKDistanceFromLeafNodesUtil(Node node, int k, int[] arr, boolean[] visited, int count) {
		if(node == null) {
			return;
		}
		
		arr[count] = node.data;
		visited[count] = false;
		
		if(node.left == null && node.right == null && count - k >= 0 && visited[count - k] == false) {
			System.out.print(arr[count - k] + " ");
			visited[count - k] = true;
			return;
		}
		
		printAllNodesAtKDistanceFromLeafNodesUtil(node.left, k, arr, visited, count + 1);
		printAllNodesAtKDistanceFromLeafNodesUtil(node.right, k, arr, visited, count + 1);
	}
	
	public static int getHeightOfTheTree(Node node) {
		//height is the maximum number of edges from leaf node to the given node
		if(node == null) {
			return -1;
		}
		
		return max(getHeightOfTheTree(node.left), getHeightOfTheTree(node.right)) + 1;
	}
	
	private static int max(int a, int b) {
		return a > b ? a : b;
	}

}
