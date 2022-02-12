package BinaryTree;

public class CreateTreeFromInorderAndPreorder {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = null;
		
		int[] inOrder = {7, 4, 3, 2, 8};
		
		int[] preOrder = {2, 4, 7, 3, 8};
		
		root = buildTreeFromInorderAndPreorder(preOrder, inOrder, 0, inOrder.length - 1);
		a.inorder(root);
	}
	
	public static int preIndex;
	
	//time complexity: O(N^2); space complexity: O(N)
	public static Node buildTreeFromInorderAndPreorder(int[] preOrder, int[] inOrder, int start, int end) {
		if(start > end) {
			return null;
		}
		
		Node node = createNewNode(preOrder[preIndex++]);
		
		if(start == end) {
			return node;
		}
		
		int inOrderIndex = getInOrderIndex(node.data, inOrder, start, end);
		
		node.left = buildTreeFromInorderAndPreorder(preOrder, inOrder, start, inOrderIndex - 1 );
		node.right = buildTreeFromInorderAndPreorder(preOrder, inOrder,inOrderIndex + 1, end );
		
		return node;
		
	}
	
	public static int getInOrderIndex(int val, int[] inOrder, int start, int end) {
		for(int i = 0; i < inOrder.length; i++) {
			if(inOrder[i] == val) {
				return i;
			}
		}
		return -1;
	}
	
	public static Node createNewNode(int val) {
		Node a = new Node();
		
		a.data = val;
		a.left = null;
		a.right = null;
		return a;
	}

}
