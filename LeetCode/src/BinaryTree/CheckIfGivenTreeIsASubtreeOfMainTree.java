package BinaryTree;

public class CheckIfGivenTreeIsASubtreeOfMainTree {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.right.right = a.createNewNode(3);
		root.left.left = a.createNewNode(10);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		
		Node root1 = a.createNewNode(6);
		root1.left = a.createNewNode(5);
		root1.right = a.createNewNode(11);;
		
		System.out.println(ifASubTreeOfMainTree(root, root1));
		
		System.out.println(ifASubTreeOfMainTreeOptimized(root, getNumberOfNodes(root) , root1, getNumberOfNodes(root1) ));
		
	}
	
	//this method checks for identical subtrees at each node and thus time complexity is O(N^2)
	public static boolean ifASubTreeOfMainTree(Node main, Node sub) {
		
		if(sub == null) {
			return true;
		}
		
		if(main == null) {
			return false;
		}
		
		if(ifIdenticalTrees(main, sub)) {
			return true;
		}
		
		return ifASubTreeOfMainTree(main.left, sub) || ifASubTreeOfMainTree(main.right, sub);
		
	}
	
	public static boolean ifIdenticalTrees(Node a, Node b) {
		if(a == null && b == null) {
			return true;
		}
		
		if(a == null || b == null) {
			return false;
		}
		
		return a.data == b.data && ifIdenticalTrees(a.left, b.left) && ifIdenticalTrees(a.right, b.right);
	}
	//time complexity: O(N), space complexity: O(N)
	public static boolean ifASubTreeOfMainTreeOptimized(Node main, int mainTreeNodes, Node sub, int subTreeNodes){
		if(sub == null) {
			return true;
		}
		
		if(main == null) {
			return false;
		}
		
		int mainInorder[] = new int[mainTreeNodes];
		inrorderFillArray(main, mainInorder);
		i = 0;
		
		int subInorder[] = new int[subTreeNodes];
		inrorderFillArray(sub, subInorder);
		i = 0;
		
		String mainInorderString = arrayToString(mainInorder);
		String subInorderString = arrayToString(subInorder);
		
		if(!mainInorderString.contains(subInorderString)) {
			return false;
		}
		
		int mainPreorder[] = new int[mainTreeNodes];
		preorderFillArray(main, mainPreorder);
		i = 0;
		
		int subPreorder[] = new int[subTreeNodes];
		preorderFillArray(sub, subPreorder);
		i = 0;
		
		String mainPreorderString = arrayToString(mainPreorder);
		String subPreorderString = arrayToString(subPreorder);
		
		return mainPreorderString.contains(subPreorderString);
		
	}
	
	public static int i;
	
	public static void inrorderFillArray(Node node, int a[]) {
		
		if(node == null) {
			return;
		}
		
		inrorderFillArray(node.left, a);
		
		a[i++] = node.data;
		
		inrorderFillArray(node.right, a);
		
	}
	
	public static void preorderFillArray(Node node, int a[]) {
		
		if(node == null) {
			return;
		}
		
		a[i++] = node.data;
		
		preorderFillArray(node.left, a);
		
		preorderFillArray(node.right, a);
	}
	
	public static String arrayToString(int a[]) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i];
		}
		
		return s;
	}
	
	public static int getNumberOfNodes(Node node) {
		if(node == null) {
			return 0;
		}
		
		return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
	}
	
}
