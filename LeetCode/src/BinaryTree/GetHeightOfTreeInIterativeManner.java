package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class GetHeightOfTreeInIterativeManner {
	
	public static void main(String[] args) {
		BinaryTree a = new BinaryTree();
		Node root = a.createNewNode(2);
		root.left = a.createNewNode(7);
		root.right = a.createNewNode(5);
		root.left.left = a.createNewNode(2);
		root.left.right = a.createNewNode(6);
		root.left.right.left = a.createNewNode(5);
		root.left.right.right = a.createNewNode(11);
		root.right.right = a.createNewNode(9);
		root.right.right.left = a.createNewNode(4);
		
		System.out.println(getHeightOfTreeIteratively(root));
		
	}
	//time complexity: O(N); space complexity: O(N)
	public static int getHeightOfTreeIteratively(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int height = 0;
		
		while(true) {
			int count = q.size();
			if(count == 0) {
				break;
			}
			
			height = height + 1;
		
		while(count > 0) {
			Node top = q.remove();
			
			if(top.left != null) {
				q.add(top.left);
			}
			
			if(top.right != null) {
				q.add(top.right);
			}
			
			count--;
			
			}
		}
		
		return height;
	}

}
