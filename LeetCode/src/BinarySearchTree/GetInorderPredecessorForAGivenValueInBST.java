package BinarySearchTree;

public class GetInorderPredecessorForAGivenValueInBST {
	
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
		
		Node inorderPredecessor = getInorderPredecessorForAGivenValue(root, 10);
		if(inorderPredecessor != null) {
			System.out.print(inorderPredecessor.data);
		} else {
			System.out.println("There is no such value.");
		}
		
	}
	
	//time complexity: O(h), where h is the height of BST i.e. logN; space complexity: O(1) if we don't consider recursion stack
	public static Node getInorderPredecessorForAGivenValue(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		Node inorderpredecessor = null;
		
		while(node != null) {
			if( val < node.data) {
				node = node.left;
			} else if ( val > node.data) {
				inorderpredecessor = node;
				node = node.right;
			} else {
				if(node.left != null) {
					inorderpredecessor = getPredecessor(node);
				}
				break;
			}
		}
		
		return node != null ? inorderpredecessor : null;
	}
	
	public static Node getPredecessor(Node node) {
		if(node == null) {
			return null;
		}
		
		Node temp = node.left;
		
		while(temp.right != null) {
			temp = temp.right;
		}
		
		return temp;
	}

}
