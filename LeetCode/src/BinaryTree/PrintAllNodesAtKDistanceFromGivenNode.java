package BinaryTree;

public class PrintAllNodesAtKDistanceFromGivenNode {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(9);
		root.left.left = a.createNewNode(3);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(10);
		root.right.right.left = a.createNewNode(4);
		
		int elements = printAllNodesAtKDistance(root, root.left.right, 2);
		
		if(elements == -1) {
			System.out.print("no elements found");
		}
		
	}
	
	public static int printAllNodesAtKDistance(Node node, Node targetNode, int k) {
		if(node == null || targetNode == null || k < 0) {
			return -1;
		}
		
		return printAllNodesAtKDistanceUtil(node, targetNode, k);
	}
	
	public static int printAllNodesAtKDistanceUtil(Node node, Node targetNode, int k) {
		if(node == null) {
			return -1;
		}
		 //when i am able to find the target node
		if(node == targetNode) {
			printNodesAtKDistanceFromParent(node, k);
			return 0;
		}
		
		//in case i am not able to find the target node, search for it in left direction
		int leftDist = printAllNodesAtKDistanceUtil(node.left, targetNode, k);
		
		if(leftDist != -1) {
			if(leftDist + 1 == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.right, k - 2 - leftDist);
			}
			return leftDist + 1;
		}
		
		int rightDist = printAllNodesAtKDistanceUtil(node.right, targetNode, k);
		
		if(rightDist != -1) {
			if(rightDist + 1 == k) {
				System.out.print(node.data + " ");
			} else {
				printNodesAtKDistanceFromParent(node.left, k - 2 - rightDist);
			}
			return rightDist + 1;
		}
		
		return -1;
	}
	
	public static void printNodesAtKDistanceFromParent(Node node, int k) {
		if(node == null) {
			return;
		}
		
		if(k == 0) {
			System.out.print(node.data + " ");
			return;
		}
		printNodesAtKDistanceFromParent(node.left, k - 1);
		printNodesAtKDistanceFromParent(node.right, k - 1);
		
	}

}
