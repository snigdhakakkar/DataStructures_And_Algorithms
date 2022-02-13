package BinaryTree;

public class FindIfGivenSequenceIsARootToLeafPath {
	
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
		
		int[] seq = {2, 7, 6, 1};
		
		System.out.println(findIfGivenSequenceIsARootToLeafPath(root, seq, 0));
		
	}
	
	//time complexity: O(N); space complexity: O(1)
	public static boolean findIfGivenSequenceIsARootToLeafPath(Node node, int[] seq, int index) {
		if(node == null) {
			return false;
		}
		
		if(index >= seq.length || node.data != seq[index]) {
			return false;
		}
		
		if(node.left == null && node.right == null && index == seq.length - 1) {
			return true;
		}
		
		return findIfGivenSequenceIsARootToLeafPath(node.left, seq, index + 1)
				|| findIfGivenSequenceIsARootToLeafPath(node.right, seq, index + 1);
		
	}

}
