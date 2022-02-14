package BinaryTree;

public class GetSiblingOfAGivenValue {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(1);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		Node sibling = printSiblingOfAGivenValue(root, 1);
		if(sibling != null) {
			System.out.println(sibling.data);
		} else {
			System.out.println("sibling is null");
		}
	}
	
	//Time complexity: O(N), Space complexity: O(1)
		public static Node printSiblingOfAGivenValue(Node node, int val) {
			
			if(node == null || node.data == val) {
				return null;
			}
			
			if(node.left != null && node.left.data == val)  {
				return node.right;
			}
			
			if(node.right != null && node.right.data == val) {
				return node.left;
			}
			
			Node l = printSiblingOfAGivenValue(node.left, val);
			
			if(l != null) {
				return l;
			}
			
			l = printSiblingOfAGivenValue(node.right, val);
			return l;
		}


}
