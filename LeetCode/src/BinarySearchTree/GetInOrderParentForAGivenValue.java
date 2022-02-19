package BinarySearchTree;

public class GetInOrderParentForAGivenValue {
	
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
		
		Node InorderParentNode = getInOrderParentnode(root, 14);
		if(InorderParentNode != null) {
			System.out.println(InorderParentNode.data);
		} else {
			System.out.println("Inorder parent does not exist.");
		}
		
	}
	
	//time complexity: O(logN), Space complexity: O(1)
	public static Node getInOrderParentnode(Node node, int val) {
		if(node == null || node.data == val) {
			return null;
		}
		
		Node inorderParent = null;
		
		while(node != null) {
			if(val > node.data) {
				node = node.right;
			} else if (val < node.data) {
				inorderParent = node;
				node = node.left;
			} else {
				break;
			}
		
		
		}
		
		return node != null ? inorderParent : null;
		
	}

}
