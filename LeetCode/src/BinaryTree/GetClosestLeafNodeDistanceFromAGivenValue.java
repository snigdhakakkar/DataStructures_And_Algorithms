package BinaryTree;

public class GetClosestLeafNodeDistanceFromAGivenValue {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.left.left = a.createNewNode(4);
		root.left.right.left.left.left = a.createNewNode(3);
		
		System.out.println(getClosestLeafNodeDistance(root, 6));

	}
	
	//time complexity: O(N) * height of tree, space complexity: O(height of the tree)
	public static int getClosestLeafNodeDistance(Node node, int val) {
		
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		
		Node[] arr = new Node[10];
		return getClosestLeafNodeDistanceUtil(node, arr, val, 0);
	}
	
	public static int getClosestLeafNodeDistanceUtil(Node node, Node[] arr, int val, int level) {
		
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		
		int minDistFromLeaf = Integer.MAX_VALUE;
		
		if(node.data == val) {
			minDistFromLeaf = minimumDistanceFromNodeToLeafInDownwardDirection(node);
		
		for (int i = level - 1; i >= 0; i--) {
			minDistFromLeaf = Math.min(minDistFromLeaf, level - i + minimumDistanceFromNodeToLeafInDownwardDirection(arr[i]));
		}
		
		return minDistFromLeaf;
		}
		
		arr[level] = node;
		
		minDistFromLeaf = Math.min(minDistFromLeaf, getClosestLeafNodeDistanceUtil(node.left, arr, val, level + 1));
		
		if(minDistFromLeaf != Integer.MAX_VALUE) {
			return minDistFromLeaf;
		}
		
		return Math.min(minDistFromLeaf, getClosestLeafNodeDistanceUtil(node.right, arr, val, level + 1));
		
	}
	
	public static int minimumDistanceFromNodeToLeafInDownwardDirection(Node node) {
		
		if(node == null) {
			return Integer.MAX_VALUE;
		}
		
		if(node.left == null && node.right == null) {
			return 0;
		}
		
		return 1 + Math.min(minimumDistanceFromNodeToLeafInDownwardDirection(node.left),
				minimumDistanceFromNodeToLeafInDownwardDirection(node.right));
		
	}

}
