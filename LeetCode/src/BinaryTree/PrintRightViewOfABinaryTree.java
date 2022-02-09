package BinaryTree;

public class PrintRightViewOfABinaryTree {
	
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
		
		rightViewOfTree(root, 0);
	}
	
	public static int maxLevel;
	public static void rightViewOfTree(Node node, int level) {
		if(node == null) {
			return;
		}
		
		if(level >= maxLevel) {
			System.out.print(node.data + " ");
			maxLevel++;
		}
		
		rightViewOfTree(node.right, level + 1);
		rightViewOfTree(node.left, level + 1);
	}

}
