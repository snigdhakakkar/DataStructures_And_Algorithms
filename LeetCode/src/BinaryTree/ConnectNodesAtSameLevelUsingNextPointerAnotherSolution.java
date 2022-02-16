package BinaryTree;

public class ConnectNodesAtSameLevelUsingNextPointerAnotherSolution {
	
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
		
		connectNodesAtSameLevelUsingNextPointer(root);
		
	}
	//time complexity: O(N)*O(Nodes in a level); space complexity: O(1)
	public static void connectNodesAtSameLevelUsingNextPointer(Node node) {
		
		if(node == null) {
			return;
		}
		
		while(node != null) {
			Node tmp = node;
			
			while(tmp != null) {
				if(tmp.left != null) {
					if(tmp.right != null) {
						tmp.left.next = tmp.right;
					} else {
						tmp.left.next = getNextRight(tmp);
					}
				}
				
				if(tmp.right != null) {
					tmp.right.next = getNextRight(tmp);
				}
				tmp = tmp.next;
			}
			
			if(node.left != null) {
				node = node.left;
			} else if (node.right != null) {
				node = node.right;
			} else {
				node = getNextRight(node);
			}
		}
		
	}
	
	public static Node getNextRight(Node node) {
		Node tmp = node.next;
		
		while(tmp != null) {
			if(tmp.left != null) {
				return tmp.left;
			} else if(tmp.right != null) {
				return tmp.right;
			}
			tmp = tmp.next;
		}
		return null;
	}

}
