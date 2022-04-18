package Trees_And_Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Q4_03_List_of_Depths_BFS {
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		/* "Visit" the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			result.add(current);// Add previous level
			LinkedList<TreeNode> parents = current; // Go to next level
			
			current = new LinkedList<TreeNode>();
			for (TreeNode parent : parents) {
				/* Visit the children */
				if(parent.left != null) {
					current.add(parent.left);
				} 
				if (parent.right != null){
					current.add(parent.right);
				}
			}
			    
		}
		
		return result;
	}
	
	public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> i = entry.listIterator();
			System.out.print("Link list at depth " + depth + ":");
			while(i.hasNext()) {
				System.out.print(" " + ((TreeNode)i.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	
	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = createTreeFromArray(nodes_flattened);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);
		
	}
	
	/* Creates tree by mapping the array left to right, top to bottom. */
	public static TreeNode createTreeFromArray(int[] array) {
		if (array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			java.util.Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while (!done) {
				TreeNode r = (TreeNode) queue.element();
				if (r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if (r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if (i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
	}
	
	

}
