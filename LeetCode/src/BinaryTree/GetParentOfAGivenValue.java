package BinaryTree;

public class GetParentOfAGivenValue {
	
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
		
		Node parent = printParentOfAGivenValue(root, 6);
		if(parent != null) {
			System.out.println(parent.data);
		} else {
			System.out.println("parent is null");
		}
		
	}
	
	//Time complexity: O(N), Space complexity: O(1)
	public static Node printParentOfAGivenValue(Node node, int val) {
		
		if(node == null || node.data == val) {
			return null;
		}
		
		if((node.left != null && node.left.data == val) || 
				(node.right != null && node.right.data == val)) {
			return node;
		}
		
		Node l = printParentOfAGivenValue(node.left, val);
		
		if(l != null) {
			return l;
		}
		
		l = printParentOfAGivenValue(node.right, val);
		return l;
	}

}
