package BinaryTree;

public class CheckIfTwoTreesAreMirrorStructureToEachOther {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root1 = a.createNewNode(2);
		root1.left = a.createNewNode(7);
		root1.right = a.createNewNode(5);
		root1.left.left = a.createNewNode(2);
		root1.left.right = a.createNewNode(6);
		root1.left.right.left = a.createNewNode(5);
		root1.left.right.right = a.createNewNode(11);
		root1.right.right = a.createNewNode(9);
		root1.right.right.left = a.createNewNode(4);
		
		Node root2 = a.createNewNode(2);
		root2.right = a.createNewNode(7);
		root2.left = a.createNewNode(5);
		root2.right.right =  a.createNewNode(12);
		root2.right.left = a.createNewNode(6);
		root2.right.left.right = a.createNewNode(15);
		root2.right.left.left = a.createNewNode(21);
		root2.left.left = a.createNewNode(19);
		root2.left.left.right = a.createNewNode(4);
		
		System.out.println(ifMirrorStructuresOfEachOther(root1, root2));
		
	}
	
	//Time complexity: O(N); Space complexity: O(1)
		public static boolean ifMirrorStructuresOfEachOther(Node node1, Node node2) {
			
			if(node1 == null && node2 == null) {
				return true;
			}
			
			if(node1 == null || node2 == null) {
				return false;
			}
			
			return ifMirrorStructuresOfEachOther(node1.left, node2.right)
					&& ifMirrorStructuresOfEachOther(node1.right, node2.left);
		}

}
