package BinaryTree;

public class CheckIfEachNodeContainsTheSumOfLeftAndRightSubtree {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(104);
		root.left = a.createNewNode(43);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(9);
		root.left.left = a.createNewNode(17);
		root.left.right = a.createNewNode(13);
		root.left.right.left = a.createNewNode(3);
		root.left.right.right = a.createNewNode(10);
		
		System.out.println(ifSumTree(root)); //sum tree
	}
	
	//time complexity: O(N), space complexity: O(1)
	public static boolean ifSumTree(Node node) {
		
		if(node == null || ifLeafNode(node)) {
			return true;
		}
		
		int leftSum;
		int rightSum;
		
		if(ifSumTree(node.left) && ifSumTree(node.right)) {
			if(node.left == null) {
				leftSum = 0;
			}
			else if (ifLeafNode(node.left)) {
				leftSum = node.left.data;
			} else {
				leftSum = 2 * (node.left.data);
			}
			
			if(node.right == null) {
				rightSum = 0;
			}
			else if (ifLeafNode(node.right)) {
				rightSum = node.right.data;
			} else {
				rightSum = 2 * (node.right.data);
			}
			
			if((node.data == rightSum + leftSum)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public static boolean ifLeafNode(Node node) {
		if(node == null) {
			return false;
		}
		
		if(node.left == null && node.right == null) {
			return true;
		}
		
		return false;
	}

}
