package Trees_And_Graphs;

public class Q4_05_Validate_BST_Method2 {
	//Time complexity: O(N), space complexity: O(logN)
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
	
	public static boolean isBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	public static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		
		if (!checkBST(n.left, min, n.data) ||
				!checkBST(n.right, n.data, max)) {
				return false;
			}   
		
		return true;
		
	}

}
