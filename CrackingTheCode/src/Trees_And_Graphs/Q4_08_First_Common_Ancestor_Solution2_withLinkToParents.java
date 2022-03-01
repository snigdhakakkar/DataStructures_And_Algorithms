package Trees_And_Graphs;

public class Q4_08_First_Common_Ancestor_Solution2_withLinkToParents {
	//time complexity: O(t) where t is the size of subtree for the first common ancestor (worst case: O(N))
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//check if either node is not in the tree, or if one covers the other
		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}
		
		//traverse upwards until you find a node that covers q
		TreeNode sibling = getSibling(p);
		TreeNode parent = p.parent;
		while (!covers(sibling, q)) {
			sibling = getSibling(parent);
			parent = parent.parent;
		}
		return parent;
	}
	
	public static boolean covers(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		
		return covers(root.left, p) || covers(root.right, p); 
	}
	
	public static TreeNode getSibling(TreeNode node) {
		if (node == null || node.parent == null) {
			return null;
		}
		TreeNode parent = node.parent;
		return parent.left == node ? parent.right : parent.left;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n3 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor(root, n3, n7);
		System.out.println(ancestor.data);
	}

}
