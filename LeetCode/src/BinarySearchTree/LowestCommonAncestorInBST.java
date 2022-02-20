package BinarySearchTree;

public class LowestCommonAncestorInBST {
	
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
		
		Node LCA = getLCA(root, 14, 10);
		if(LCA != null) {
			System.out.println(LCA.data);
			} else {
				System.out.println("LCA is null");
			}
		
	}
	
	public static Node getLCA(Node node, int n1, int n2) {
		if(node == null) {
			return null;
		}
		
		while(node != null) {
			if(node.data > n1 && node.data > n2) {
				node = node.left;
			} else if (node.data < n1 && node.data < n2) {
				node = node.right;
			} else {
				break;
			}
		}
		
		return node;
	}



}
