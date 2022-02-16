package BinaryTree;

public class GetAverageOfAllNodes {
	
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
		
		getAverage(root);
		System.out.println(sum /count);

	}
	
	public static int sum = 0;
	public static int count = 0;
	
	
	//Time complexity: O(N), space complexity: O(1)
	public static void getAverage(Node node) {
		if(node == null) {
			return;
		}
		
		sum = sum + node.data;
		count = count + 1;
		
		getAverage(node.left);
		getAverage(node.right);
		
	}

}
