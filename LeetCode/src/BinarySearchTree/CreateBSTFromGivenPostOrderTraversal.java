package BinarySearchTree;

public class CreateBSTFromGivenPostOrderTraversal {
	
	public static void main(String[] args) {
		
		Node root = null;
		
		int[] postOrder = {2, 5, 9, 8, 4, 12, 20, 15, 10};
		
		root = createBST(postOrder, 0, postOrder.length - 1);
		printAllElementsInorder(root);
	}
	
	//time complexity: O(N), space complexity: O(1)
	public static Node createBST(int[] arr, int start, int end) {
		
		if(start > end) {
			return null;
		}
		
		Node node = CreateBinarySearchTree.createNewNode(arr[end]);
		
		
		int i;
		for(i = end - 1; i >= start; i--) {
			if(arr[i] < node.data) {
			break;
			}
		}
		
		node.left = createBST(arr, start, i);
		
		node.right = createBST(arr, i + 1, end - 1);
		
		return node;
	}
	
	
	
	public static void printAllElementsInorder(Node node) {
		if (node == null) {
			return;
		}
		
		printAllElementsInorder(node.left);
		System.out.print(node.data + " ");
		printAllElementsInorder(node.right);
	}

}
