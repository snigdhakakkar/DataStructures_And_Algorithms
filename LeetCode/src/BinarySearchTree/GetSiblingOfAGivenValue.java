package BinarySearchTree;

public class GetSiblingOfAGivenValue {
	
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
		
		Node sibling = printSiblingOfAGivenValue(root, 1);
		
		if(sibling != null) {
			System.out.println(sibling.data);
		} else {
			System.out.println("sibling is null");
		}
		
	}
	
	
	//time complexity: O(logN), Space complexity: O(1)
	public static Node printSiblingOfAGivenValue(Node node, int val) {
		
		if(node == null || node.data == val) {
			return null;
		}
		
		Node parentNode = null;
		
		while(node != null) {
			if(val > node.data) {
				parentNode = node;
				node = node.right;
			} else if (val < node.data) {
				parentNode = node;
				node = node.left;
			} else {
				break;
			}
			
		}
		
		if(parentNode.left != null && val == parentNode.left.data) {
			return parentNode.right;
		} 
		
		if(parentNode.right != null && val == parentNode.right.data) {
			return parentNode.left;
		} 
		
		return null;
	
	}

}
