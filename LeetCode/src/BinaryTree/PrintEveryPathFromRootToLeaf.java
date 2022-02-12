package BinaryTree;

public class PrintEveryPathFromRootToLeaf {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(12);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		printEachPathFromRootToLeaf(root);
		
	}
	
	//time complexity: O(N); space complexity: O(N)
	public static void printEachPathFromRootToLeaf(Node node) {
		if(node == null) {
			return;
		}
		
		int[] arr = new int[15];
		printRootToLeaf(node, arr, 0);
	}
	
	private static void printRootToLeaf(Node node, int[] arr, int index) {
		if(node == null) {
			return;
		}
		
		arr[index] = node.data;
		
		if(node.left == null && node.right == null) {
			printArray(arr, index);
		}
		
		printRootToLeaf(node.left, arr, index + 1);
		printRootToLeaf(node.right, arr, index + 1);
	}
	
	private static void printArray(int[] arr, int index) {
		for(int i = 0; i <= index; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
	}
	
		

}
