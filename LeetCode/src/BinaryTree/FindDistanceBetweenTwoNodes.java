package BinaryTree;

public class FindDistanceBetweenTwoNodes {
	
	public static void main(String[] args) {
		
		BinaryTree a = new BinaryTree();
		
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(15);
		root.left.right.right = a.createNewNode(1);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		System.out.println(findDistanceBetweenTwoNodes(root, 10, 1));
	}
	
	//time complexity: O(N); Space complexity: O(1)
	public static int findDistanceBetweenTwoNodes(Node node, int n1, int n2){
		
		if(node == null) {
			return -1;
		}
		
		Node lca = printLCA(node, n1, n2);
		
		if(lca == null) {
			return -1;
		}
		
		int d1 = distanceFromParentToNode(lca, n1, 0);
		int d2 = distanceFromParentToNode(lca, n2, 0);
		
		return d1 + d2;
	}
	
	public static int distanceFromParentToNode(Node node, int val, int distance) {
		
		if(node == null) {
			return -1;
		}
		
		if(node.data == val) {
			return distance;
		}
		
		int d = distanceFromParentToNode(node.left, val, distance + 1);
		if(d != -1) {
			return d;
		}
		
		d = distanceFromParentToNode(node.right, val, distance + 1);
		return d;
	}
	
	public static boolean ifn1exists = false;
	public static boolean ifn2exists = false;
	
	public static Node printLCA(Node node, int n1, int n2) {
		
		Node lca = printLCAUtil(node, n1, n2);
		
		if(ifn1exists && ifn2exists) {
			return lca;
		} else {
			return null;
		}
	}
	
	public static Node printLCAUtil(Node node, int n1, int n2) {
		if(node == null) {
			return null;
		}
		
		if(node.data == n1) {
			ifn1exists = true;
			return node;
		}
		
		if(node.data == n2) {
			ifn2exists = true;
			return node;
		}
		
		Node leftLCA = printLCAUtil(node.left, n1, n2);
		Node rightLCA = printLCAUtil(node.right, n1, n2);
		
		if(leftLCA != null && rightLCA != null) {
			return node;
		}
		
		return leftLCA != null ? leftLCA : rightLCA;
	}
}
