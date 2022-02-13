package BinaryTree;

public class PrintAncestorsOfAGivenValue {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(1);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		System.out.println(printAncestorsOfAGivenValue(root, 6));
		
	}
	
	//time complexity: O(N); space complexity: O(1)
	public static boolean printAncestorsOfAGivenValue(Node node, int val) {
		
		if(node == null) {
			return false;
		}
		
		if(node.data == val) {
			return true;
		}
		
		if(printAncestorsOfAGivenValue(node.left, val) || printAncestorsOfAGivenValue(node.right, val)) {
			System.out.println(node.data);
			return true;
		}
		
		return false;
	}

}
