package BinaryTree;

public class FindLowestCommonAncestor {
	
	public static boolean ifn1exists = false;
	public static boolean ifn2exists = false;
	
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
		
		Node LCA = a.printLCA(root, 15, 1);
		if(LCA != null) {
			System.out.println(LCA.data);
			} else {
				System.out.println("LCA is null");
			}
	}
	
	public Node printLCA(Node node, int n1, int n2) {
		
		Node lca = this.printLCAUtil(node, n1, n2);
		
		if(ifn1exists && ifn2exists) {
			return lca;
		} else {
			return null;
		}
	}
	
	public Node printLCAUtil(Node node, int n1, int n2) {
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
