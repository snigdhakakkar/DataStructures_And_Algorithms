package BinaryTree;

public class GetWidthOfALevelInBinaryTree {
	
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
		
		System.out.println(getWidth(root, 2));
		System.out.println(getWidth(root, 3));
		
	}
	//Time complexity = O(N), Space complexity = O(1)
	public static int getWidth(Node node, int level) {
		if(node == null) {
			return 0;
		}
		
		if(level == 1) {
			return 1;
		}
		
		return getWidth(node.left, level - 1) + getWidth(node.right, level - 1);
		
	}

}
