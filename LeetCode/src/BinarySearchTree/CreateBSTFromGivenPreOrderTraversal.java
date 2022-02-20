package BinarySearchTree;

public class CreateBSTFromGivenPreOrderTraversal {
	
	public static void main(String[] args) {
		
		Node root = null;
		
		int[] preOrder = {10, 4, 2, 8, 5, 9, 15, 12, 20};
		
		root = createBST(preOrder, 0, preOrder.length - 1);
		printAllElementsInorder(root);
	}
	
	//time complexity: O(N), space complexity: O(1)
	public static Node createBST(int[] arr, int start, int end) {
		if(start > end) {
			return null;
		}
		
		Node node = CreateBinarySearchTree.createNewNode(arr[start]);
		
		
		int i;
		for(i = start + 1; i <= end; i++) {
			if(arr[i] > node.data) {
			break;
			}
		}
		
		node.left = createBST(arr, start + 1, i - 1);
		
		node.right = createBST(arr, i , end );
		
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
