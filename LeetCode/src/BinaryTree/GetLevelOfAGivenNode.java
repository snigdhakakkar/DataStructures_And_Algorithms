package BinaryTree;

public class GetLevelOfAGivenNode {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		System.out.println(getLevelOfAGivenNode(root, 7, 1));
		
	}
	
	public static int getLevelOfAGivenNode(Node node, int val, int level) {
		if(node == null) {
			return 0;
		}
		
		int l;
		
		if(node.data == val) {
			return level;
		}
		
		l = getLevelOfAGivenNode(node.left, val, level + 1); 
		
		if(l != 0) {
			return l;
		}
		
		l = getLevelOfAGivenNode(node.right, val, level + 1); 
		
		return l;
		
	}

}
