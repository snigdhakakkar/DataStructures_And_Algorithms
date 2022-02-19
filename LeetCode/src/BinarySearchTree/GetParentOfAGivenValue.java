package BinarySearchTree;

public class GetParentOfAGivenValue {
	
	public static void main(String[] args) {
		
		Node root = null;
		//8, 3, 6, 10, 4, 7, 1, 14, 13
		root = CreateBinarySearchTree.insert(root, 8);
		root = CreateBinarySearchTree.insert(root, 3);
		root = CreateBinarySearchTree.insert(root, 6);
		root = CreateBinarySearchTree.insert(root, 10);
		root = CreateBinarySearchTree.insert(root, 4);
		root = CreateBinarySearchTree.insert(root, 7);
		root = CreateBinarySearchTree.insert(root, 1);
		root = CreateBinarySearchTree.insert(root, 14);
		root = CreateBinarySearchTree.insert(root, 13);
		
		Node parentNode = getParentnode(root, 6);
		if(parentNode != null) {
			System.out.println(parentNode.data);
		} else {
			System.out.println("No matching value found.");
		}
		
	}
	
	//time complexity: O(logN) , space complexity: O(1)
	public static Node getParentnode(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		Node parentNode = null;
		
		while(node != null) {
			if(val > node.data) {
				parentNode = node;
				node = node.right;
			} else if (val < node.data) {
				parentNode = node;
				node = node.left;
			} else {
				break;
			}
			
		}
		
		return node != null ? parentNode : null;
	}

}
