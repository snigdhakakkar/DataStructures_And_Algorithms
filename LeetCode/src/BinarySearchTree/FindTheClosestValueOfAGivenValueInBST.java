package BinarySearchTree;

public class FindTheClosestValueOfAGivenValueInBST {
	
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
		
		Node closestNode = closestValue(root, 12);
		System.out.println(closestNode.data);
	}
	
	//time complexity: O(h); space complexity: O(1)
	public static Node closestValue(Node node, int val) {
		if(node == null) {
			return null;
		}
		
		int minDiff = Integer.MAX_VALUE;
		Node closestNode = null;
		
		while(node != null) {
			int currentDiff = Math.abs(node.data - val);
			
			if(currentDiff < minDiff) {
				minDiff = currentDiff;
				closestNode = node;
			}
			
			if(val < node.data) {
				node = node.left;
			} else if (val > node.data) {
				node = node.right;
			} else {
				break;
			}
		}
		
		return closestNode;
		
		
	}

}
