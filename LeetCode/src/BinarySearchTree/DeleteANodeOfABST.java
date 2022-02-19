package BinarySearchTree;

public class DeleteANodeOfABST {
	
	public static void main(String[] args) {
		
		CreateBinarySearchTree a = new CreateBinarySearchTree();
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
		
		root = delete(root, 3);
		
	}
	
	public static Node delete(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		if(val < node.data) {
			node.left = delete(node.left, val);
		} else if (val > node.data){
			node.right = delete(node.right, val);
		} else {
			if(node.left == null || node.right == null) {
				Node temp = null;
				temp = node.left == null ? node.right : node.left;
				
				if(temp == null) {
					return null;
				} else {
					return temp;
				}
			} else {
				Node successor = getSuccessor(node);
				node.data = successor.data;
				node.right = delete(node.right, 4);
				return node;
			}
		}
		return node;
		
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
