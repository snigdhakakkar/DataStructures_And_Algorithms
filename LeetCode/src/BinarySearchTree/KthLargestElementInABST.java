package BinarySearchTree;

public class KthLargestElementInABST {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 1);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		Node kThLargest = getkThLargestElement(root, 1);
		if(kThLargest != null) {
			System.out.println(kThLargest.data);
			} else {
				System.out.println("The kth largest element does not exist.");
			}
	}
	
	public static int countElement = 0;
	
	public static Node getkThLargestElement(Node node, int k) {
		if(node == null) {
			return null;
		}
		
		Node right = getkThLargestElement(node.right, k);
		
		if(right != null) {
			return right;
		}
		
		countElement++;
		
		if(countElement == k) {
			return node;
		}
		
		return getkThLargestElement(node.left, k);
	}

}
