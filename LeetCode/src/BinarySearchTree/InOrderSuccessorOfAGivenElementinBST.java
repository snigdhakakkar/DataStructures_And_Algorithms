package BinarySearchTree;

public class InOrderSuccessorOfAGivenElementinBST {
	
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
		
		Node InorderSuccessorNode = getInOrderSuccessor(root, 7);
		if(InorderSuccessorNode != null) {
			System.out.println(InorderSuccessorNode.data);
		} else {
			System.out.println("Inorder successor does not exist.");
		}
		
	}
	
	public static Node getInOrderSuccessor(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		Node InorderSuccessor = null;
		
		while(node != null) {
			if(val < node.data) {
				InorderSuccessor = node;
				node = node.left;
			} else if (val > node.data) {
				node = node.right;
			} else {
				if(node.right != null) {
					InorderSuccessor = getSuccessor(node);
				}
				break;
			}
		}
		return node != null ? InorderSuccessor : null;
	}
	
	public static Node getSuccessor(Node node) {
		if(node == null) {
			return null;
		}
		
		Node temp = node.right;
		
		while(temp.left != null) {
			temp = temp.left;
		}
		
		return temp;
	}
	

}
