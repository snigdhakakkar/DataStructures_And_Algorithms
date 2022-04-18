package Trees_And_Graphs;

public class Q4_05_Validate_BST_Method1 {
	//Time complexity: O(N), space complexity: O(1)
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);
		
		inorder(root);
		
		System.out.println();
		
		System.out.println(isBST(root));
		
	}
	
	public static void inorder(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
		      
	}

	public static TreeNode prev = null;
	
	public static boolean isBST(TreeNode node) {
		if(node == null) {
			return true;
		}
		
		if(!isBST(node.left)) {
			return false;
		}
		
		if(prev != null && prev.data > node.data) {
			return false;
		}
		prev = node;
		
		return isBST(node.right);
	}

}
