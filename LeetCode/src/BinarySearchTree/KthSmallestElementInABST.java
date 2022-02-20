package BinarySearchTree;

public class KthSmallestElementInABST {
	
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
		
		Node kThSmallest = getkThSmallestElement(root, 7);
		if(kThSmallest != null) {
			System.out.println(kThSmallest.data);
			} else {
				System.out.println("The kth smallest element does not exist.");
			}
	}
	
	public static int countElement = 0;
	
	public static Node getkThSmallestElement(Node node, int k) {
		if(node == null) {
			return null;
		}
		
		Node left = getkThSmallestElement(node.left, k);
		
		if(left != null) {
			return left;
		}
		
		countElement++;
		
		if(countElement == k) {
			return node;
		}
		
		return getkThSmallestElement(node.right, k);
	}
}
